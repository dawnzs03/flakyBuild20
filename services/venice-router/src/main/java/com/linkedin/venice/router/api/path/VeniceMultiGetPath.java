package com.linkedin.venice.router.api.path;

import static com.linkedin.venice.router.api.VenicePathParser.TYPE_STORAGE;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;

import com.linkedin.alpini.netty4.misc.BasicFullHttpRequest;
import com.linkedin.alpini.router.api.RouterException;
import com.linkedin.venice.HttpConstants;
import com.linkedin.venice.read.RequestType;
import com.linkedin.venice.read.protocol.request.router.MultiGetRouterRequestKeyV1;
import com.linkedin.venice.router.RouterThrottleHandler;
import com.linkedin.venice.router.api.RouterExceptionAndTrackingUtils;
import com.linkedin.venice.router.api.RouterKey;
import com.linkedin.venice.router.api.VenicePartitionFinder;
import com.linkedin.venice.router.api.VenicePathParser;
import com.linkedin.venice.router.stats.AggRouterHttpRequestStats;
import com.linkedin.venice.router.stats.RouterStats;
import com.linkedin.venice.schema.avro.ReadAvroProtocolDefinition;
import com.linkedin.venice.serializer.FastSerializerDeserializerFactory;
import com.linkedin.venice.serializer.RecordDeserializer;
import com.linkedin.venice.serializer.RecordSerializer;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.apache.avro.io.OptimizedBinaryDecoderFactory;


public class VeniceMultiGetPath extends VeniceMultiKeyPath<MultiGetRouterRequestKeyV1> {
  private static final String ROUTER_REQUEST_VERSION =
      Integer.toString(ReadAvroProtocolDefinition.MULTI_GET_ROUTER_REQUEST_V1.getProtocolVersion());

  private static final RecordSerializer<MultiGetRouterRequestKeyV1> MULTI_GET_ROUTER_REQUEST_KEY_V1_SERIALIZER =
      FastSerializerDeserializerFactory.getAvroGenericSerializer(MultiGetRouterRequestKeyV1.getClassSchema());

  protected static final ReadAvroProtocolDefinition EXPECTED_PROTOCOL =
      ReadAvroProtocolDefinition.MULTI_GET_CLIENT_REQUEST_V1;

  private static final RecordDeserializer<ByteBuffer> EXPECTED_PROTOCOL_DESERIALIZER =
      FastSerializerDeserializerFactory.getAvroGenericDeserializer(EXPECTED_PROTOCOL.getSchema());

  public VeniceMultiGetPath(
      String storeName,
      int versionNumber,
      String resourceName,
      BasicFullHttpRequest request,
      VenicePartitionFinder partitionFinder,
      int maxKeyCount,
      boolean smartLongTailRetryEnabled,
      int smartLongTailRetryAbortThresholdMs,
      RouterStats<AggRouterHttpRequestStats> stats,
      int longTailRetryMaxRouteForMultiKeyReq) throws RouterException {
    super(
        storeName,
        versionNumber,
        resourceName,
        smartLongTailRetryEnabled,
        smartLongTailRetryAbortThresholdMs,
        longTailRetryMaxRouteForMultiKeyReq);

    // Validate API version
    int apiVersion = Integer.parseInt(request.headers().get(HttpConstants.VENICE_API_VERSION));
    if (apiVersion != EXPECTED_PROTOCOL.getProtocolVersion()) {
      throw RouterExceptionAndTrackingUtils.newRouterExceptionAndTracking(
          Optional.of(getStoreName()),
          Optional.of(getRequestType()),
          BAD_REQUEST,
          "Expected api version: " + EXPECTED_PROTOCOL.getProtocolVersion() + ", but received: " + apiVersion);
    }

    Iterable<ByteBuffer> keys;
    byte[] content;

    if (request.hasAttr(RouterThrottleHandler.THROTTLE_HANDLER_BYTE_ATTRIBUTE_KEY)) {
      content = request.attr(RouterThrottleHandler.THROTTLE_HANDLER_BYTE_ATTRIBUTE_KEY).get();
    } else {
      content = new byte[request.content().readableBytes()];
      request.content().readBytes(content);
    }

    keys = deserialize(content);
    initialize(storeName, resourceName, keys, partitionFinder, maxKeyCount, stats);
  }

  VeniceMultiGetPath(
      String storeName,
      int versionNumber,
      String resourceName,
      Map<RouterKey, MultiGetRouterRequestKeyV1> routerKeyMap,
      boolean smartLongTailRetryEnabled,
      int smartLongTailRetryAbortThresholdMs,
      int longTailRetryMaxRouteForMultiKeyReq) {
    super(
        storeName,
        versionNumber,
        resourceName,
        smartLongTailRetryEnabled,
        smartLongTailRetryAbortThresholdMs,
        routerKeyMap,
        longTailRetryMaxRouteForMultiKeyReq);
    setPartitionKeys(routerKeyMap.keySet());
  }

  @Nonnull
  @Override
  public String getLocation() {
    return TYPE_STORAGE + VenicePathParser.SEP + getResourceName();
  }

  @Override
  public final RequestType getRequestType() {
    return isStreamingRequest() ? getStreamingRequestType() : RequestType.MULTI_GET;
  }

  @Override
  public final RequestType getStreamingRequestType() {
    return RequestType.MULTI_GET_STREAMING;
  }

  /**
   * If the parent request is a retry request, the sub-request generated by scattering-gathering logic should be retry
   * request as well.
   *
   * @param routerKeyMap
   * @return
   */
  protected VeniceMultiGetPath fixRetryRequestForSubPath(Map<RouterKey, MultiGetRouterRequestKeyV1> routerKeyMap) {
    VeniceMultiGetPath subPath = new VeniceMultiGetPath(
        storeName,
        versionNumber,
        getResourceName(),
        routerKeyMap,
        isSmartLongTailRetryEnabled(),
        getSmartLongTailRetryAbortThresholdMs(),
        getLongTailRetryMaxRouteForMultiKeyReq());
    subPath.setupRetryRelatedInfo(this);
    return subPath;
  }

  @Override
  protected MultiGetRouterRequestKeyV1 createRouterRequestKey(ByteBuffer key, int keyIdx, int partitionId) {
    MultiGetRouterRequestKeyV1 routerRequestKey = new MultiGetRouterRequestKeyV1();
    routerRequestKey.keyBytes = key;
    routerRequestKey.keyIndex = keyIdx;
    routerRequestKey.partitionId = partitionId;
    return routerRequestKey;
  }

  @Override
  protected byte[] serializeRouterRequest() {
    return MULTI_GET_ROUTER_REQUEST_KEY_V1_SERIALIZER.serializeObjects(routerKeyMap.values());
  }

  private static Iterable<ByteBuffer> deserialize(byte[] content) {
    return EXPECTED_PROTOCOL_DESERIALIZER.deserializeObjects(
        OptimizedBinaryDecoderFactory.defaultFactory().createOptimizedBinaryDecoder(content, 0, content.length));
  }

  @Override
  public String getVeniceApiVersionHeader() {
    return ROUTER_REQUEST_VERSION;
  }
}
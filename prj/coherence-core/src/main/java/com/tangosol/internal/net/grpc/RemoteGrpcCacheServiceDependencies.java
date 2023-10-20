/*
 * Copyright (c) 2000, 2023, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * https://oss.oracle.com/licenses/upl.
 */
package com.tangosol.internal.net.grpc;

import com.tangosol.config.expression.Expression;

import com.tangosol.internal.net.service.extend.remote.RemoteCacheServiceDependencies;

import com.tangosol.internal.util.DaemonPoolDependencies;

import com.tangosol.net.grpc.GrpcChannelDependencies;

/**
 * The RemoteGrpcCacheServiceDependencies interface provides a gRPC
 * RemoteCacheService with its external dependencies.
 *
 * @author Jonathan Knight  2022.08.25
 * @since 22.06.2
 */
public interface RemoteGrpcCacheServiceDependencies
        extends RemoteGrpcServiceDependencies
    {
    }

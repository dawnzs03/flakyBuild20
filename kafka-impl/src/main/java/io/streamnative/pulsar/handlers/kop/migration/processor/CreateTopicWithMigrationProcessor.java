/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.streamnative.pulsar.handlers.kop.migration.processor;

import io.netty.handler.codec.http.FullHttpRequest;
import io.streamnative.pulsar.handlers.kop.http.HttpJsonRequestProcessor;
import io.streamnative.pulsar.handlers.kop.migration.requests.CreateTopicWithMigrationRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Http processor for creating a KoP topic with migration configuration.
 */
public class CreateTopicWithMigrationProcessor extends HttpJsonRequestProcessor<CreateTopicWithMigrationRequest, Void> {
    public CreateTopicWithMigrationProcessor(Class<CreateTopicWithMigrationRequest> requestModel) {
        super(requestModel, "/migration/createTopic", "POST");
    }

    @Override
    protected CompletableFuture<Void> processRequest(CreateTopicWithMigrationRequest payload,
                                                     List<String> patternGroups,
                                                     FullHttpRequest request) {
        return null;
    }
}

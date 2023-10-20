/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.quarkus.component.avro.rpc.it.specific.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.quarkus.component.avro.rpc.it.specific.generated.Key;
import org.apache.camel.quarkus.component.avro.rpc.it.specific.generated.KeyValueProtocol;
import org.apache.camel.quarkus.component.avro.rpc.it.specific.generated.Value;

public class KeyValueProtocolImpl implements KeyValueProtocol {

    private Map<Key, Value> store = new HashMap<>();

    @Override
    public void put(Key key, Value value) {
        store.put(key, value);
    }

    @Override
    public Value get(Key key) {
        return store.get(key);
    }

    public Map<Key, Value> getStore() {
        return store;
    }

}

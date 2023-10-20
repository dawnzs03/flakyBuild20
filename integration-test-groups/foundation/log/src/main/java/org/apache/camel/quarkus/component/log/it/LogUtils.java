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
package org.apache.camel.quarkus.component.log.it;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogUtils {
    private LogUtils() {
        // Utility class
    }

    public static boolean isNativeMode() {
        return "executable".equals(System.getProperty("org.graalvm.nativeimage.kind"));
    }

    public static Path resolveQuarkusLogPath() {
        Path logDir = Paths.get(".", "target");
        Path quarkusLog = isNativeMode() ? logDir.resolve("target/quarkus.log") : logDir.resolve("quarkus.log");
        if (!Files.exists(quarkusLog)) {
            try {
                Files.createDirectories(quarkusLog.getParent());
                Files.createFile(quarkusLog);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return quarkusLog;
    }
}

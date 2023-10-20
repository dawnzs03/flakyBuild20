/*
 * Copyright (C) 2023 Hedera Hashgraph, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.swirlds.common.merkle.route;

import static com.swirlds.common.formatting.StringFormattingUtils.formattedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods for operating on merkle routes.
 */
public final class MerkleRouteUtils {

    private MerkleRouteUtils() {}

    /**
     * Convert a merkle route to a string representation that looks like a file system path.
     *
     * @param route
     * 		the merkle route
     * @return the string representation
     */
    public static String merkleRouteToPathFormat(final MerkleRoute route) {
        final StringBuilder sb = new StringBuilder("/");
        formattedList(sb, route.iterator(), "/");
        return sb.toString();
    }

    /**
     * Convert a merkle route string represented in path format (i.e. the format generated by
     * {@link #merkleRouteToPathFormat(MerkleRoute)}) to a MerkleRoute object.
     *
     * @param path
     * 		the path string, if this is a relative path it is interpreted as a path relative to the root
     * @return a merkle route
     */
    public static MerkleRoute pathFormatToMerkleRoute(final String path) {
        return pathFormatToMerkleRoute(MerkleRouteFactory.getEmptyRoute(), path);
    }

    /**
     * Convert a merkle route string represented in path format (i.e. the format generated by
     * {@link #merkleRouteToPathFormat(MerkleRoute)}) to a MerkleRoute object. Paths use the unix style,
     * i.e. with '/' as the separator.
     *
     * @param currentPath
     * 		the current working path, analogous to the current working directory, ignored when parsing absolute paths
     * @param path
     * 		the path string
     * @return a merkle route
     * @throws MerkleRouteFormatException
     * 		if the string does not contain a valid route
     */
    public static MerkleRoute pathFormatToMerkleRoute(final MerkleRoute currentPath, final String path) {
        if (path.isEmpty()) {
            return currentPath;
        }

        final boolean isAbsolute = path.charAt(0) == '/';
        final MerkleRoute root = isAbsolute ? MerkleRouteFactory.getEmptyRoute() : currentPath;

        final List<String> steps = new ArrayList<>();
        root.forEach(step -> steps.add(Integer.toString(step)));
        final String[] pathElements = path.split("/");

        for (final String pathElement : pathElements) {
            if (!pathElement.isEmpty()) {
                if (pathElement.equals(".")) {
                    continue;
                }
                steps.add(pathElement);
            }
        }

        // Handle '..'
        for (int i = 0; i < steps.size(); i++) {
            if (steps.get(i).equals("..")) {
                if (i == 0) {
                    throw new MerkleRouteFormatException("can not use '..' to go above root");
                }
                steps.remove(i);
                steps.remove(i - 1);
                i -= 2;
            }
        }

        final List<Integer> integerSteps = new ArrayList<>(steps.size());
        for (final String step : steps) {
            try {
                integerSteps.add(Integer.parseInt(step));
            } catch (final NumberFormatException e) {
                throw new MerkleRouteFormatException("invalid step: " + step);
            }
        }

        return MerkleRouteFactory.getEmptyRoute().extendRoute(integerSteps);
    }
}

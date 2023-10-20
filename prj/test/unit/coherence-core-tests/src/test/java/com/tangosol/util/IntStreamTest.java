/*
 * Copyright (c) 2000, 2022, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */
package com.tangosol.util;

import com.oracle.coherence.testing.tests.streams.AbstractIntStreamTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/**
 * @author as  2014.10.02
 */
@RunWith(Parameterized.class)
public class IntStreamTest
        extends AbstractIntStreamTest
    {
    public IntStreamTest(boolean fParallel)
        {
        super(fParallel);
        }
    }

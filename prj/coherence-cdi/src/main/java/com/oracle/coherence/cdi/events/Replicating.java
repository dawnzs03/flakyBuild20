/*
 * Copyright (c) 2000, 2022, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * https://oss.oracle.com/licenses/upl.
 */
package com.oracle.coherence.cdi.events;

import com.oracle.coherence.cdi.AnnotationLiteral;

import jakarta.inject.Qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A qualifier annotation used for any REPLICATING event.
 *
 * @author Aleks Seovic  2020.04.13
 * @since 20.06
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Replicating
    {
    /**
     * An annotation literal for the {@link Replicating}
     * annotation.
     */
    class Literal
            extends AnnotationLiteral<Replicating>
            implements Replicating
        {
        public static final Literal INSTANCE = new Literal();
        }
    }

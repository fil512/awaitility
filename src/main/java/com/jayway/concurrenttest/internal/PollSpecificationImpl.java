/*
 * Copyright 2010 the original author or authors.
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
package com.jayway.concurrenttest.internal;

import java.util.concurrent.TimeUnit;

import com.jayway.concurrenttest.synchronizer.DurationSpecification;
import com.jayway.concurrenttest.synchronizer.PollSpecification;

public class PollSpecificationImpl implements PollSpecification {

    private final DurationSpecification duration;

    public PollSpecificationImpl(long interval, TimeUnit unit) {
        if (interval <= 0) {
            throw new IllegalArgumentException("interval must be > 0");
        }
        if (unit == null) {
            throw new IllegalArgumentException("TimeUnit cannot be null");
        }
        this.duration = new DurationSpecificationImpl(interval, unit);
    }

    public DurationSpecification getPollInterval() {
        return duration;
    }
}

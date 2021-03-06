/*
 * Copyright 2016-2018 mayanjun.org
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

package org.mayanjun.myjack.sample;

import org.mayanjun.mybatisx.dal.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;

public abstract class AbstractTestRunner implements TestRunner {

    @Autowired
    protected BasicDAO dao;

    private Runner getRunner() {
        return this.getClass().getAnnotation(Runner.class);
    }

    @Override
    public boolean ready() {
        Runner runner = getRunner();
        if (runner != null) return runner.value().isReady();
        return false;
    }

    @Override
    public int getOrder() {
        Runner runner = getRunner();
        if (runner != null) return runner.value().ordinal();
        return Ordered.LOWEST_PRECEDENCE;
    }
}

package org.mayanjun.myjack.sample.runner;

import org.mayanjun.mybatisx.dal.IdGenerator;

public class MyIdGenerator implements IdGenerator {

    @Override
    public Long next() {
        return System.currentTimeMillis();
    }
}

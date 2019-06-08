package org.loopbreaker.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.ArgumentMatchers.startsWith;

public class InMemoryLoopBreakerServiceTest extends AbstractLoopBreakerServiceTest {


    @Override
    protected LoopBreakerService getService() {
        return new InMemoryLoopBreakerService();
    }
}

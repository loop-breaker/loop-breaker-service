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

public abstract class AbstractLoopBreakerServiceTest {

     protected abstract LoopBreakerService getService();

     @Rule
     public ExpectedException thrown = ExpectedException.none();

     @Test
     public void testCreatingALoopReturnsAnIdentifier() {
          LoopBreakerService svc = getService();
          String id = svc.createLoop(new Loop("test"));
          assertThat(id, is(notNullValue()));
     }

     @Test
     public void testCreatingALoopWithDuplicateTitleFails() {
          LoopBreakerService svc = getService();
          svc.createLoop(new Loop("test"));
          thrown.expect(IllegalArgumentException.class);
          thrown.expectMessage(startsWith("Loop title already exists"));
          svc.createLoop(new Loop("test"));
     }

     @Test
     public void testCreatingALoopWithUniqueTitleSucceeds() {
          LoopBreakerService svc = getService();
          svc.createLoop(new Loop("Test1"));
          String id = svc.createLoop(new Loop("Test2"));
          assertThat(id, is(notNullValue()));
     }

     @Test
     public void testCreatingALoopProducesAUniqueIdentifier() {
          LoopBreakerService svc = getService();
          String id1 = svc.createLoop(new Loop("Test1"));
          String id2 = svc.createLoop(new Loop("Test2"));
          assertThat(id1, not(id2));

     }

     @Test
     public void testLoopRetrievalReturnsALoop() {
          LoopBreakerService svc = getService();
          String id = svc.createLoop(new Loop("test"));
          assertThat(svc.getById(id), is(notNullValue()));
     }

     @Test
     public void testLoopRetrievalFailsWithUnknownIdentifier() {
          LoopBreakerService svc = getService();
          assertThat(svc.getById("test"), is(nullValue()));
     }

     @Test
     public void testLoopRetrievalReturnsTheCorrectLoop() {
          LoopBreakerService svc = getService();
          String id = svc.createLoop(new Loop("test"));
          Loop loop = svc.getById(id);
          assertThat(loop.getTitle(), is("test"));
     }

     @Test
     public void testADeletedLoopCannotBeRetrieved() {
          LoopBreakerService svc = getService();
          String id = svc.createLoop(new Loop("test"));
          svc.delete(id);
          assertThat(svc.getById(id), is(nullValue()));
     }

     @Test
     public void testADeletedLoopsTitleCanBeUsedToCreateANewLoop() {
          LoopBreakerService svc = getService();
          String id = svc.createLoop(new Loop("test"));
          svc.delete(id);
          assertThat(svc.createLoop(new Loop("test")), is(notNullValue()));
     }

     @Test
     public void testFindAnExistingLoopByTitleProducesALoop() {
          LoopBreakerService svc = getService();
          svc.createLoop(new Loop("test"));
          Loop loop = svc.getByTitle("test");
          assertThat(loop, is(notNullValue()));
     }

     @Test
     public void testFindAnExistingLoopByTitleProducesALoopWithCorrectTitle() {
          LoopBreakerService svc = getService();
          svc.createLoop(new Loop("test"));
          Loop loop = svc.getByTitle("test");
          assertThat(loop.getTitle(), is("test"));
     }

     @Test
     public void testFindANonExistingLoopByTitleDoesNotProduceALoop() {
          LoopBreakerService svc = getService();
          svc.createLoop(new Loop("test"));
          Loop loop = svc.getByTitle("foo");
          assertThat(loop, is(nullValue()));
     }
}

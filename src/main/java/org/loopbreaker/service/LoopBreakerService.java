package org.loopbreaker.service;

public interface LoopBreakerService {
    String createLoop(Loop loop);

    Loop getById(String id);

    void delete(String id);

    Loop getByTitle(String title);
}

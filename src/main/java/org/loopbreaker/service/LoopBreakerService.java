package org.loopbreaker.service;

import java.util.*;

public class LoopBreakerService {

    private Map<String, Loop> loopsByTitle = new HashMap<>();
    private Map<String, Loop> loopsById = new HashMap<>();

    public String createLoop(Loop loop) {
        if (loopsByTitle.containsKey(loop.getTitle())) {
            throw new IllegalArgumentException("Loop title already exists");
        }
        String id = UUID.randomUUID().toString();
        loopsById.put(id, loop);
        loopsByTitle.put(loop.getTitle(), loop);
        return id;
    }

    public Loop getById(String id) {
        return loopsById.get(id);
    }

    public void delete(String id) {
        Loop loop = loopsById.remove(id);
        if (loop != null) {
            loopsByTitle.remove(loop.getTitle());
        }
    }

    public Loop getByTitle(String title) {
        return loopsByTitle.get(title);
    }
}

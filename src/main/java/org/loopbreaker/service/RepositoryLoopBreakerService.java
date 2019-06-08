package org.loopbreaker.service;

import org.loopbreaker.repository.LoopEntity;
import org.loopbreaker.repository.LoopRepository;

import java.util.UUID;


public class RepositoryLoopBreakerService implements LoopBreakerService {

    private LoopRepository repository;

    public RepositoryLoopBreakerService(LoopRepository repository) {
        this.repository = repository;
    }

    @Override
    public String createLoop(Loop loop) {

        if (repository.findByTitle(loop.getTitle()) == null) {
            LoopEntity loopEntity = new LoopEntity(UUID.randomUUID().toString(), loop.getTitle());
            repository.save(loopEntity);
            return loopEntity.getId();
        }

        throw new IllegalArgumentException("Loop title already exists");
    }

    @Override
    public Loop getById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Loop getByTitle(String title) {
        return null;
    }
}

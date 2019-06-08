package org.loopbreaker.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoopRepository extends CrudRepository<LoopEntity, String> {

    List<LoopEntity> findByTitle(String title);
}

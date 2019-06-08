package org.loopbreaker.repository;

import javax.persistence.Entity;

@Entity
public class LoopEntity {

    private String id;
    private String title;

    public LoopEntity(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

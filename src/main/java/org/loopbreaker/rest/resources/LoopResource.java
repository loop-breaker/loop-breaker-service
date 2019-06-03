package org.loopbreaker.rest.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class LoopResource extends ResourceSupport {

    private final String title;

    @JsonCreator
    public LoopResource(@JsonProperty("title")String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

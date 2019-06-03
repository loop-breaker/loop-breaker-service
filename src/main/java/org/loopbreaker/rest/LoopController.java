package org.loopbreaker.rest;

import org.loopbreaker.rest.resources.LoopResource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
public class LoopController {

    @GetMapping("/loops")
    ResponseEntity<Resources<Resource<LoopResource>>> findAll() {
        List<Resource<LoopResource>> loops = new ArrayList<>();
        return ResponseEntity.ok(new Resources<>(loops));
    }

    @GetMapping(value = "/loops/{id}")
    public HttpEntity<LoopResource> findOne(@PathVariable String id) {
        LoopResource loop = new LoopResource("test");
        return new ResponseEntity<>(loop, HttpStatus.OK);
    }

    @PostMapping("/loops")
    ResponseEntity<?> newLoop(@RequestBody LoopResource loop) {
        return ResponseEntity.ok(new Resource<>(loop));
    }
}

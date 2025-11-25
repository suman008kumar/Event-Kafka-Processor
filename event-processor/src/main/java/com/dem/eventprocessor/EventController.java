package com.dem.eventprocessor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventRepo repo;
    public EventController(EventRepo repo){ this.repo = repo; }
    @GetMapping
    public List<EventMessage> getAll(){ return repo.findAll(); }
}

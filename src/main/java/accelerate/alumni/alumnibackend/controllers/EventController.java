package accelerate.alumni.alumnibackend.controllers;

import accelerate.alumni.alumnibackend.models.Event;
import accelerate.alumni.alumnibackend.services.event.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(eventService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(eventService.findById(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Event event) {
        eventService.add(event);
        URI uri = URI.create("event/" + event.getEvent_id());
        return ResponseEntity.created(uri).build();
    }
}

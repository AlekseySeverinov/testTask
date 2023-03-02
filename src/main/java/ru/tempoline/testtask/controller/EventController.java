package ru.tempoline.testtask.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tempoline.testtask.entity.Event;
import ru.tempoline.testtask.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {

        if (event.getId() != null && event.getId() != 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(eventService.add(event));
    }

    @GetMapping(value = {"/param/{page}/{lines}/{classifier}", "/param/{page}/{lines}"})
    public ResponseEntity<List<Event>> getByParam(@PathVariable int page,
                                                 @PathVariable int lines,
                                                 @PathVariable(name = "classifier", required = false) Long classifier) {
        List<Event> list = this.eventService.getPageSort(page, lines, classifier);
        return new ResponseEntity<>(
                list,
                HttpStatus.OK);


    }
}

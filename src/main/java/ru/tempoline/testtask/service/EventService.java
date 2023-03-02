package ru.tempoline.testtask.service;

import org.springframework.stereotype.Service;
import ru.tempoline.testtask.entity.Classifier;
import ru.tempoline.testtask.entity.Event;
import ru.tempoline.testtask.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {


    private final SortService sortService;

    private final EventRepository eventRepository;

    public EventService(SortService sortService, EventRepository eventRepository) {
        this.sortService = sortService;
        this.eventRepository = eventRepository;
    }

    public Event add(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getPageSort(int page, int lines, Long classifier) {
        if (classifier == null) {
            return this.sortService.getPage(page, lines).getContent();
        }
        if (classifier > 0) {
            return this.sortService.getPageByClassifier(page, lines, new Classifier(classifier)).getContent();
        }
        return new ArrayList<>();
    }
}
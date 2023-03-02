package ru.tempoline.testtask.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.tempoline.testtask.entity.Classifier;
import ru.tempoline.testtask.entity.Event;
import ru.tempoline.testtask.repository.ClassifierRepository;
import ru.tempoline.testtask.repository.EventRepository;

@Service
public class SortService {

    private final EventRepository eventRepository;

    private final ClassifierRepository classifierRepository;

    public SortService(EventRepository eventRepository, ClassifierRepository classifierRepository) {
        this.eventRepository = eventRepository;
        this.classifierRepository = classifierRepository;
    }

    public Page<Event> getPage(int page, int lines) {
        Pageable requiredPage = PageRequest.of( page, lines, Sort.by("date"));
        return this.eventRepository.findAll(requiredPage);
    }

    public Page<Event> getPageByClassifier(int page, int lines, Classifier classifier) {
        Pageable requiredPage = PageRequest.of(page, lines, Sort.by("date"));
        return this.eventRepository.findAllByClassifier(classifier, requiredPage);
    }
}

package ru.tempoline.testtask.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tempoline.testtask.entity.Classifier;
import ru.tempoline.testtask.entity.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Page<Event> findAllByClassifier(Classifier classifier, Pageable requiredPage);
}

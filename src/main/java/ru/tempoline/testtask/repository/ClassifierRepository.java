package ru.tempoline.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tempoline.testtask.entity.Classifier;

@Repository
public interface ClassifierRepository extends JpaRepository<Classifier,Long> {
}

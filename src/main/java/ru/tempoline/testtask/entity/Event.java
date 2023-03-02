package ru.tempoline.testtask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;


@Entity
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Calendar date;

    @Transient
    private int classifierId;

    @ManyToOne
    @JoinColumn(name = "classifier_id", referencedColumnName = "id")
    private Classifier classifier;

}

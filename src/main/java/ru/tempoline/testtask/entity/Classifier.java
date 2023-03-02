package ru.tempoline.testtask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "classifier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String description;

    public Classifier(Long classifier) {
    }
}

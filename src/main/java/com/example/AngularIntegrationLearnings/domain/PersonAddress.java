package com.example.AngularIntegrationLearnings.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class PersonAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String landMark;
    private String city;
}

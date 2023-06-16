package com.example.AngularIntegrationLearnings.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Setter
@Getter
public class PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "personInfo",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MobileNumbers> mobileNumbersList;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private PersonAddress personAddress;
}

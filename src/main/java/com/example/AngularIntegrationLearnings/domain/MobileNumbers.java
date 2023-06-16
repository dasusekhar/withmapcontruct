package com.example.AngularIntegrationLearnings.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MobileNumbers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String mobileNumber;
    @ManyToOne(fetch = FetchType.LAZY)
 //   @JsonIgnore
    private PersonInfo personInfo;
}

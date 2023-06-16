package com.example.AngularIntegrationLearnings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonAddressDto {
    private Integer id;
    private String landMark;
    private String city;
}

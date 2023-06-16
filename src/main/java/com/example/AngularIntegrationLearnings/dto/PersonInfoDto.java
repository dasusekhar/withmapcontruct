package com.example.AngularIntegrationLearnings.dto;

import com.example.AngularIntegrationLearnings.domain.MobileNumbers;
import com.example.AngularIntegrationLearnings.domain.PersonAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfoDto {
    private Integer id;
    private String name;
    private List<MobileNumbersDto> mobileNumbersList;
    private PersonAddressDto personAddress;
}

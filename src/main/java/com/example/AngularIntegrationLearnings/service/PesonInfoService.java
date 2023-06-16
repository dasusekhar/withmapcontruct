package com.example.AngularIntegrationLearnings.service;

import com.example.AngularIntegrationLearnings.domain.PersonInfo;
import com.example.AngularIntegrationLearnings.dto.PersonInfoDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface PesonInfoService {
    PersonInfoDto save(PersonInfoDto personInfoDto);

    PersonInfoDto findById(Integer id);

    List<PersonInfoDto> findAll();

    PersonInfoDto update(Integer id, PersonInfoDto personInfoDto);
}

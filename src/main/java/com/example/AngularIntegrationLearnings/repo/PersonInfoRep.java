package com.example.AngularIntegrationLearnings.repo;

import com.example.AngularIntegrationLearnings.domain.PersonInfo;
import com.example.AngularIntegrationLearnings.dto.PersonInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonInfoRep extends JpaRepository<PersonInfo,Integer> {



}

package com.example.AngularIntegrationLearnings.controller;

import com.example.AngularIntegrationLearnings.domain.PersonInfo;
import com.example.AngularIntegrationLearnings.dto.PersonInfoDto;
import com.example.AngularIntegrationLearnings.repo.PersonInfoRep;
import com.example.AngularIntegrationLearnings.service.PesonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/person-info")
@CrossOrigin(origins = "http://localhost:59002")
public class PersonInfoController {
    @Autowired
    private PesonInfoService pesonInfoService;
    @Autowired
    private PersonInfoRep personInfoRep;

    @PostMapping("/save")
    public ResponseEntity<PersonInfoDto>save(@RequestBody PersonInfoDto personInfo)
    {
        PersonInfoDto saved=pesonInfoService.save(personInfo);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonInfoDto>findById(@PathVariable Integer id)
    {
        PersonInfoDto personInfoDto=pesonInfoService.findById(id);
        return new ResponseEntity<>(personInfoDto,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PersonInfoDto>> findAll()
    {
        List<PersonInfoDto>getAll=pesonInfoService.findAll();
        System.out.println("calling");
        return new ResponseEntity<>(getAll,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonInfoDto>update(@PathVariable Integer id,PersonInfoDto personInfoDto)
    {
        PersonInfoDto update=pesonInfoService.update(id,personInfoDto);
        return new ResponseEntity<>(update,HttpStatus.CREATED);
    }
}

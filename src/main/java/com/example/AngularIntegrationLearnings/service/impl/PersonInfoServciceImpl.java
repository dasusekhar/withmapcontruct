package com.example.AngularIntegrationLearnings.service.impl;

import com.example.AngularIntegrationLearnings.domain.MobileNumbers;
import com.example.AngularIntegrationLearnings.domain.PersonAddress;
import com.example.AngularIntegrationLearnings.domain.PersonInfo;
import com.example.AngularIntegrationLearnings.domain.PersonInfoMapper;
import com.example.AngularIntegrationLearnings.dto.MobileNumbersDto;
import com.example.AngularIntegrationLearnings.dto.PersonAddressDto;
import com.example.AngularIntegrationLearnings.dto.PersonInfoDto;
import com.example.AngularIntegrationLearnings.repo.PersonInfoRep;
import com.example.AngularIntegrationLearnings.service.PesonInfoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonInfoServciceImpl implements PesonInfoService {
    @Autowired
    private PersonInfoRep personInfoRep;
    @Autowired
    private PersonInfoMapper mapper;
    @Override
    public PersonInfoDto save(PersonInfoDto dto) {
//PersonInfo per=new PersonInfo();
//per.setId(personInfo.getId());
//per.setName(personInfo.getName());
//        List<MobileNumbers> list=new ArrayList<>();
//    personInfo.getMobileNumbersList().stream().forEach(mobileNumbers -> {
//        MobileNumbers mobileNumbers1=new MobileNumbers();
//        mobileNumbers1.setId(mobileNumbers.getId());
//        mobileNumbers1.setMobileNumber(mobileNumbers.getMobileNumber());
//        mobileNumbers1.setPersonInfo(per);
//        list.add(mobileNumbers1);
//    });
//        per.setMobileNumbersList(list);
//        return personInfoRep.save(per);


        PersonInfo personInfo=new PersonInfo();
        BeanUtils.copyProperties(dto,personInfo);
        List<MobileNumbers>mobileNumbersList=new ArrayList<>();
        dto.getMobileNumbersList().stream().forEach(mobileNumbersDto -> {
            MobileNumbers mobileNumbers=new MobileNumbers();
            mobileNumbers.setPersonInfo(personInfo);
            BeanUtils.copyProperties(mobileNumbersDto,mobileNumbers);
            mobileNumbersList.add(mobileNumbers);
        });
        PersonAddress personAddress=new PersonAddress();
        BeanUtils.copyProperties(dto.getPersonAddress(),personAddress);
        personInfo.setPersonAddress(personAddress);
        personInfo.setMobileNumbersList(mobileNumbersList);
        PersonInfo personInfo1=personInfoRep.save(personInfo);
        PersonInfoDto personInfoDto=new PersonInfoDto();
        BeanUtils.copyProperties(personInfo1,personInfoDto);
        PersonAddressDto personAddressDto=new PersonAddressDto();
        BeanUtils.copyProperties(personInfo1.getPersonAddress(),personAddressDto);
        personInfoDto.setPersonAddress(personAddressDto);
        List<MobileNumbersDto>mobileNumbersDtos=new ArrayList<>();
        personInfo1.getMobileNumbersList().stream().forEach(mobileNumbers -> {
            MobileNumbersDto mobileNumbersDto=new MobileNumbersDto();
            BeanUtils.copyProperties(mobileNumbers,mobileNumbersDto);
            mobileNumbersDtos.add(mobileNumbersDto);
        });
         personInfoDto.setMobileNumbersList(mobileNumbersDtos);
         return personInfoDto ;

    }

    @Override
    public PersonInfoDto findById(Integer id) {
        PersonInfo finds=personInfoRep.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.toDto(finds);
    }

    @Override
    public List<PersonInfoDto> findAll() {
        List<PersonInfo>personInfoPage =personInfoRep.findAll();
    return  personInfoPage.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PersonInfoDto update(Integer id, PersonInfoDto personInfoDto) {
        PersonInfo personInfo=personInfoRep.findById(id).orElseThrow(EntityNotFoundException::new);
        PersonInfo updatedEntity=mapper.partialUpdate(personInfoDto,personInfo);
        return mapper.toDto(updatedEntity);
    }
}

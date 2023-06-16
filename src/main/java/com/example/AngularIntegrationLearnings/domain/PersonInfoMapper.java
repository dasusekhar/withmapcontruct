package com.example.AngularIntegrationLearnings.domain;

import com.example.AngularIntegrationLearnings.dto.PersonInfoDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonInfoMapper {
    PersonInfo toEntity(PersonInfoDto personInfoDto);

    PersonInfoDto toDto(PersonInfo personInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PersonInfo partialUpdate(PersonInfoDto personInfoDto, @MappingTarget PersonInfo personInfo);
}
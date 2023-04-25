package com.project.personDemo;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {
    Person toEntity(PersonDto personDto);

    PersonDto toDto(Person person);
    List<PersonDto> toDto(List<Person> person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Person partialUpdate(PersonDto personDto, @MappingTarget Person person);
}
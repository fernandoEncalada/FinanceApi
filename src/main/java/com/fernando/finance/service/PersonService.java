package com.fernando.finance.service;

import com.fernando.finance.model.dto.person.PersonRequestDto;
import com.fernando.finance.model.dto.person.PersonResponseDto;

import java.util.List;

public interface PersonService {
    List<PersonResponseDto> get();
    PersonResponseDto save(PersonRequestDto personRequestDto);
    PersonResponseDto update(int id, PersonRequestDto personRequestDto);
}

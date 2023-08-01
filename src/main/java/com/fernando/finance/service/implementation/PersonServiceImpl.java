package com.fernando.finance.service.implementation;

import com.fernando.finance.model.dbmo.Person;
import com.fernando.finance.model.dto.person.PersonRequestDto;
import com.fernando.finance.model.dto.person.PersonResponseDto;
import com.fernando.finance.model.repository.PersonRepository;
import com.fernando.finance.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<PersonResponseDto> get() {
        return personRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public PersonResponseDto save(PersonRequestDto personRequestDto) {
        Person person = new Person();
        person.setName(personRequestDto.getName());
        person = personRepository.save(person);

        return mapToDto(person);
    }

    @Override
    public PersonResponseDto update(int id, PersonRequestDto personRequestDto) {
        Person person = personRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Error at update person"));
        person.setName(personRequestDto.getName());
        person = personRepository.save(person);

        return mapToDto(person);
    }

    private PersonResponseDto mapToDto(Person person) {
        PersonResponseDto personResponseDto = new PersonResponseDto();
        personResponseDto.setId(person.getId());
        personResponseDto.setName(person.getName());

        return personResponseDto;
    }


}

package com.example.restdocstest.service;

import com.example.restdocstest.domain.PersonRepository;
import com.example.restdocstest.exception.NotFoundException;
import com.example.restdocstest.service.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    public List<PersonDto.Response> findAll() {
        return personRepository.findAll()
                .stream()
                .map(PersonDto.Response::of)
                .collect(Collectors.toList());
    }

    public PersonDto.Response findById(Long id) {
        return personRepository.findById(id)
                .map(PersonDto.Response::of)
                .orElseThrow(NotFoundException::new);
    }
}

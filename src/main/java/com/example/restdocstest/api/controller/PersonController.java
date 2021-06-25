package com.example.restdocstest.api.controller;

import com.example.restdocstest.response.ApiResponseDto;
import com.example.restdocstest.service.PersonService;
import com.example.restdocstest.service.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ApiResponseDto<PersonDto.ResponseList> findAll(){
        return ApiResponseDto.createOK(new PersonDto.ResponseList(personService.findAll()));
    }

}

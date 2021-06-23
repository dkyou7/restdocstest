package com.example.restdocstest.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person {

    @Id @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private LocalDate birthDate;

    private String hobby;

    @Builder
    private Person(String firstName, String lastName, Gender gender, LocalDate birthDate, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hobby = hobby;
    }

    public Person update(String firstName, String lastName, LocalDate birthDate, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hobby = hobby;
        return this;
    }
}

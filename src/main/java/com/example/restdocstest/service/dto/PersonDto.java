package com.example.restdocstest.service.dto;

import com.example.restdocstest.domain.Gender;
import com.example.restdocstest.domain.Person;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonDto {

    @Getter
    public static class ResponseList {

        private List<Response> persons;

        public ResponseList(List<Response> persons){
            this.persons = persons;
        }

    }

    @Getter
    public static class Response {

        private Long id;
        private String firstName;
        private String lastName;
        private long age;
        private Gender gender;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate birthDate;
        private String hobby;

        @Builder
        private Response(Long id, String firstName, String lastName, Gender gender, LocalDate birthDate, String hobby) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
            this.gender = gender;
            this.birthDate = birthDate;
            this.hobby = hobby;
        }

        public static Response of(Person person) {
            return Response.builder()
                    .id(person.getId())
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .gender(person.getGender())
                    .birthDate(person.getBirthDate())
                    .hobby(person.getHobby())
                    .build();
        }
    }
}

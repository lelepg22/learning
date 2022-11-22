package survey.backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraineeDtoTest {

    @Test
    void testDefaultConstructor(){

        var traineeDto = new TraineeDto();
        //   TraineeDto trainee2 = new TraineeDto(); if under Java 10 var doesn't EXIST
        assertInstanceOf(
                TraineeDto.class, traineeDto
        );

        assertAll(
                () -> assertNull(traineeDto.getId(), "ID must be null"),
                () -> assertNull(traineeDto.getBirthDate(), "Birthdate must be null"),
                () -> assertNull(traineeDto.getFirstName(),  "Firstname must be null"),
                () -> assertNull(traineeDto.getLastName(),  "Firstname must be null"),
                () -> assertNull(traineeDto.getEmail(),  "Email must be null"),
                () -> assertNull(traineeDto.getPhoneNumber(),  "Phone must be null")
                );
    }

    // TODO: builder

    // TODO: all args constructor


}
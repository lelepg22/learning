package survey.backend.dto;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TraineeDtoTest {

    public List<Integer> idList = List.of(1,2,3,4,5);
    public List<String> firstNameList = List.of("Alex", "John", "Wellington","Marcus");
    public List<String> lastNameList = List.of("Dupont", "Washe", "Piong", "Smith");
    public List<LocalDate> localDateList = List.of(
            LocalDate.of(1965,2,10),
            LocalDate.of(1985,3,12),
            LocalDate.of(1944,10,9),
            LocalDate.of(1988,7,20)
    );
    public List<String> phoneNumberList = List.of("+334848484", "+337277272", "+3387767872","+335656222");
    public List<String> emailList = List.of("wola@gmail.com", "kilili@gmail.com", "bayne@johnny.fr", "juli@bal.fr");



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

    @Test

    void testBuilder(){

        var traineeDto = TraineeDto.builder()
                .id(1)
                .birthDate(LocalDate.of(2011,11,11))
                .lastName(lastNameList.get(0))
                .firstName("John")
                .email("john@w.com")
                .phoneNumber("+338747642")
                .build();

        assertAll(

                () -> assertEquals(
                        LocalDate.of(2011,11,11),traineeDto.getBirthDate(), "birthDate value"
                ),
                () -> assertEquals(

                        1,traineeDto.getId(), "id value"
                ),
                () -> assertEquals(

                        lastNameList.get(0),traineeDto.getLastName(), "lastName value"
                ),
                () -> assertEquals(

                        "John",traineeDto.getFirstName(), "firstName value"
                ),
                () -> assertEquals(

                        "john@w.com",traineeDto.getEmail(), "email value"
                ),
                () -> assertEquals(

                        "+338747642",traineeDto.getPhoneNumber(), "phoneNumber value"
                )

        );

        var traineeDto2 = TraineeDto.builder()

                .birthDate(LocalDate.of(2011,11,11))
                .lastName("Wayne")
                .id(2)
                .build();

        assertAll(

                () -> assertEquals(
                        LocalDate.of(2011,11,11),traineeDto2.getBirthDate(), "birthDate value"
                ),
                () -> assertEquals(

                        2,traineeDto2.getId(), "id value"
                ),
                () -> assertEquals(

                        "Wayne",traineeDto2.getLastName(), "lastName value"
                ),
                () -> assertNull(

                        traineeDto2.getFirstName(), "firstName should be null"
                ),
                () -> assertNull(

                        traineeDto2.getEmail(), "email should be null"
                ),
                () -> assertNull(

                        traineeDto2.getPhoneNumber(), "phoneNumber should be null"
                )

        );

    }

    // TODO: all args constructor
    @Test

    void testAllArgsConstructor(){

        var traineeDto = new TraineeDto(
                2,"Alex",
                "Gaglianone",
                "lol@gmail.com",
                "+337675677",
                LocalDate.of(2011,11,11)
        );
        assertAll(
                ()-> assertEquals(2, traineeDto.getId(), "value id"),

                ()-> assertEquals("Gaglianone",  traineeDto.getLastName(), "value lastName"),

                ()-> assertEquals("Alex", traineeDto.getFirstName(), "value firstName"),

                ()-> assertEquals("lol@gmail.com", traineeDto.getEmail(), "value email"),

                ()-> assertEquals("+337675677", traineeDto.getPhoneNumber(), "value phoneNumber"),

                ()-> assertEquals(LocalDate.of(2011,11,11), traineeDto.getBirthDate(), "value birthDate")

        );

    }

}
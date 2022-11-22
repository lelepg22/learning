package survey.backend.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class TraineeDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;


    public TraineeDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

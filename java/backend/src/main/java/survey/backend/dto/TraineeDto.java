package survey.backend.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class TraineeDto {

    private Integer id;

    @NotBlank //include @NonNull
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    @Email
    private String email;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
    private String phoneNumber;

    @Past
    private LocalDate birthDate;

    public TraineeDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

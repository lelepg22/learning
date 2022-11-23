package survey.backend.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PoeDto {

    private String title;
    public enum poeType {POEI, POEC};
    private int id;
    private LocalDate beginDate;
    private LocalDate endDate;


}

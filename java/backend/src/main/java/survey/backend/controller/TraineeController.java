package survey.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import survey.backend.dto.TraineeDto;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("api/trainee")

public class TraineeController {

    /**
     * list of trainees
     * route: /api/trainee
     * @return list of trainees
     */

@GetMapping
    public Set<TraineeDto> list(){
        return Set.of(
                TraineeDto.builder()
                        .id(1)
                        .firstName("Wellington")
                        .lastName("Xash")
                        .build(),
                TraineeDto.builder()
                        .id(22)
                        .firstName("Silvie")
                        .lastName("Dupont")
                        .build(),
                TraineeDto.builder()
                        .id(30)
                        .firstName("Daniel")
                        .lastName("Cloud")
                        .build()
        );
    }


    /**
     * a trainee by id
     * route: /api/trainee/{id}
     * @param id
     * @return a trainee
     */

    @GetMapping("{id}")    // http://localhost:8080/api/trainee/20
    public Optional<TraineeDto> one(@PathVariable("id") int id) {

        return Optional.of(TraineeDto.builder()
                .id(id)
                .firstName("Johnny")
                .lastName("BeGood")
                .build()
        );
    }


    /**
     * search trainees with criteria
     * route: /api/trainee/search?fn=some_firstname&ln=some_lastname
     * @param firstName(optional)
     * @param lastName(optional)
     * @return trainees corresponding to search values
     */

    @GetMapping("search")   // http://localhost:8080/api/trainee/search?fn=James&ln=Bond

    public Set<TraineeDto> search(
            @RequestParam(value = "fn", required = false) String firstName ,
            @RequestParam(value = "ln", required = false) String lastName
    ){
        return Set.of(
                TraineeDto.builder()
                        .id(1)
                        .firstName(Objects.isNull(firstName) ? "Found" : firstName)
                        .lastName(Objects.isNull(lastName) ? "Found": lastName)
                        .build(),
                TraineeDto.builder()
                        .id(22)
                        .firstName("Silvie")
                        .lastName("Dupont")
                        .build(),
                TraineeDto.builder()
                        .id(30)
                        .firstName("Daniel")
                        .lastName("Cloud")
                        .build()
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeDto add(@RequestBody TraineeDto traineeDto) {

        // TODO: add in a under layer
        traineeDto.setId(2323);
        return  traineeDto;

    }

}

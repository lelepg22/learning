package survey.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import survey.backend.dto.TraineeDto;
import survey.backend.service.TraineeService;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RestController

@RequestMapping("api/trainee")

public class TraineeController {

    @Autowired // Dependency INJECTION from SPRING
    private TraineeService traineeService;

    private final Set<TraineeDto> build = Set.of(
            TraineeDto.builder()
                    .id(1)
                    .firstName("Johnny")
                    .lastName("BeGood")
                    .birthDate(LocalDate.of(1956, 10, 10))
                    .build(),
            TraineeDto.builder()
                    .id(22)
                    .firstName("Silvie")
                    .lastName("Dupont")
                    .birthDate(LocalDate.of(1986, 12, 22))
                    .build(),
            TraineeDto.builder()
                    .id(30)
                    .firstName("Daniel")
                    .lastName("Cloud")
                    .birthDate(LocalDate.of(1967, 02, 06))
                    .build()
    );
    public Set<TraineeDto> trainees = build;

    /**
     * list of trainees
     * route: /api/trainee
     * @return list of trainees
     */

    @GetMapping
    public Set<TraineeDto> list(){
        return traineeService.findAll();

       // return this.trainees;
    }


    /**
     * a trainee by id
     * route: /api/trainee/{id}
     * @param id
     * @return a trainee
     */

    @GetMapping("{id}")    // http://localhost:8080/api/trainee/20
    public TraineeDto one(@PathVariable("id") int id) {

        Optional<TraineeDto> optionalTraineeDto = traineeService.findById(id);
        if(optionalTraineeDto.isPresent()) {
            return optionalTraineeDto.get();
        }
        else{
            throw new IllegalArgumentException("Trainee with id provided : " + id + " NOT FOUND" );
        }

//
//        return Optional.of(TraineeDto.builder()
//                .id(id)
//                .firstName("Johnny")
//                .lastName("BeGood")
//                .build()
//        );
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
        return this.traineeService.add(traineeDto);


    }

    @DeleteMapping("delete/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT) // DOESNT RETURN ANYTHING
    public Set<TraineeDto> deleteTrainee(@PathVariable("id") int id)
    {

        this.trainees = this.trainees.stream().filter(data -> data.getId() != id ).collect(Collectors.toSet());

        return this.trainees;

    }

    @PutMapping
    public Set<TraineeDto> putTrainee(@RequestBody TraineeDto traineeDto){

        this.trainees = this.trainees.stream()
                .map(data -> {
                    if(data.getId() == traineeDto.getId()){
                        return data = traineeDto;
                    }
                    return data;
                }
                ).collect(Collectors.toSet());

        return this.trainees;




    }

}

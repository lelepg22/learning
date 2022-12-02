package survey.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import survey.backend.dto.TraineeDto;
import survey.backend.entities.Trainee;
import survey.backend.error.BadRequestError;
import survey.backend.error.NoDataFoundError;
import survey.backend.service.TraineeService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController

@RequestMapping("api/trainee")

public class TraineeController {

    @Autowired // Dependency INJECTION from SPRING
    private TraineeService traineeService;

    /**
     * list of trainees
     * route: /api/trainee
     * @return list of trainees
     */

    @GetMapping
    public Iterable<Trainee> list(){

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
    public Trainee findByid(@PathVariable("id") int id) {

        Optional<Trainee> optionalTrainee = traineeService.findById(id);

        if(optionalTrainee.isPresent()) {

            return optionalTrainee.get();

        }
        else{

            throw NoDataFoundError.withId("Trainee", id);

        }

    }


    /**
     * search trainees with criteria
     * route: /api/trainee/search?fn=some_firstname&ln=some_lastname
     * @param firstName(optional)
     * @param lastName(optional)
     * @return trainees corresponding to search values
     */

    @GetMapping("search")   // http://localhost:8080/api/trainee/search?fn=James&ln=Bond

    public Iterable<Trainee> search(
            @RequestParam(value = "fn", required = false) String firstName ,
            @RequestParam(value = "ln", required = false) String lastName
    ){
        int size = 0;

        if(firstName == null && lastName == null) {

            throw BadRequestError.withNoArgs("search with no args not permitted");
        }

        Iterable<Trainee> trainees = traineeService.search(lastName, firstName);
        if (trainees instanceof Collection) {
            size = ((Collection<Trainee>) trainees).size();
        }

//        List<Trainee> trainees = StreamSupport.stream(
//                traineeService.search(lastName, firstName).spliterator(), false
//        ).collect(Collectors.toList());

        if(size == 0){
            throw NoDataFoundError.withValues("Trainees", firstName + " " + lastName);
        }

        return trainees;

//
//        if(firstName != null || lastName != null){
//            Iterable<Trainee> trainee = traineeService.search(lastName, firstName);
//            if(trainee.iterator().next().getFirstName().length() > 0){
//                return trainee;
//            }
//            else{
//                throw NoDataFoundError.withValues("First Name, Last name : ",  firstName + " " + lastName );
//            }
//
//        }
//
//        return null;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainee add(@Valid @RequestBody TraineeDto traineeDto) {

        //Trainee res = traineeService.add(traineeDto);
        //TODO: traineeDto must be valid
        return traineeService.add(traineeDto);

    }

    @DeleteMapping("delete/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT) // DOESNT RETURN ANYTHING
    public boolean deleteTrainee(@PathVariable("id") int id)
    {

//        this.trainees = this.trainees.stream().filter(data -> data.getId() != id ).collect(Collectors.toSet());
//
//        return this.trainees;
        return this.traineeService.remove(id);

    }

    @PutMapping
    public Trainee update(@Valid @RequestBody TraineeDto traineeDto) {
        return traineeService.update(traineeDto)
                .orElseThrow(() -> NoDataFoundError.withId("Trainee", Math.toIntExact(traineeDto.getId())));
    }

}

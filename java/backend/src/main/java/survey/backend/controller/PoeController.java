package survey.backend.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import survey.backend.dto.PoeDto;
import survey.backend.dto.TraineeDto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/poe")

public class PoeController {
    public Set<PoeDto> poes = new HashSet<PoeDto>();
    private Set<PoeDto>build (){
            PoeDto poe = new PoeDto();
            poe.setId(1);
            poe.setTitle("FullStack Java");
            poe.setBeginDate(LocalDate.of(2022,10,24));
            poe.setEndDate(LocalDate.of(2023,01,27));

            this.poes.add(poe);

            poe = new PoeDto();
            poe.setId(2);
            poe.setTitle("FullStack Java, LATER");
            poe.setBeginDate(LocalDate.of(2022,11,4));
            poe.setEndDate(LocalDate.of(2023,01,7));

            this.poes.add(poe);

            return this.poes;

    }



    @GetMapping
    public Set<PoeDto> list(){
        this.build();
        return this.poes;
    }

    @GetMapping("{id}")
    public Optional<PoeDto> getById(@PathVariable int id) {

        return this.poes.stream().filter(data -> data.getId() == id).findFirst();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Set<PoeDto> add(@RequestBody PoeDto poeDto) {
        this.poes.add(poeDto);
        return this.poes;
    }




}

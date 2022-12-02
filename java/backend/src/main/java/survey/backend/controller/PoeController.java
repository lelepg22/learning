package survey.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import survey.backend.dto.PoeDto;
import survey.backend.entities.Poe;
import survey.backend.service.impl.PoeService;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/poe")

public class PoeController {

    @Autowired
    PoeService poeService;
    public Set<PoeDto> poes = new HashSet<PoeDto>();

    @GetMapping
    public Iterable<Poe> findAll(){

        return this.poeService.findAll();

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

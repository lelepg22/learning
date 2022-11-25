package survey.backend.service.impl;

import org.springframework.stereotype.Service;
import survey.backend.dto.TraineeDto;
import survey.backend.service.TraineeService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DummyTraineeService implements TraineeService {

    private Optional<TraineeDto> trainee;

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


    @Override
    public Set<TraineeDto> findAll() {
        return this.trainees;
    }

    @Override
    public Optional<TraineeDto> findById(int id) {
        this.trainee = this.trainees.stream().filter(data -> data.getId() == id).findFirst();
        if(this.trainee.isEmpty()) {
            return Optional.empty();
        }
        else{
            return this.trainee;
        }
    }

    @Override
    public Set<TraineeDto> search(String firstName, String lastName) {
        return new HashSet<>();
    }

    @Override
    public TraineeDto add(TraineeDto trainee) {

       //TODO: this.trainees.add(trainee);
        return trainee;
    }
    @Override
    public Optional<TraineeDto> update(TraineeDto traineeDto){

        this.trainee = trainees.stream().filter(data -> data.getId().equals(traineeDto.getId())).findFirst();
                return this.trainee;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

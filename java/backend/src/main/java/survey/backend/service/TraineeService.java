package survey.backend.service;

import survey.backend.dto.TraineeDto;

import java.util.Optional;
import java.util.Set;

public interface TraineeService {

    Set<TraineeDto> findAll();

    Optional<TraineeDto> findById(int id);

    Optional<Set<TraineeDto>> search(String firstName, String lastName);

    TraineeDto add(TraineeDto trainee);

    TraineeDto delete(int id);

    // update




}

package survey.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import survey.backend.entities.Trainee;

public interface TraineeRepository extends CrudRepository<Trainee, Long> {

    @Query(
            value = "Select * FROM trainee WHERE last_name= :lastName AND first_name= :firstName",
            nativeQuery = true
    )
    public Iterable<Trainee> listLastByNameAndFirstName(@Param( value = "lastName") String lastName,
                                                        @Param(value = "firstName") String firstName);

    @Query (
            value ="SELECT t FROM Trainee t WHERE t.lastName= :lastName AND t.firstName = :firstName"
    )

    public Iterable<Trainee> byLastNameAndFirstName(@Param(value="lastName") String lastName,
                                                    @Param(value="firstName") String firstName);


    // jpa provides findByFoo(foo) methods to find by attributes
    Iterable<Trainee> findByLastName(String lastName);

    Iterable<Trainee> findByFirstName(String firstName);
}

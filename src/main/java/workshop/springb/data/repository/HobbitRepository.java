package workshop.springb.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import workshop.springb.data.model.Hobbit;

import java.util.List;

public interface HobbitRepository extends CrudRepository<Hobbit, Long> {

    List<Hobbit> findByFirstNameAndLastName(String fisrtName, String lastName);

    @Query("SELECT h FROM Hobbit h WHERE h.firstName = :name AND h.lastName= :surname")
    List<Hobbit> findWithQuery(String name, String surname);

    @Query(value = "SELECT id, first_name, last_name FROM Hobbit h WHERE h.first_name = :firstName AND h.last_name= :lastName",
            nativeQuery = true)
    List<Hobbit> findWithNativeQuery(String firstName, String lastName);

    List<Hobbit> findWithNamedQuery(@Param("firstName") String name, String lastName);

    List<Hobbit> findWithNamedNativeQuery(String firstName, String lastName);

}

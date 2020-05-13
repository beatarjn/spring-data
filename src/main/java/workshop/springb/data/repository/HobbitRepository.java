package workshop.springb.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import workshop.springb.data.model.Hobbit;

import java.util.List;

public interface HobbitRepository extends CrudRepository<Hobbit, Long> {

    List<Hobbit> findByFirstNameAndLastName(String firstName, String lastName);

    /*
        TODO 1 w przypadku findByFirstNameAndLastName nazwa metody nie jest trywialna,
         w oparciu o nią tworzone są zapytania. Jeśli to rozbudowane API nie wystarcza, możemy utworzyć metody,
         z zapytaniem (JPQL lub SQL).
     */

    /*
        TODO 2
         -utwórz metodę, która zachowa się analogicznie do findByFirstNameAndLastName,
         użyj adnotacji @Query (wtedy nazwa metody nie będzie miała wpływu na zapytanie).
         W @Query użyj zapytania JPQL.
         -napisz test do metody
     */

    @Query("SELECT h FROM Hobbit h WHERE h.firstName = :name AND h.lastName= :surname")
    List<Hobbit> findWithQuery(String name, String surname);

    /*
        TODO 3
         -analogicznie jak w TODO2,  W @Query użyj zapytania SQL.
         -napisz test do metody
    */
    @Query(value = "SELECT id, first_name, last_name FROM Hobbit h WHERE h.first_name = :firstName AND h.last_name= :lastName",
            nativeQuery = true)
    List<Hobbit> findWithNativeQuery(String firstName, String lastName);
}

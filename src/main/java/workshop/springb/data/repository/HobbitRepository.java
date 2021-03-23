package workshop.springb.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

    @Query("FROM Hobbit h WHERE h.firstName= :firstName AND h.lastName=:lastName")
    List<Hobbit> findByFirstNameAndLastNameUsingQuery(@Param("firstName") String firstName, @Param("lastName") String lastName);

    /*
        TODO 3
         -analogicznie jak w TODO2,  W @Query użyj zapytania SQL.
         -napisz test do metody
    */

    @Query(value = "SELECT * FROM Hobbit WHERE first_name= :firstName AND last_name=:lastName", nativeQuery = true)
    List<Hobbit> findByFirstNameAndLastNameUsingSqlQuery(String firstName, String lastName);
}

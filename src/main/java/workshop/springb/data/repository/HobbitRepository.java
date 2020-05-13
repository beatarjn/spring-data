package workshop.springb.data.repository;

import org.springframework.data.repository.CrudRepository;
import workshop.springb.data.model.Hobbit;

import java.util.List;

/*
    TODO 3 Podejrzyj hierarchię interfejsów

            +--------------------+
            |      Repository    |      "Central repository marker interface (...)"
            +---------+----------+
                      ^
                      |
            +---------+----------+
            |   CrudRepository   |      "Interface for generic CRUD operations (...)"
            +---------+----------+
                      ^
                      |
            +---------+-----------+
            |  HobbitRepository   |     Na tym poziomie definiujemy typ encji i jej klucza <Hobbit, Long>,
            +---------------------+     oraz nasze własne metody - ich nazwa nie jest trywialna!

 */
public interface HobbitRepository extends CrudRepository<Hobbit, Long> {

    List<Hobbit> findByFirstNameAndLastName(String firstName, String lastName);

}

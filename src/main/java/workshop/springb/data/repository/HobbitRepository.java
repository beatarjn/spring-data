package workshop.springb.data.repository;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import workshop.springb.data.model.Hobbit;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface HobbitRepository extends CrudRepository<Hobbit, Long> {

    List<Hobbit> findByFirstNameAndLastName(String fisrtName, String lastName);


    List<Hobbit> findByFirstNameAndLastNameNamedQuery(String firstName, String lastName);


    List<Hobbit> findByFirstNameAndLastNameByNamedNativeQuery(String firstName, String lastName);



}

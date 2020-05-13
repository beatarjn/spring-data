package workshop.springb.data.repository;

import workshop.springb.data.model.Hobbit;

import java.util.List;

public interface CustomHobbitRepository {
    List<Hobbit> findWithCustomImplementation(String firstName, String lastName);
}

package workshop.springb.data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class HobbitRepositoryTest {

    @Autowired
    private HobbitRepository hobbitRepository;

    @Test
    public void shouldFindFrodo_usingRepositoryMethod(){
        assertEquals(1, hobbitRepository.findByFirstNameAndLastName("Frodo", "Baggins").size());
    }
}

package workshop.springb.data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class HobbitRepositoryTest {

    @Autowired
    private HobbitRepository hobbitRepository;

    @Test
    public void shouldFindFrodo_usingRepositoryMethod(){
        assertEquals(1, hobbitRepository.findByFirstNameAndLastName("Frodo", "Baggins").size());
    }

    @Test
    public void shouldFindHobbit_usingQuery(){
        assertEquals(1, hobbitRepository.findWithQuery("Frodo", "Baggins").size());
    }

    @Test
    public void shouldAddHobbit_usingNativeQuery(){
        assertEquals(1, hobbitRepository.findWithNativeQuery("Frodo", "Baggins").size());
    }


    @Test
    public void shouldAddHobbit_namedQuery(){
        assertEquals(1, hobbitRepository.findWithNamedQuery("Frodo", "Baggins").size());
    }

    @Test
    public void shouldAddHobbit_namedNativeQuery(){
        assertEquals(1, hobbitRepository.findWithNamedNativeQuery("Frodo", "Baggins").size());
    }

    @Test
    public void shouldAddHobbit_usingCustomImplementation(){
        assertEquals(1, hobbitRepository.findWithCustomImplementation("Frodo", "Baggins").size());
    }
}

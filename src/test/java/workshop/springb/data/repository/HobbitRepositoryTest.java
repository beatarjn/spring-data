package workshop.springb.data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import workshop.springb.data.model.Hobbit;

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
    public void  shouldFindFrodo_findByFirstNameAndLastNameUsingQuery(){
        Hobbit hobbit = new Hobbit("Frodo", "Baggins");
        hobbit.setId(1L);

        assertTrue(hobbitRepository.findByFirstNameAndLastNameUsingQuery("Frodo", "Baggins").contains(hobbit));
        assertEquals(1, hobbitRepository.findByFirstNameAndLastNameUsingQuery("Frodo", "Baggins").size());
    }

    @Test
    public void  shouldNotFindFrodo_findByFirstNameAndLastNameUsingQuery(){
        Hobbit hobbit = new Hobbit("Frodo", "Tuk");
        hobbit.setId(1L);

        assertFalse(hobbitRepository.findByFirstNameAndLastNameUsingQuery("Frodo", "Baggins").contains(hobbit));
        assertEquals(0, hobbitRepository.findByFirstNameAndLastNameUsingQuery(hobbit.getFirstName(), hobbit.getLastName()).size());
    }

    @Test
    public void  shouldFindFrodo_findByFirstNameAndLastNameUsingSqlQuery(){
        Hobbit hobbit = new Hobbit("Frodo", "Baggins");
        hobbit.setId(1L);

        assertTrue(hobbitRepository.findByFirstNameAndLastNameUsingSqlQuery("Frodo", "Baggins").contains(hobbit));
        assertEquals(1, hobbitRepository.findByFirstNameAndLastNameUsingSqlQuery("Frodo", "Baggins").size());
    }


}

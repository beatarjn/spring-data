package workshop.springb.data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    TODO 6 podejrzyj javadoc @DataJpaTest
    Zwróć uwagę na:
    - ile autokonfiguracji 'włącza' poniższa adnotacja (@AutoConfigure...)
    - metody domyślnie wywoływane są w transakcjach (@Transactional)
    - adnotacja 'włącza' logowanie (spring.jpa.show-sql)

 */
@DataJpaTest
class HobbitRepositoryTest {

    @Autowired
    private HobbitRepository hobbitRepository;

    @Test
    public void shouldFindFrodo_usingRepositoryMethod(){
        assertEquals(1, hobbitRepository.findByFirstNameAndLastName("Frodo", "Baggins").size());
    }

       /*
        ____________________________________________________________________________________________________________________
        TODO 1

        Uruchom test, zapoznaj się z logami.
        Poniżej opis tego, co już mamy w projekcie ( w kolejnych krokach przejdziemy przez poszczególne pliki)

        1. Encja Hobbit (obiekt tej klasy będzie zapisywany jako rekord w tabeli)
        2. HobbitRepository (Interfejs wykorzystujący API srping-data-jpa do zapisu danych)
        3. application.propertis (ustawienie logowania)
        4. data.sql (inicjalizacja danych w bazie)
        5. HobbitRepositoryTest (testuje, czy w bazie znajduje się hobbit z pliku data.sql)

        Test:

        +-----------------------+                +-------------------+
        | HobbitRepositoryTest  |                | HobbitRepository  |
        +-----------------------+                +-------------------+
                    |                                      |
                    |     findByFirstNameAndLastName       |                    +-----+
                    | ------------------------------------>| -----------------> | H2  |
                    |                                      |                    +-----+

        TODO 7
        Do przejrzenia (zapoznanie, nie uczymy sięna pamięć, wracamy do tematu, gdy jest aktualnie potrzeba).

        Jak nazwa metody, generuje zapytanie, przykładowy link:
        https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

        Jak zapełnić bazę, podczas podnoszenia kontekstu Spring'a
        liquibase, schema.sql / data.sql, @Sql etc.
        https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
        https://medium.com/@harittweets/evolving-your-database-using-spring-boot-and-liquibase-844fcd7931da

        adnotacje spring-data, spring-data-jpa, przykładowy link:
        https://www.baeldung.com/spring-data-annotations

        Kod:
        https://github.com/spring-projects/spring-data-book
        ____________________________________________________________________________________________________________________
                                                         \
                                                          \
                                                            /  \~~~/  \
                                                           (    ..     )----,
                                                            \__     __/      \
                                                              )|  /)         |\
                                                               | /\  /___\   / ^
                                                                "-|__|   |__|
    */
}

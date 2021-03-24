package workshop.springb.data.model;

import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
/*
    TODO 1 JPA API pozwala na definiowanie zapytań na poziomie encji.
    Analogicznie do definiowania zapytań przy użyciu @Query,
    możemy definiować zapytania JPQL ( używajćc @NamedQuery) i SQL (@NamedNativeQuery).

    Przykład:
    1. adnotacja na encji
    @NamedQuery(
        name = "Hobbit.getAllHobbits",
        query = "SELECT h FROM Hobbit h")

    2. metoda dodana do HobbitRepository (zwróć uwagę, na nazwę metody - taka sama jak w @NamedQuery
    List<Hobbit> getAllHobbits();

 */

/*
    TODO 2 utwórz @NamedQuery / metodę w HobbitRepository i test - zachowanie identyczne jak findByFirstNameAndLastName
    (zapytanie JPQL)
 */




/*
    TODO 3 utwórz @NamedNativeQuery / metodę w HobbitRepository i test - zachowanie identyczne jak findByFirstNameAndLastName
    (zapytanie SQL)
 */



@NamedQuery(name="Hobbit.findByFirstNameAndLastNameNamedQuery",query="SELECT h FROM Hobbit h WHERE h.firstName=:firstName AND h.lastName=:lastName")
@NamedNativeQuery(name="Hobbit.findByFirstNameAndLastNameByNamedNativeQuery",
        query="SELECT * FROM Hobbit h WHERE h.first_name=:firstName AND h.last_name=:lastName", resultClass = Hobbit.class)
public class Hobbit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

}

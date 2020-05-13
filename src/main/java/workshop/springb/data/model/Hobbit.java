package workshop.springb.data.model;

import lombok.*;

import javax.persistence.*;

/*
    TODO 2 encja (obiekt tej klasy będzie zapisywany w bazie)
    @Data, @RequiredArgsConstructor, @NoArgsConstructor, @NonNull - Lombok ( wygeneruje get/ set, konstruktory etc)
    @Entity, @Id, @GeneratedValue -javax.persistence (encja JPA)
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Hobbit {

    /*
        Zwróc uwagę na to, z jakiego pakietu pochodzi @Id, w naszym przykładzie używamy h2 (relacyjna baza danych).
        Mamy dostępne także  @org.springframework.data.annotation.Id - tej adnotacji użylibyśmy dla bazy MongoDB
        (Hobbit nie byłby wtedy encją [klasą mapowaną do tabeli z użyciem JPA])
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

}

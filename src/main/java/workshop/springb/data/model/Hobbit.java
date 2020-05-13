package workshop.springb.data.model;

import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(
        name = "Hobbit.findWithNamedQuery",
        query = "SELECT h FROM Hobbit h WHERE h.firstName = :firstName AND h.lastName= :lastName")
@NamedNativeQuery(
        name = "Hobbit.findWithNamedNativeQuery",
        query = "SELECT id, first_name, last_name  FROM Hobbit h WHERE h.first_name = :firstName AND h.last_name= :lastName",
        resultClass = Hobbit.class
)
public class Hobbit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

}

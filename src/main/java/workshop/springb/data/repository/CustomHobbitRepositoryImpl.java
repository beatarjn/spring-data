package workshop.springb.data.repository;

import workshop.springb.data.model.Hobbit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/*
    TODO 1 jeśli metody w repozytorium nie wystarczają, możemy zaimplementować własne zapytania
    Mamy już prostą, gotową implementację, chcemy żeby metoda findWithCustomImplementation była dostępna
    w API HobbitRepository. Jak to zrobić?
    1. Utwórz interfejs CustomHobbitRepository z zadeklarowaną metodą findWithCustomImplementation
    2. Rozszerz HobbitRepository o CustomHobbitRepository, tak żeby  rozszerzał CrudRepository i CustomHobbitRepository
    3. W API HobbitRepository pojawi się findWithCustomImplementation - napisz test dla nowej metody.
 */
public class CustomHobbitRepositoryImpl {
    /*
        Zamiast @Autowired - zalecane dla wstrzykiwania EntityManager'a
        różnica:
        https://stackoverflow.com/questions/31335211/autowired-vs-persistencecontext-for-entitymanager-bean/31335314
     */
    @PersistenceContext
    private EntityManager entityManager;


    public List<Hobbit> findWithCustomImplementation(String firstName, String lastName) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hobbit> cq = cb.createQuery(Hobbit.class);

        Root<Hobbit> hobbit = cq.from(Hobbit.class);

        Predicate namePredicate = cb.equal(hobbit.get("firstName"), firstName);
        Predicate lastNamePredicate = cb.like(hobbit.get("lastName"), lastName);
        cq.where(namePredicate, lastNamePredicate);

        TypedQuery<Hobbit> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}



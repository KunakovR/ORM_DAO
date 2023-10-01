package ru.netology.orm_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import ru.netology.orm_dao.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@EntityScan(basePackages = "ru.netology.orm_dao")
public class PersonRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public PersonRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonByCity(String city) {
        var query = entityManager.createQuery(
                "select p from Person p where p.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        query.getResultList().forEach(System.out::println);
        return query.getResultList();
    }
}

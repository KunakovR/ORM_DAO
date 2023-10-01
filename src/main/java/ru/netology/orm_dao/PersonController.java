package ru.netology.orm_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.orm_dao.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    private PersonRepo repository;

    @Autowired
    public PersonController(PersonRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonByCity(@RequestParam("city") String city) {
        return repository.getPersonByCity(city);
    }
}

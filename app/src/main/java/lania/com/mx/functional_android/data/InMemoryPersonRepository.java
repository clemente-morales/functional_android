package lania.com.mx.functional_android.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lania.com.mx.functional_android.domain.City;
import lania.com.mx.functional_android.domain.Person;
import lania.com.mx.functional_android.domain.PersonRepository;

/**
 * Created by moracl6 on 5/3/2017.
 */

public class InMemoryPersonRepository implements PersonRepository {
    List<Person> persons = new ArrayList<>();

    public InMemoryPersonRepository() {
        persons.add(new Person("Clemente", "Morales Fernandez", new City("Mexico")));
        persons.add(new Person("William", "Morales Fernandez", new City("Mexico")));
        persons.add(new Person("Abhishek", "Mudaliar", new City("India")));
        persons.add(new Person("Sarath", "Vaddi", new City("India")));
        persons.add(new Person("Dan", "Mr Lemon", new City("South Corea")));
        persons.add(new Person("Lin", "Huadong", new City("China")));
    }

    @Override
    public List<Person> getAll() {
        List<Person> allPersons = Collections.unmodifiableList(persons);
        Collections.sort(allPersons, new ComparatorByCityAndPersonName());

        return allPersons;
    }
}

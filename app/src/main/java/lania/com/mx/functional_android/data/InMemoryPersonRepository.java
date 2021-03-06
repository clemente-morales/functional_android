package lania.com.mx.functional_android.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import lania.com.mx.functional_android.models.City;
import lania.com.mx.functional_android.models.Person;
import lania.com.mx.functional_android.models.PersonRepository;

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
        List<Person> allPersons = new ArrayList<>(persons);
        Collections.sort(allPersons, new ComparatorByCityAndPersonName());

        return allPersons;
    }

    private void filterBrownEggs() {
        String someDish = "Some brown eggs";
        Predicate<String> eggs = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = eggs.and(brown);
        Predicate<String> otherEggs = eggs.and(brown.negate());

        boolean eatingBrownEggs = brownEggs.test(someDish);
    }
}

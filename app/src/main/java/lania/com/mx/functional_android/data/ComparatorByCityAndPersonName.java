package lania.com.mx.functional_android.data;

import java.util.Comparator;

import lania.com.mx.functional_android.domain.Person;

/**
 * Created by moracl6 on 5/3/2017.
 */

public class ComparatorByCityAndPersonName implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        Comparator<Person> comparator = Comparator.comparing(p -> p.getCity().getName());
        comparator = comparator.thenComparing(p -> p.getName());
        return comparator.compare(person1, person2);
    }
}

package lania.com.mx.functional_android.models;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

/**
 * Created by moracl6 on 5/3/2017.
 */

public class Person {
    private final String name;
    private final String lastName;
    private final City city;

    public Person(String name, String lastName, City city) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public City getCity() {
        return city;
    }

    public String getFullName() {
        return concatValues(name, " ", lastName);
    }

    private String concatValues(String... values) {
        // Function<String[], String> formatter = elements -> StringUtils.join(elements);
        Function<String[], String> formatter = StringUtils::join;
        return formatter.apply(values);
    }
}

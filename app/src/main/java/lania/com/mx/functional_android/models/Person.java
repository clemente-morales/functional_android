package lania.com.mx.functional_android.models;

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
        return name + " " + lastName;
    }
}

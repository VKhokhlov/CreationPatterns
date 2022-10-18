import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder age(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }

        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder address(String city) {
        this.address = city;
        return this;
    }

    public Person build() throws IllegalStateException {
        String requiredFields = "";

        if (name == null) {
            requiredFields += "name";
        }
        if (surname == null) {
            requiredFields += (requiredFields.isEmpty() ? "" : ",") + "surname";
        }
        if (!requiredFields.isEmpty()) {
            throw new IllegalStateException("Missing required fields: " + requiredFields);
        }
        if (age == null) {
            age = OptionalInt.empty();
        }

        return new Person(name, surname, age, address);
    }
}

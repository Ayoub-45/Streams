package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMethods {
    // a. Only adults
    public static List<Person> onlyAdults(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.getAge() >= 18)
                .collect(Collectors.toList());
    }

    // b. Average age
    public static double averageAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    // c. Last names separated with space
    public static String lastNamesSeparatedWithSpace(List<Person> persons) {
        return persons.stream()
                .map(Person::getLastName)
                .collect(Collectors.joining(" "));
    }

    // d. Group by first name
    public static Map<String, List<Person>> groupByFirstName(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getFirstName));
    }

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("John", "Doe", LocalDate.of(2000, 1, 1)),
                new Person("Jane", "Doe", LocalDate.of(2005, 5, 15)),
                new Person("Adam", "Adam", LocalDate.of(1990, 6, 20)),
                new Person("Eve", "Smith", LocalDate.of(1985, 12, 5))
        );

        System.out.println("Adults: " + onlyAdults(persons));
        System.out.println("Average Age: " + averageAge(persons));
        System.out.println("Last Names: " + lastNamesSeparatedWithSpace(persons));
        System.out.println("Grouped by First Name: " + groupByFirstName(persons));
    }

}

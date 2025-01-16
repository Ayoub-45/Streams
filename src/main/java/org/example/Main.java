package org.example;

import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Example list of people
        List<Person> people = List.of(
                new Person("John", "Doe", LocalDate.of(2000, 1, 1)),
                new Person("Jane", "Doe", LocalDate.of(2005, 5, 15)),
                new Person("Adam", "Adam", LocalDate.of(1990, 6, 20)),
                new Person("Eve", "Smith", LocalDate.of(1985, 12, 5))
        );

        // a. Only individuals with the last name "Doe"
        List<Person> does = people.stream()
                .filter(p -> p.getLastName().equals("Doe"))
                .toList();
        System.out.println("Last Name Doe: " + does);

        // b. Only individuals whose age is over 18
        List<Person> adults = people.stream()
                .filter(p -> p.getAge() > 18)
                .toList();
        System.out.println("Adults: " + adults);

        // c. Individuals with the same last and first name
        List<Person> sameName = people.stream()
                .filter(p -> p.getFirstName().equals(p.getLastName()))
                .toList();
        System.out.println("Same Name: " + sameName);

        // d. Unique last names in uppercase
        List<String> uniqueLastNames = people.stream()
                .map(Person::getLastName)
                .map(String::toUpperCase)
                .distinct()
                .toList();
        System.out.println("Unique Last Names: " + uniqueLastNames);

        // e. All individuals ordered by ascending date of birth
        List<Person> sortedByDob = people.stream()
                .sorted(Comparator.comparing(Person::getDateOfBirth))
                .toList();
        System.out.println("Sorted by DOB: " + sortedByDob);
    }

}

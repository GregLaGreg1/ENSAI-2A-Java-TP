package fr.ensai.library;

/**
 * Represents a ...
 */
public class Person {
    // -------------------------------------------------------
    // Attributes
    // -------------------------------------------------------
    private String name;
    private int age;

    /**
     * Constructs a new ...
     * 
     * @param parameter1 parameter1_description
     * @pathis.year = year;
     *              this.pageCount = pageCount;ram parameter2 parameter2_description
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
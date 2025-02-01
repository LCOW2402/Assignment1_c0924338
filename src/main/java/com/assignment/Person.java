package main.java.com.assignment;
import java.util.Objects;
import java.util.Optional;

public class Person {
    private String fullName;
    private Integer personAge;
    private Optional<Dog> petDog;

    // Constructor for initializing only name and age
    public Person(String fullName, Integer personAge) {
        this(fullName, personAge, null);
    }

    // Constructor for initializing all attributes
    public Person(String fullName, Integer personAge, Dog petDog) {
        this.fullName = fullName;
        this.personAge = personAge;
        this.petDog = Optional.ofNullable(petDog);
    }

    // Checks if the person has a senior dog (age >= 10)
    public boolean ownsSeniorDog() {
        return petDog.map(d -> d.getDogAge() >= 10).orElse(false);
    }

    // Renames the person's dog if they own one, otherwise throws an exception
    public void renameDog(String newName) {
        petDog.ifPresentOrElse(
            d -> d.setDogName(newName),
            () -> { throw new RuntimeException(this.fullName + " does not own a dog!"); }
        );
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    public Optional<Dog> getPetDog() {
        return petDog;
    }

    public void setPetDog(Dog petDog) {
        this.petDog = Optional.ofNullable(petDog);
    }

    // Override equals and hashCode for object comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person otherPerson = (Person) obj;
        return Objects.equals(fullName, otherPerson.fullName) &&
               Objects.equals(personAge, otherPerson.personAge) &&
               Objects.equals(petDog, otherPerson.petDog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, personAge, petDog);
    }
}
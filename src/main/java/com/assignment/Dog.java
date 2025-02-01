package main.java.com.assignment;
import java.util.Objects;

public class Dog {
    private String dogName;
    private Integer dogAge;

    public Dog(String dogName, Integer dogAge) {
        this.dogName = dogName;
        this.dogAge = dogAge;
    }

    // Getters and Setters
    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public Integer getDogAge() {
        return dogAge;
    }

    public void setDogAge(Integer dogAge) {
        this.dogAge = dogAge;
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dog otherDog = (Dog) obj;
        return Objects.equals(dogName, otherDog.dogName) && Objects.equals(dogAge, otherDog.dogAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogName, dogAge);
    }
}
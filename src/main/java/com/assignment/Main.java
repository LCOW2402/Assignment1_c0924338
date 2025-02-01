package main.java.com.assignment;
public class Main {
    public static void main(String[] args) {
        // Create a person without a dog
        Person personWithoutDog = new Person("John", 30);

        try {
            // Try to change the dog's name
            personWithoutDog.changeDogsName("Buddy");
        } catch (RuntimeException e) {
            System.out.println("Unable to change dog's name: " + e.getMessage());
        }
    }
}
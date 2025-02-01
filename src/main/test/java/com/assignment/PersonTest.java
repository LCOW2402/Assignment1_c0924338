package main.test.java.com.assignment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class PersonTest {

    @Test
    public void testPersonWithoutDog() {
        Person person = new Person("Alice", 25);
        assertEquals("Alice", person.getName());
        assertEquals(25, person.getAge());
        assertEquals(Optional.empty(), person.getDog());
    }

    @Test
    public void testPersonWithDog() {
        Dog dog = new Dog("Charlie", 12);
        Person person = new Person("Bob", 40, dog);
        assertTrue(person.getDog().isPresent());
        assertEquals(dog, person.getDog().get());
    }

    @Test
    public void testHasOldDog() {
        Dog oldDog = new Dog("Rocky", 10);
        Person personWithOldDog = new Person("David", 50, oldDog);
        assertTrue(personWithOldDog.hasOldDog());

        Dog youngDog = new Dog("Buddy", 5);
        Person personWithYoungDog = new Person("Eve", 35, youngDog);
        assertFalse(personWithYoungDog.hasOldDog());
    }

    @Test
    public void testChangeDogsName() {
        Dog dog = new Dog("Bruno", 7);
        Person person = new Person("Grace", 28, dog);
        person.changeDogsName("Max");
        assertEquals("Max", person.getDog().get().getName());
    }

    @Test
    public void testChangeDogsNameThrowsException() {
        Person personWithoutDog = new Person("Henry", 33);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            personWithoutDog.changeDogsName("Duke");
        });
        assertEquals("Henry does not own a dog!", exception.getMessage());
    }
}
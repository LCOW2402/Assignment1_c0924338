package main.test.java.com.assignment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DogTest {

    @Test
    public void testDogAttributes() {
        Dog dog = new Dog("Buddy", 5);
        assertEquals("Buddy", dog.getName());
        assertEquals(5, dog.getAge());
    }

    @Test
    public void testDogEquality() {
        Dog dog1 = new Dog("Rex", 7);
        Dog dog2 = new Dog("Rex", 7);
        assertEquals(dog1, dog2);
    }
}
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void personAttributes_firstName() {
        Person person = new Person("Sally",
                "Mills", 24);
        assertEquals("Sally", person.getFirstName());
        person.setFirstName("Rebecca");
        assertEquals("Rebecca", person.getFirstName());
    }

    @Test
    public void personAttributes_lastName() {
        Person person = new Person("Ann",
                "Johnson", 10);
        assertEquals("Johnson", person.getLastName());
        person.setLastName("Martin");
        assertEquals("Martin", person.getLastName());
    }

    @Test
    public void personAttributes_age() {
        Person person = new Person("Nancy",
                "Moore", 89);
        assertEquals(89, person.getAge());
        person.setAge(90);
        assertEquals(90, person.getAge());
    }

    @Test
    public void personAttributes_ageInvalid() {
        Person person = new Person("Marty",
                "Campbell", 40);
        assertEquals(40, person.getAge());
        person.setAge(30);
        assertEquals(40, person.getAge());
    }

    @Test
    public void personAttributes_introduceYourself() {
        ByteArrayOutputStream printOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printOut));

        Person person = new Person("Ruby",
                "Wilson", 56);
        person.introduceYourself();
        assertEquals("Hi, my name is Ruby Wilson and I'm 56\n",
                printOut.toString());

        System.setOut(System.out);
    }
}
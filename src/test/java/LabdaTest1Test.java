import model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LabdaTest1Test {


    @BeforeEach
    void setUp() {

        List<Person> osoba = List.of(new Person("jacek", Person.Sex.MALE,"zawislak.jacek@gmail.com",45));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void processPersonsWithFunction() {

    }
}
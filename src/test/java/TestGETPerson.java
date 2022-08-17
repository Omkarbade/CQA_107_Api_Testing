import helpers.PersonServiceHelper;
import model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertFalse;

public class TestGETPerson {

    private PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init() {
      personServiceHelper = new PersonServiceHelper();
    }
    @Test
    public void testGetAllPerson (){
        List<Person> personList = personServiceHelper.getAllPerson();
        assertNotNull(personList,"Person List is not Empty");
        assertFalse("Person List is not True", personList.isEmpty());
    }
}

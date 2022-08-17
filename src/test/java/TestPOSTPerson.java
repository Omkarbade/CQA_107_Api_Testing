import Constants.EndPoints;
import helpers.PersonServiceHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPOSTPerson {
    //
    //
    private PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init() {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testPOSTCreatePerson(){
        String id = personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id,"Person id is not Empty");

    }


}

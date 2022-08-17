package helpers;


import Constants.EndPoints;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Person;
import org.apache.http.HttpStatus;

import org.junit.Assert;
import utills.ConfigManagers;

import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonServiceHelper {
    //We need to read the config variable
    //Rest Assured About the URL,parte
    //make a get request on this url and send the data to TestGETPerson
    private  static  final String BASE_URL = ConfigManagers.getInstance().getString("base_url");
    private  static  final String PORT = ConfigManagers.getInstance().getString("port");


    public PersonServiceHelper(){

        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();

    }
    public List<Person>getAllPerson(){
       Response response =  RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_PERSON).andReturn();
        Type type = new TypeReference<List<Person>>() {}.getType();

        assertEquals(response.statusCode(), HttpStatus.SC_OK);
          List<Person> personList = response.as(type);
       return personList;

    }

    public Response createPerson(){
        Person person = new Person();
        person.setId("3");
        person.setFirstName("Sandesh");
        person.setLastName("Jawale");
        person.setPhoneNumber("789456133");
        person.setAddress("Mumbai,INDIA");

        //need to make a post call
        Response response =  RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(person)
                .post(EndPoints.CREATE_PERSON)
                .andReturn();
            assertEquals("Created",HttpStatus.SC_CREATED, response.getStatusCode());

        return response;

    }

    public Response updatePerson(Integer id){
        Person person = new Person();
        person.setId("3");
        person.setFirstName("Sandesh");
        person.setLastName("Jawale");
        person.setPhoneNumber("7894561335");
        person.setAddress("Mumbai,India");

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .when().body(person)
                .post(EndPoints.UPDATE_PERSON)
                .andReturn();
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        return response;
    }




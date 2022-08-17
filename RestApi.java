package CQA107;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RestApi {
    @Test(priority = 1)
    public void getTest() {
        Response response = RestAssured.get("http://localhost:3000/posts");

//        System.out.println(response.getStatusCode());                // Print the status code
       //  System.out.println(response.prettyPrint());
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test(priority = 2)
    public void postTest() {
        RequestSpecification request = RestAssured.given();         // Get the RequestSpecification of the request to be sent to the server.
        request.header("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id", "45");
        jsonObject.put("Name", "Ganesh");
        jsonObject.put("Job Profile", "Doctor");
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/posts");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());

//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.accept(ContentType.JSON);
//        requestSpecification.contentType("application/json");
//        requestSpecification.body("[\n" +
//                " { “id”: 16, “title”: “learn json-server”, “author”: “Mrinmay Mukherjee” }\n" +
//                " ]");
//        Response response = requestSpecification.request(Method.POST,"http://localhost:3000/posts");
//        response.prettyPrint();
////        System.out.println(response.getStatusCode());                // Print the status code
////        System.out.println(response.prettyPrint());
    }

    @Test(priority = 3)
    public void putTest() {
        RequestSpecification request = RestAssured.given();         // Get the RequestSpecification of the request to be sent to the server.
        request.header("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id", "45");
        jsonObject.put("Name", "Ganesh");
        jsonObject.put("Job Profile", "Doctor,Engineer");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/posts/26");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test(priority = 4)
    public void PatchTest() {
        RequestSpecification request = RestAssured.given();         // Get the RequestSpecification of the request to be sent to the server.
        request.header("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("Name", "Ganesh Marathe");

        request.body(jsonObject.toJSONString());
        Response response = request.patch("http://localhost:3000/posts/27");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test(priority = 5)
    public void deleteTest() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/posts/26");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    //-----------------------------------------Comments------------------------------------
    @Test
    public void get_Test() {
        Response response = RestAssured.get("http://localhost:3000/comments");
        System.out.println(response.getStatusCode());                // Print the status code
        System.out.println(response.prettyPrint());

    }

    @Test
    public void post_Test() {
        RequestSpecification request = RestAssured.given();         // Get the RequestSpecification of the request to be sent to the server.
        request.header("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("body", "Very good");
        jsonObject.put("postId", 3);
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/comments");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void put_Test() {
        RequestSpecification request = RestAssured.given();         // Get the RequestSpecification of the request to be sent to the server.
        request.header("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("body", "Very good, Excellent");
        jsonObject.put("postId", "3");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/comments/3");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void Patch_Test() {
        RequestSpecification request = RestAssured.given();         // Get the RequestSpecification of the request to be sent to the server.
        request.header("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("body", "Ek No., Kadak");

        request.body(jsonObject.toJSONString());
        Response response = request.patch("http://localhost:3000/comments/3");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void delete_Test() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/comments/3");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    //----------------------Profile---------------------------

    @Test
    public void getProfileTest() {
        Response response = RestAssured.get("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());                // Print the status code
        System.out.println(response.prettyPrint());

    }
    @Test
    public void postProile_Test() {
        RequestSpecification request = RestAssured.given();         // Get the RequestSpecification of the request to be sent to the server.
        request.header("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Typicode");               //"name": "typicode"

        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void deleteProfile_Test() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void gets_Test() {
        Response response = RestAssured.get("http://localhost:3000/posts/5");
        RequestSpecification request = RestAssured.given();         // Get the RequestSpecification of the request to be sent to the server.
        request.header("content-type", "application/json");



    }
    }

package CQA107;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;


public class Swagger {


   //user
    @Test
    public void create_user() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("{\r\n"
                + "  \"id\": 1,\r\n"
                + "  \"username\": \"Abcd13234\",\r\n"
                + "  \"firstName\": \"Omkar\",\r\n"
                + "  \"lastName\": \"Bade\",\r\n"
                + "  \"email\": \"abc123@gmail.com\",\r\n"
                + "  \"password\": \"abc1234\",\r\n"
                + "  \"phone\": \"1234567899\",\r\n"
                + "  \"userStatus\": 0\r\n"
                + "}");

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.POST, "https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test

    public void create_user_with_array() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("[\r\n"
                + "  {\r\n"
                + "    \"id\": 2,\r\n"
                + "    \"username\": \"Ra12\",\r\n"
                + "    \"firstName\": \"rahul\",\r\n"
                + "    \"lastName\": \"Jadhav\",\r\n"
                + "    \"email\": \"Rah1258@gmail.com\",\r\n"
                + "    \"password\": \"fgg45w\",\r\n"
                + "    \"phone\": \"4889697425\",\r\n"
                + "    \"userStatus\": 0\r\n"
                + "  }\r\n"
                + "]");

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.POST, "https://petstore.swagger.io/v2/user/createWithArray");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void create_user_with_List() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("[\r\n"
                + "  {\r\n"
                + "    \"id\": 3,\r\n"
                + "    \"username\": \"Ak123\",\r\n"
                + "    \"firstName\": \"Akashy\",\r\n"
                + "    \"lastName\": \"Bade\",\r\n"
                + "    \"email\": \"Bade2589@gmail.com\",\r\n"
                + "    \"password\": \"8569454\",\r\n"
                + "    \"phone\": \"8521478965\",\r\n"
                + "    \"userStatus\": 0\r\n"
                + "  }\r\n"
                + "]");

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.POST, "https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void get_user_by_name() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.GET, "https://petstore.swagger.io/v2/user/AB123");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void update_user() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("{\r\n"
                + "  \"id\": 1,\r\n"
                + "  \"username\": \"AB123\",\r\n"
                + "  \"firstName\": \"XYZ\",\r\n"
                + "  \"lastName\": \"ABC\",\r\n"
                + "  \"email\": \"BCD258@gmail.com\",\r\n"
                + "  \"password\": \"FGHhbA258\",\r\n"
                + "  \"phone\": \"9988553366\",\r\n"
                + "  \"userStatus\": 0\r\n"
                + "}");

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.PUT, "https://petstore.swagger.io/v2/user/AB123");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void delete_user() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.DELETE, "https://petstore.swagger.io/v2/user/AB123");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void user_login() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.queryParam("username", "AB123");
        requestSpecification.queryParam("PASSWORD","abcd1234");

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.GET, "https://petstore.swagger.io/v2/user/login?username=AB123&password=abcd1234");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void logout_user() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.GET, "https://petstore.swagger.io/v2/user/logout");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }


    // STORE

    @Test
    public void order_place() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("{\r\n"
                + "  \"id\": 11,\r\n"
                + "  \"petId\": 8,\r\n"
                + "  \"quantity\": 12,\r\n"
                + "  \"shipDate\": \"2022-07-28T04:05:29.026Z\",\r\n"
                + "  \"status\": \"placed\",\r\n"
                + "  \"complete\": true\r\n"
                + "}");

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.POST, "https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test

    public void find_purchase_orderbyid() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.GET, "https://petstore.swagger.io/v2/store/order/10");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }



    @Test
    public void delete_purchase_orderbyid() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.DELETE, "https://petstore.swagger.io/v2/store/order/11");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void pet_inventories() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.GET, "https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }



    // PET


    @Test
    public void create_new_pet() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("");

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.POST, "https://petstore.swagger.io/v2/pet\r\n"
                + "");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void get_pets_byid() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);



        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.GET, "https://petstore.swagger.io/v2/pet/9223372036854034403\r\n"
                + ""
                + ""
                + "");

        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test

    public void update_petbyid() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.body("{\r\n"
                + "  \"id\": 0,\r\n"
                + "  \"category\": {\r\n"
                + "    \"id\": 4,\r\n"
                + "    \"name\": \"Tommy\"\r\n"
                + "  },\r\n"
                + "  \"name\": \"dogie\",\r\n"
                + "  \"photoUrls\": [\r\n"
                + "    \"string\"\r\n"
                + "  ],\r\n"
                + "  \"tags\": [\r\n"
                + "    {\r\n"
                + "      \"id\": 0,\r\n"
                + "      \"name\": \"string\"\r\n"
                + "    }\r\n"
                + "  ],\r\n"
                + "  \"status\": \"available\"\r\n"
                + "}");

        requestSpecification.contentType("application/Json");
        Response response = requestSpecification.request(Method.PUT, "https://petstore.swagger.io/v2/pet/9223372036854034403\\r\\n"
                + ""
                + "");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 201);

    }

}


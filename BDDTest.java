package CQA107;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BDDTest {
    @Test
    public void getTest(){
        Response response = RestAssured.get("http://localhost:3000/posts");
        response.prettyPrint();
        given().
                when().
                get("http://localhost:3000/posts").then().statusCode(200);
    }

    @Test
    public void postTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",11);
        jsonObject.put("name","Suyog");
        jsonObject.put("job","pharmacy");
         given().
                 header("content-Type","application/json").
                 body(jsonObject.toJSONString()).
                 when().post("http://localhost:3000/posts").then().statusCode(200);
    }
    @Test
    public void putTest(){
        JSONObject jsonObject = new JSONObject();
       // jsonObject.put("id",11);
        //jsonObject.put("name","suyog");
        jsonObject.put("job","Doctor");
        given().
                header("content-Type","application/json").
                body(jsonObject.toJSONString()).
                when().put("http://localhost:3000/posts/11").then().statusCode(200);
    }
    @Test
    public void DeleteTest(){
        given().
                header("content-Type","application/json").
                when().delete("http://localhost:3000/posts/11").then().statusCode(200);
    }

    @Test
    public void get_Test(){
        Response response = RestAssured.get("http://localhost:3000/comments");
        response.prettyPrint();
        given().
                when().
                get("http://localhost:3000/comments").then().statusCode(200);
    }

    @Test
    public void post_Test(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",5);
        jsonObject.put("body","Nice");
        jsonObject.put("postId",5);
        given().
                header("content-Type","application/json").
                body(jsonObject.toJSONString()).
                when().post("http://localhost:3000/comments").then().statusCode(201);
    }
    @Test
    public void put_Test(){
        JSONObject jsonObject = new JSONObject();
        // jsonObject.put("id",11);
        //jsonObject.put("name","suyog");
        jsonObject.put("comments","Doctor");
        given().
                header("content-Type","application/json").
                body(jsonObject.toJSONString()).
                when().put("http://localhost:3000/comments/11").then().statusCode(200);
    }
    @Test
    public void Delete_Test(){
        given().
                header("content-Type","application/json").
                when().delete("http://localhost:3000/comments/11").then().statusCode(200);
    }

    @Test
    public void get_profileTest(){
        Response response = RestAssured.get("http://localhost:3000/profile");
        response.prettyPrint();
        given().
                when().
                get("http://localhost:3000/profile").then().statusCode(200);
    }

    @Test
    public void post_profileTest(){
        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("id",1);
        jsonObject.put("name","sugat");

        given().
                header("content-Type","application/json").
                body(jsonObject.toJSONString()).
                when().post("http://localhost:3000/profile").then().statusCode(200);
    }
    @Test
    public void put_profileTest(){
        JSONObject jsonObject = new JSONObject();
         jsonObject.put("id",2);
        jsonObject.put("name","Aman");

        given().
                header("content-Type","application/json").
                body(jsonObject.toJSONString()).
                when().put("http://localhost:3000/profile").then().statusCode(200);
    }
    @Test
    public void Delete_profileTest(){
        given().
                header("content-Type","application/json").
                when().delete("http://localhost:3000/profile").then().statusCode(200);
    }
}

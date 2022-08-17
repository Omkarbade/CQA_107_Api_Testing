package CQA107;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Serialization {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Test
    public void serilize() throws JsonProcessingException {

        Blogs_Post blog_Post = new Blogs_Post();
        blog_Post.setId(23);
        blog_Post.setTitle("json-server23");
        blog_Post.setAuthor("rahul");

        String urlString = "http://localhost:3000/posts";

        String jsonString = MAPPER.writeValueAsString(blog_Post);

        Response response = (Response) RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonString)
                .log()
                .all()
                .post(urlString);
        response.prettyPrint();
        response.statusCode();
    }
}

package CQA107;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import jdk.security.jarsigner.JarSignerException;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

public class Deserialization {
    @Test
    public void deserilization() throws JarSignerException {
        String urlString = "http://localhost:3000/posts";
        Blogs_Post blogs_post = RestAssured.given().get(urlString).as(Blogs_Post.class);

        System.out.println("javaobject:" +blogs_post);
        String urlString1 = "http://localhost:3000/posts";
        Type type = new TypeReference<List<Blogs_Post>>() {}.getType();
        List<Blogs_Post> blogs_postList =  RestAssured.get(urlString1).as(type);
        System.out.println("javaobject1:" +blogs_postList);
    }
}

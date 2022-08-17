package CQA107;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class SpotifyApi {

    String token ="Bearer BQAA7clEDAXn3tp5iX2njt1JeCEzZcoetNFG46YF7upvjsLrAhiv0LXIU-grWwJfqFTL1CZyp6KMU4h3V47NCcUxVjFvCXkwrbJ5wcOQnWm21y-57h0shtbxZSqVDYztHxcMANEpsOFoKJO-i7hDIVX0JFnJTEl5FaEC6ndvTzWY41DqI5IIeVfWgfYQGUmkphyyf5Py-BUCTkvD-o1k";
    String user_id ="24y5bnw97aloa1hui5u20aizt" ;


    @Test
    public void getUserCurrentProfile() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);
        Response response = requestSpecification.request(Method.GET, "\thttps://api.spotify.com/v1/me");
        String user_id = response.path("id");
        System.out.println("user id:" +user_id);

        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void getUserProfile() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);
        Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/users/"+ user_id);
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void getUserPlaylist() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);
        Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/users/"+ user_id+ "/playlists");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void CreatePlaylist() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Api Playlist");                             // "id": "17ZiafHuPdZ17WZDdAL2yW"
        jsonObject.put( "description", "New playlist description");           //"uri": "spotify:user:24y5bnw97aloa1hui5u20aizt"
        jsonObject.put("public", false);                                      //"uri": "spotify:playlist:17ZiafHuPdZ17WZDdAL2yW"
        requestSpecification.body(jsonObject.toJSONString());
        Response response = requestSpecification.request(Method.POST, "https://api.spotify.com/v1/users/24y5bnw97aloa1hui5u20aizt/playlists");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void SearchItemsTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);
        requestSpecification.param("q", "Dino James");
        requestSpecification.param("type","track");

        Response response = requestSpecification.request(Method.GET, "\thttps://api.spotify.com/v1/search");
        System.out.println(response.getStatusCode());
        response.prettyPrint();      //0ucEhTehPgWkVroKMnQdbz // "uri": "spotify:track:39m83gjG1lNr7Un0dJndFw"
    }
    @Test
    public void AddItemToPlaylist_Test() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);                          //spotify:track:4nKc9yiwXWlEByq1oMfHU6
        requestSpecification.queryParams("uris", "spotify:track:4nKc9yiwXWlEByq1oMfHU6");

        Response response = requestSpecification.request(Method.POST, "https://api.spotify.com/v1/playlists/17ZiafHuPdZ17WZDdAL2yW/tracks");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void GetPlaylistItems_Test() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);

        Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/playlists/17ZiafHuPdZ17WZDdAL2yW/tracks");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void RemovePlaylistItems_Test() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);
        requestSpecification.body("{ \"tracks\": [{ \"uri\": \"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\" }] }");
        Response response = requestSpecification.request(Method.DELETE, "https://api.spotify.com/v1/playlists/17ZiafHuPdZ17WZDdAL2yW/tracks");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void ChangePlaylist_Test() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType("Application/Json");
        requestSpecification.header("Authorization", token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "API Playlist");
        jsonObject.put( "description", "New playlist description");
        jsonObject.put("public", false);
        requestSpecification.body(jsonObject.toJSONString());

        Response response = requestSpecification.request(Method.PUT, "\thttps://api.spotify.com/v1/playlists/17ZiafHuPdZ17WZDdAL2yW");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

}

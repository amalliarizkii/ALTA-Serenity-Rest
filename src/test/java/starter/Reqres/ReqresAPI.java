package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import javax.print.DocFlavor;
import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/JSON";

    public static String GET_LIST_USERS = URL+"/api/users?page={page}";
    public static String GET_SINGLE_USERS = URL+"/api/users/{data.id}";
    public static String GET_LIST_RESOURCE = URL+"/api/unknown={page}";
    public static String POST_CREATE_NEW_USER = URL+"/api/users";
    public static String POST_REGISTER_SUCCESS = URL+"/api/register";
    public static String POST_REGISTER_UNSUCCESS = URL+"/api/register";
    public static String POST_LOGIN = URL+"/api/login";
    public static String PUT_UPDATE_USER = URL+"/api/users/{id}";
    public static String DELETE_USER = URL+"/api/users/{id}";

    @Step("Get list user")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Get list user with alphabet parameter page")
    public void getListUsersAlphabetParameter(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get list user with not registered parameter page")
    public void getListUserNotRegistered(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get list user with invalid parameter page")
    public void getListUsersInvalidParameter(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get list user with valid id")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("data.id",id);
    }

    @Step("Get single user with not registered id")
    public void getSingleUserNotRegistered(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Get single user with invalid id")
    public void getSingleUserInvalidId(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Get list resource with parameter page")
    public void getListResource(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get list resource with not registered parameter page")
    public void getListResourceNotRegisteredPage(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get list resource with alphabet parameter page")
    public void getListResourceWithAlphabetPage(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get list resource with invalid parameter page")
    public void getListResourceInvalidPage(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Post create new user with empty job")
    public void postNewUserEmptyJob(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create new user with empty name")
    public void postNewUserEmptyName(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register successful with valid email and password")
    public void postRegisterSuccess(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register unsuccessful with empty password")
    public void postRegisterUnsuccessEmptyPass(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register unsuccessful with empty email")
    public void postRegisterUnsuccessEmptyEmail(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register unsuccessful with invalid email and password")
    public void postRegisterUnsuccessInvalidUsername(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login successful with valid email and password")
    public void postLoginSuccess(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login unsuccessful with empty password")
    public void postLoginUnsuccessEmptyPass(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login unsuccessful with empty email")
    public void postLoginUnsuccessEmptyEmail(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login unsuccessful with invalid email and password")
    public void postLoginUnsuccessInvalidUsername(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user with not registered id")
    public void deleteUserNotRegisteredId(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Delete user with invalid id")
    public void deleteUserInvalidId(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}

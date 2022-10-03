package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;


import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //GET

    //Scenario Latihan(TC_001)
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should {int}")
    public void responseBodyPageShould(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Get list user json schema validator")
    public void getListUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/GetListUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Latihan (TC_002)
    @Given("Post create new user")
    public void postCreateNewUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostCreateNewUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Post create new user json schema validator")
    public void postCreateNewUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostNewUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Latihan(TC_003)
    @Given("Put update user with id {int}")
    public void putUpdateUserWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    //Scenario Latihan(TC_004)
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Should return {int} No content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    //Scenario Tugas(TC_001)
    @Given("Get list user with alphabet parameter page {string}")
    public void getListUserWithAlphabetParameterPage(String page) {
        reqresAPI.getListUsersAlphabetParameter(page);
    }

    @Then("Should return {int} Not found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    //Scenario Tugas(TC_002)
    @Given("Get list user with not registered parameter page {int}")
    public void getListUserWithNotRegisteredParameterPagePage(int page) {
        reqresAPI.getListUserNotRegistered(page);
    }

    //Scenario Tugas(TC_003)
    @Given("Get list user with invalid parameter page {string}")
    public void getListUserWithInvalidParameterPage(String page) {
        reqresAPI.getListUsersInvalidParameter(page);
    }

    //Scenario Tugas(TC_004)
    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidIdId(int id){
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS);
    }

    @And("Response body should contain first name {string} and last name {string}")
    public void responseBodyShouldContainFirstNameAndLastName(String first_name, String last_name) {
        SerenityRest.then()
                .body(ReqresResponses.FIRST_NAME,equalTo(first_name))
                .body(ReqresResponses.LAST_NAME,equalTo((last_name)));
    }

    @And("Get single user json schema validator")
    public void getSingleUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/GetSingleUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_005)
    @Given("Get single user with not registered id {int}")
    public void getSingleUserWithNotRegisteredIdId(int id) {
        reqresAPI.getSingleUserNotRegistered(id);
    }

    //Scenario Tugas(TC_006)
    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
        reqresAPI.getSingleUserInvalidId(id);
    }

    //Scenario Tugas(TC_007)
    @Given("Get list resource with parameter page {int}")
    public void getListResourceWithParameterPagePage(int page) {
        reqresAPI.getListResource(page);
    }

    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @And("Get single resource json schema validator")
    public void getSingleResourceJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/GetListResourceJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_008)
    @Given("Get list resource with not registered parameter page {int}")
    public void getListResourceWithNotRegisteredParameterPagePage(int page) {
        reqresAPI.getListResourceNotRegisteredPage(page);
    }

    //Scenario Tugas(TC_009)
    @Given("Get list resource with alphabet parameter page {string}")
    public void getListResourceWithAlphabetParameterPage(String page) {
        reqresAPI.getListResourceWithAlphabetPage(page);
    }

    //Scenario Tugas(TC_010)
    @Given("Get list resource with invalid parameter page {string}")
    public void getListResourceWithInvalidParameterPage(String page) {
        reqresAPI.getListResourceInvalidPage(page);
    }

    //POST
    //Scenario Tugas(TC_011)
    @Given("Post create new user with empty job")
    public void postCreateNewUserWithEmptyJob() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostNewUserEmptyJob.json");
        reqresAPI.postNewUserEmptyJob(json);
    }

    @Then("Should return {int} Bad request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Post create new user with empty job json schema validator")
    public void postCreateNewUserWithEmptyJobJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostNewUserEmptyJobJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_012)
    @Given("Post create new user with empty name")
    public void postCreateNewUserWithEmptyName() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostNewUserEmptyName.json");
        reqresAPI.postNewUserEmptyName(json);
    }

    @And("Post create new user with empty name json schema validator")
    public void postCreateNewUserWithEmptyNameJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostNewUserEmptyNameJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_013)
    @Given("Post register successful with valid email and password")
    public void postRegisterSuccessfulWithValidEmailAndPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterSuccess.json");
        reqresAPI.postRegisterSuccess(json);
    }

    @When("Send request post register successful")
    public void sendRequestPostRegisterSuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESS);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Post register successful json schema validator")
    public void postRegisterSuccessfulJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostRegisterSuccessJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_014)
    @Given("Post register unsuccessful with empty password")
    public void postRegisterUnsuccessfulWithEmptyPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterUnsuccessEmptyPass.json");
        reqresAPI.postRegisterUnsuccessEmptyPass(json);
    }

    @When("Send request post register unsuccessful")
    public void sendRequestPostRegisterUnsuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_UNSUCCESS);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Post register unsuccessful with empty password json schema validator")
    public void postRegisterUnsuccessfulWithEmptyPasswordJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostRegisterUnsuccessEmptyPassJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_015)
    @Given("Post register unsuccessful with empty email")
    public void postRegisterUnsuccessfulWithEmptyEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterUnsuccessEmptyEmail.json");
        reqresAPI.postRegisterUnsuccessEmptyEmail(json);
    }

    @And("Post register unsuccessful with empty email json schema validator")
    public void postRegisterUnsuccessfulWithEmptyEmailJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostRegisterUnsuccessEmptyEmailJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_016)
    @Given("Post register unsuccessful with invalid email and password")
    public void postRegisterUnsuccessfulWithInvalidEmailAndPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterUnsuccessInvalid.json");
        reqresAPI.postRegisterUnsuccessInvalidUsername(json);
    }

    @And("Post register unsuccessful with invalid email and password json schema validator")
    public void postRegisterUnsuccessfulWithInvalidEmailAndPasswordJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostRegisterUnsuccessInvalidUsernameJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_017)
    @Given("Post login successful with valid email and password")
    public void postLoginSuccessfulWithValidEmailAndPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginSuccess.json");
        reqresAPI.postLoginSuccess(json);
    }

    @When("Send request post login successful")
    public void sendRequestPostLoginSuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Post login successful json schema validator")
    public void postLoginSuccessfulJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostLoginSuccessJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_018)
    @Given("Post login unsuccessful with empty password")
    public void postLoginUnsuccessfulWithEmptyPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUnsuccessEmptyPass.json");
        reqresAPI.postLoginUnsuccessEmptyPass(json);
    }

    @When("Send request post login unsuccessful")
    public void sendRequestPostLoginUnsuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Post login unsuccessful with empty password json schema validator")
    public void postLoginUnsuccessfulWithEmptyPasswordJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostLoginUnsuccessEmptyPassJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_019)
    @Given("Post login unsuccessful with empty email")
    public void postLoginUnsuccessfulWithEmptyEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUnsuccessEmptyEmail.json");
        reqresAPI.postLoginUnsuccessEmptyEmail(json);
    }

    @And("Post login unsuccessful with empty email json schema validator")
    public void postLoginUnsuccessfulWithEmptyEmailJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostLoginUnsuccessEmptyEmailJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC-020)
    @Given("Post login unsuccessful with invalid email and password")
    public void postLoginUnsuccessfulWithInvalidEmailAndPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUnsuccessInvalid.json");
        reqresAPI.postLoginUnsuccessInvalidUsername(json);
    }

    @And("Post login unsuccessful with invalid email and password json schema validator")
    public void postLoginUnsuccessfulWithInvalidEmailAndPasswordJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostLoginUnsuccessInvalidJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas(TC_021)
    @Given("Delete user with not registered id {int}")
    public void deleteUserWithNotRegisteredIdId(int id) {
        reqresAPI.deleteUserNotRegisteredId(id);
    }

    //Scenario Tugas(TC_022)
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.deleteUserInvalidId(id);
    }

}

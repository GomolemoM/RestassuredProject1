import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

import org.testng.annotations.Test;


public class ResponseSpec {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getListDogBreed() {
        String getUrl = "https://dog.ceo/api/breeds/list/all";
        // Create a request specification
        requestSpecification = RestAssured.given();

        // Calling GET method
   response = requestSpecification.get();

        // Let's print response body.
        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);

        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();

        // Get status code
        validatableResponse.statusCode(200);

        // Check status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void isRetrieverOnListOfAllBreeds() {
        RestAssured.baseURI = "https://dog.ceo/api/breeds/list/all";

        given().when().then().log().all()

                //verify body
                .body("message", Matchers.equalTo("retriever"));

    }

    @Test
    public void retrieveAllSubBreedsForRetriever() {

        String getUrl = "https://dog.ceo/api/breed/retriever/list";
        // Create a request specification
        requestSpecification = RestAssured.given();

        // Calling GET method
        response = requestSpecification.get();

        // Let's print response body.
        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);

        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();

        // Get status code
        validatableResponse.statusCode(200);

        // Check status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");
    }

    public void randomLinkUnderSubBreedGolden() {
        String getUrl = "https://dog.ceo/api/breed/retriever/golden/images/random/";
        // Get status code
        validatableResponse.statusCode(200);

        // Check status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");


    }

    public void randomImageUnderSubBreedGolden() {
        String getUrl = "https://images.dog.ceo/breeds/retriever-golden/n02099601_238.jpg";
        // Get status code
        validatableResponse.statusCode(200);

        // Check status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");


    }

}


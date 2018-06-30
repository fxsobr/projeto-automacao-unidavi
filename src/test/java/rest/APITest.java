package rest;

import domain.Person;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class APITest {

    @BeforeMethod
    public void setUp(){
        baseURI = "http://localhost";
        port = 4567;
        basePath = "/api/v1/";

        RestAssured.defaultParser = Parser.JSON;

    }

    @Test
    public void inserirPessoa() {
        given()
                .contentType(ContentType.JSON)
                .body(new Person("Davi", "UNIDAVI", "CASA"))
                .when()
                    .post("person")
                .then()
                    .body("name", equalTo("Davi")).and()
                    .body("address", equalTo("UNIDAVI")).and()
                    .body("hobbies", equalTo("CASA")).and()
                    .statusCode(201);
    }


}

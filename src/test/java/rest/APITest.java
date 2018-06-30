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

    @Test
    public void validaPessoa(){
        when()
                .get("person/{id}","1")
        .then()
                .contentType("application/json").and()
                .body("name", equalTo("Marcelo"))
                .body("address", equalTo("UNIDAVI"))
                .body("hobbies", equalTo("Video game"))
                .statusCode(200);

    }

    @Test
    public void removerPessoa(){
        int id =
                given()
                        .contentType(ContentType.JSON)
                        .body(new Person("MBAPEH", "FRANÇA", "JOGADOR DE FUTEBOL"))
                .when()
                        .post("person")
                .then()
                        .extract()
                        .path("id");

        when()
                .delete("person/{id}", id)
        .then()
                .contentType(ContentType.JSON)
                .body("statusMessage", equalTo("success"))
                .body("message", equalTo("Person removed!"))
                .statusCode(202);
    }

    @Test
    public void alterarPessoa(){
        int id =
                given()
                        .contentType(ContentType.JSON)
                        .body(new Person("NEYMARSSSSS", "BRAZIL", "JOGADOR DE FUTEBOL"))
                        .when()
                        .post("person")
                        .then()
                        .extract()
                        .path("id");

        given()
                .contentType(ContentType.JSON)
                .body(new Person("OI OI", "BRAZIL", "JOGADOR DE FUTEBOL"))
        .when()
                .put("person/{id}", id)
        .then()
                .contentType(ContentType.JSON).and()
                .statusCode(200)
                .body("name", equalTo("OI OI"))
                .body("address", equalTo("BRAZIL"))
                .body("hobbies", equalTo("JOGADOR DE FUTEBOL"));
    }


}

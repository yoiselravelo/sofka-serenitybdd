package stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class StepsOrden {
    private String URLbase="https://petstore.swagger.io/v2/store";
    private Response response;

    @Step("Consulta de orden")
    public void consultarOrdenCompra(String numeroOrden) {
        RestAssured.baseURI = URLbase;
        response = RestAssured.given().when()
                .get("/order/"+numeroOrden)
                .then()
                .extract().response();
    }

    @Step("Delete orden")
    public void deleteOrdenCompra(String numeroOrden) {
        RestAssured.baseURI = URLbase;
        response = RestAssured.given().when()
                .delete("/order/"+numeroOrden)
                .then()
                .extract().response();
    }


    @Step("Create orden")
    public void createOrdenCompra(String body) {
        RestAssured.baseURI = URLbase;
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/order")
                .then()
                .extract().response();
    }

    @Step
    public void VerificarEstado_Http200() {
        response.then().statusCode(200);
    }

}

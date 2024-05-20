package runners;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TestInventario {

    private String URLbase="https://petstore.swagger.io/v2/store/inventory";

    @Test
    public void consultarInventarioExitosa() {
        RestAssured.when().get(URLbase).then().assertThat().statusCode(200);
    }
}

package runners;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepdefinitions.StepsOrden;

@RunWith(SerenityRunner.class)
public class TestCreate {

    @Steps
    StepsOrden stepsOrden;

    @Test
    public void createOrdenCompraExitosa() {
        // JSON de ejemplo para crear una orden de compra
        String jsonBody = "{ \"id\": 8, \"petId\": 8, \"quantity\": 88, \"shipDate\": \"2024-05-19T00:42:55.650Z\", \"status\": \"placed\", \"complete\": true }";
        stepsOrden.createOrdenCompra(jsonBody);
        stepsOrden.VerificarEstado_Http200();
        stepsOrden.consultarOrdenCompra("8");
        stepsOrden.VerificarEstado_Http200();
    }
}

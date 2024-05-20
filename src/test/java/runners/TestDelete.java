package runners;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepdefinitions.StepsOrden;

@RunWith(SerenityRunner.class)
public class TestDelete {

    @Steps
    StepsOrden stepsOrden;

    @Test
    public void deleteOrdenCompraExitosa() {
        stepsOrden.deleteOrdenCompra("8");
        stepsOrden.VerificarEstado_Http200();
    }
}

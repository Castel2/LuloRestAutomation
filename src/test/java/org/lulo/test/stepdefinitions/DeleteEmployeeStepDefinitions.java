package org.lulo.test.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import org.lulo.test.questions.ValidateEmployee;
import org.lulo.test.tasks.ConsumeDeleteMethod;

import static org.lulo.test.utils.ConstantsService.BASE_URL;
import static org.lulo.test.utils.ConstantsService.DELETE_URL;
import static org.lulo.test.utils.KeysActor.EMPTY;

public class DeleteEmployeeStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        OnStage.theActorCalled("LuloBank");
    }

    @When("^consumo el servicio delete employee con el id (.*) del empleado a eliminar$")
    public void consumoElServicioDeleteEmployeeConElIdDelEmpleadoAEliminar(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumeDeleteMethod.to(DELETE_URL.concat("/" + id)));
    }

    @And("^valido que el usuario eliminado corresponda al mismo id ingresado (.*)$")
    public void validoQueElUsuarioEliminadoCorrespondaAlMismoIdIngresado(String id) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateEmployee.information(id, EMPTY, EMPTY, EMPTY), Matchers.equalTo(true)));
    }

}

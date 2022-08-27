package org.lulo.test.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import org.lulo.test.questions.ValidateCodeResponse;
import org.lulo.test.questions.ValidateEmployee;
import org.lulo.test.questions.ValidateStatusMessage;
import org.lulo.test.tasks.ConsumeGetMethod;
import org.lulo.test.utils.ExceptionsConstants;

import static org.lulo.test.utils.ConstantsService.*;
import static org.lulo.test.utils.KeysActor.EMPTY;

public class GetEmployeesStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        OnStage.theActorCalled("LuloBank");
    }

    @When("^consumo el servicio get employees$")
    public void consumoElServicioGetEmployees() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumeGetMethod.to(EMPLOYEES_URL));
    }

    @Then("^se valida el codigo de respuesta (.*) y el estado (.*) de la peticion con su mensaje (.*)$")
    public void seValidaElCodigoDeRespuestaYElEstadoDeLaPeticionConSuMensaje(String code, String status, String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCodeResponse.check(code), Matchers.equalTo(true))
                .orComplainWith(Error.class, ExceptionsConstants.SERVICE_EXCEPTION));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateStatusMessage.checkStatusMessage(status, message), Matchers.equalTo(true)));
    }

    @And("^obtengo la lista de empleados que contiene el id (.*), el nombre del empleado (.*), el salario (.*) y sus edades (.*)$")
    public void obtengoLaListaDeEmpleadosQueContieneElIdElNombreDelEmpleadoElSalarioYSusEdades(String id, String name, String salary, String age) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateEmployee.information(id, name, salary, age), Matchers.equalTo(true)));
    }

    @When("^consumo el servicio get employees de manera erronea$")
    public void consumoElServicioGetEmployeesDeManeraErronea() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumeGetMethod.to(EMPLOYEES_URL_ERROR));
    }

    @Then("^se valida el codigo de respuesta (.*) y el mensaje (.*) de la peticion$")
    public void seValidaElCodigoDeRespuestaYElMensajeDeLaPeticion(String code, String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCodeResponse.check(code), Matchers.equalTo(true))
                .orComplainWith(Error.class, ExceptionsConstants.SERVICE_EXCEPTION));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateStatusMessage.checkStatusMessage(EMPTY, message), Matchers.equalTo(true)));
    }

}

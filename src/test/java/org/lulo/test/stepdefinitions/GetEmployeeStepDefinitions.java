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
import org.lulo.test.tasks.ConsumeGetMethod;

import static org.lulo.test.utils.ConstantsService.*;

public class GetEmployeeStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        OnStage.theActorCalled("LuloBank");
    }

    @When("^consumo el servicio get employee con el id (.*) del empleado a buscar$")
    public void consumoElServicioGetEmployeeConElIdDelEmpleadoABuscar(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumeGetMethod.to(EMPLOYEE_URL.concat("/" + id)));
    }

    @And("^obtengo el empleado con el id (.*), el nombre del empleado (.*), el salario (.*) y su edad (.*)$")
    public void obtengoElEmpleadoConElIdElNombreDelEmpleadoElSalarioYSuEdad(String id, String name, String salary, String age) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateEmployee.information(id, name, salary, age), Matchers.equalTo(true)));
    }

    @When("consumo el servicio get employee de manera erronea")
    public void consumoElServicioGetEmployeeDeManeraErronea() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumeGetMethod.to(EMPLOYEES_URL_ERROR));
    }


}

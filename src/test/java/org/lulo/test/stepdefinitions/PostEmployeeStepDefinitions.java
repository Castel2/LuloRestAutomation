package org.lulo.test.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import org.lulo.test.models.Body.DataEmployee;
import org.lulo.test.questions.ValidateEmployee;
import org.lulo.test.tasks.ConsumePostMethod;

import static org.lulo.test.utils.ConstantsService.BASE_URL;
import static org.lulo.test.utils.ConstantsService.CREATE_URL;
import static org.lulo.test.utils.KeysActor.EMPTY;

public class PostEmployeeStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        OnStage.theActorCalled("LuloBank");
    }

    @When("^consumo el servicio post employee con los datos del empleado nuevo como su nombre (.*), su salario (.*) y su edad (.*)$")
    public void consumoElServicioPostEmployeeConLosDatosDelEmpleadoNuevoComoSuNombreSuSalarioYSuEdad(String name, String salary, String age) {
        DataEmployee dataEmployee = new DataEmployee(name, salary, age);
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumePostMethod.to(CREATE_URL, dataEmployee));
    }

    @And("^obtengo el nuevo empleado con su id asociado y se presenta su nombre (.*), su salario (.*) y su edad (.*)$")
    public void obtengoElNuevoEmpleadoConSuIdAsociadoYSePresentaSuNombreSuSalarioYSuEdad(String name, String salary, String age) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateEmployee.information(EMPTY, name, salary, age), Matchers.equalTo(true)));
    }

}

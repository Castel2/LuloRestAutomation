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
import org.lulo.test.tasks.ConsumePutService;

import static org.lulo.test.utils.ConstantsService.BASE_URL;
import static org.lulo.test.utils.ConstantsService.UPDATE_URL;
import static org.lulo.test.utils.KeysActor.EMPTY;

public class PutEmployeeStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        OnStage.theActorCalled("LuloBank");
    }

    @When("^consumo el servicio put employee con los datos a actulizar del empleado como su nombre (.*), su salario (.*) y su edad (.*)$")
    public void consumoElServicioPutEmployeeConLosDatosAActulizarDelEmpleadoComoSuNombreSuSalarioYSuEdad(String name, String salary, String age) {
        DataEmployee dataEmployee = new DataEmployee(name, salary, age);
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumePutService.to(UPDATE_URL.concat("/20"), dataEmployee));
    }

    @And("^obtengo el empleado con sus datos de nombre (.*), su salario (.*) y su edad (.*) actualizados$")
    public void obtengoElEmpleadoConSusDatosDeNombreSuSalarioYSuEdadActualizados(String name, String salary, String age) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateEmployee.information(EMPTY, name, salary, age), Matchers.equalTo(true)));
    }

}

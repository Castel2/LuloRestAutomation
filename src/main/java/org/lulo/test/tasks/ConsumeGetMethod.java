package org.lulo.test.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.lulo.test.utils.ConstantsService.*;
import static org.lulo.test.utils.KeysActor.RESPONSE;
import static org.lulo.test.utils.KeysActor.SERVICE;

public class ConsumeGetMethod implements Task {

    private String path;

    public ConsumeGetMethod(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path));
        actor.remember(RESPONSE, SerenityRest.lastResponse());
        if (path.equals(EMPLOYEES_URL)) {
            actor.remember(SERVICE, SERVICE_GET_EMPLOYEES);
        } else if (path.equals(EMPLOYEES_URL_ERROR)) {
            actor.remember(SERVICE, SERVICE_GET_EMPLOYEES_ERROR);
        } else if (path.contains(EMPLOYEE_URL)) {
            actor.remember(SERVICE, SERVICE_GET_EMPLOYEE);
        }
    }

    public static ConsumeGetMethod to(String path) {
        return instrumented(ConsumeGetMethod.class, path);
    }
}

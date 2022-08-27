package org.lulo.test.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.lulo.test.utils.ConstantsService.SERVICE_DELETE;
import static org.lulo.test.utils.KeysActor.RESPONSE;
import static org.lulo.test.utils.KeysActor.SERVICE;

public class ConsumeDeleteMethod implements Task {
    private String path;

    public ConsumeDeleteMethod(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(path));
        actor.remember(RESPONSE, SerenityRest.lastResponse());
        actor.remember(SERVICE, SERVICE_DELETE);
    }

    public static ConsumeDeleteMethod to(String path) {
        return instrumented(ConsumeDeleteMethod.class, path);
    }
}

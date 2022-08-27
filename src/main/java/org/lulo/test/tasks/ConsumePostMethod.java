package org.lulo.test.tasks;

import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.lulo.test.models.Body.DataEmployee;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.lulo.test.utils.ConstantsService.SERVICE_POST;
import static org.lulo.test.utils.KeysActor.RESPONSE;
import static org.lulo.test.utils.KeysActor.SERVICE;

public class ConsumePostMethod implements Task {

    private String path;
    private DataEmployee body;

    public ConsumePostMethod(String path, DataEmployee body) {
        this.path = path;
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(path).with(request -> request.body(body, ObjectMapperType.GSON)));
        actor.remember(RESPONSE, SerenityRest.lastResponse());
        actor.remember(SERVICE, SERVICE_POST);
    }

    public static ConsumePostMethod to(String path, DataEmployee body) {
        return instrumented(ConsumePostMethod.class, path, body);
    }

}

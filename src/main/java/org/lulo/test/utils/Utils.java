package org.lulo.test.utils;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import org.lulo.test.models.Responses.*;

import static org.lulo.test.utils.ConstantsService.*;
import static org.lulo.test.utils.KeysActor.SERVICE;

public class Utils {

    public static Object responseAssigned(Response response, Actor actor) {
        Object objectResponseMapper = null;
        if (actor.recall(SERVICE).equals(SERVICE_GET_EMPLOYEES)) {
            objectResponseMapper = response.getBody().as(EmployeesResponse.class, ObjectMapperType.GSON);
        } else if (actor.recall(SERVICE).equals(SERVICE_GET_EMPLOYEE)) {
            objectResponseMapper = response.getBody().as(EmployeeResponse.class, ObjectMapperType.GSON);
        } else if (actor.recall(SERVICE).equals(SERVICE_POST)) {
            objectResponseMapper = response.getBody().as(CreateEmployeeResponse.class, ObjectMapperType.GSON);
        } else if (actor.recall(SERVICE).equals(SERVICE_PUT)) {
            objectResponseMapper = response.getBody().as(UpdateEmployeeResponse.class, ObjectMapperType.GSON);
        } else if (actor.recall(SERVICE).equals(SERVICE_DELETE)) {
            objectResponseMapper = response.getBody().as(DeleteEmployeeResponse.class, ObjectMapperType.GSON);
        } else if (actor.recall(SERVICE).equals(SERVICE_GET_EMPLOYEES_ERROR)) {
            objectResponseMapper = response.getBody().as(ErrorResponse.class, ObjectMapperType.GSON);
        }
        return objectResponseMapper;
    }

}

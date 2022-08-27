package org.lulo.test.questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.lulo.test.models.Responses.*;
import org.lulo.test.utils.KeysActor;

import static org.lulo.test.utils.KeysActor.RESPONSE_SERVICE;
import static org.lulo.test.utils.Utils.responseAssigned;

public class ValidateStatusMessage implements Question<Boolean> {

    private String status;
    private String message;

    public ValidateStatusMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean checkStatus= false;
        boolean checKMessage = false;
        Response response = actor.recall(KeysActor.RESPONSE);
        Object objetoResponse = responseAssigned(response, actor);
        actor.remember(RESPONSE_SERVICE, objetoResponse);
        if (objetoResponse instanceof EmployeesResponse) {
            checkStatus = ((EmployeesResponse) objetoResponse).getStatus().equals(status);
            checKMessage = ((EmployeesResponse) objetoResponse).getMessage().equals(message);
        } else if (objetoResponse instanceof EmployeeResponse) {
            checkStatus = ((EmployeeResponse) objetoResponse).getStatus().equals(status);
            checKMessage = ((EmployeeResponse) objetoResponse).getMessage().equals(message);
        } else if (objetoResponse instanceof CreateEmployeeResponse) {
            checkStatus = ((CreateEmployeeResponse) objetoResponse).getStatus().equals(status);
            checKMessage = ((CreateEmployeeResponse) objetoResponse).getMessage().equals(message);
        } else if (objetoResponse instanceof UpdateEmployeeResponse) {
            checkStatus = ((UpdateEmployeeResponse) objetoResponse).getStatus().equals(status);
            checKMessage = ((UpdateEmployeeResponse) objetoResponse).getMessage().equals(message);
        }else if (objetoResponse instanceof DeleteEmployeeResponse) {
            checkStatus = ((DeleteEmployeeResponse) objetoResponse).getStatus().equals(status);
            checKMessage = ((DeleteEmployeeResponse) objetoResponse).getMessage().equals(message);
        }else if (objetoResponse instanceof ErrorResponse) {
            checkStatus = true;
            checKMessage = ((ErrorResponse) objetoResponse).getMessage().equals(message);
        }
        System.out.println(checkStatus && checKMessage);
        return checkStatus && checKMessage;
    }

    public static ValidateStatusMessage checkStatusMessage(String status, String message) {
        return new ValidateStatusMessage(status, message);
    }
}

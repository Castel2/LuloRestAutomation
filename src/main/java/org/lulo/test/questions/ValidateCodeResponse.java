package org.lulo.test.questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.lulo.test.utils.KeysActor;

public class ValidateCodeResponse implements Question<Boolean> {
    private String code;

    public ValidateCodeResponse(String code) {
        this.code = code;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = actor.recall(KeysActor.RESPONSE);
        boolean validateCode = false;
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
        if(String.valueOf(response.getStatusCode()).equals(code)){
            validateCode = true;
        }
        System.out.println(validateCode);
        return validateCode;
    }

    public static ValidateCodeResponse check(String code){
        return new ValidateCodeResponse(code);
    }
}

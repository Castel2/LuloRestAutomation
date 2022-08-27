package org.lulo.test.exceptions;

public class ValidateServiceException  extends Error{

    public ValidateServiceException (String message, Throwable cause){
        super(message,cause);
    }

}

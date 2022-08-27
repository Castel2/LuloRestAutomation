package org.lulo.test.models.Responses;

import com.google.gson.annotations.Expose;
import org.lulo.test.models.CreateEmployee;

public class CreateEmployeeResponse {

    @Expose
    private String status;

    @Expose
    private CreateEmployee data;

    @Expose
    private String message;

    public CreateEmployeeResponse() {
    }

    public CreateEmployeeResponse(String status, CreateEmployee data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CreateEmployee getData() {
        return data;
    }

    public void setData(CreateEmployee data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CreateEmployeeResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}

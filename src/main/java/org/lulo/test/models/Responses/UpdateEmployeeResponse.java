package org.lulo.test.models.Responses;

import com.google.gson.annotations.Expose;
import org.lulo.test.models.Body.DataEmployee;

public class UpdateEmployeeResponse {

    @Expose
    private String status;

    @Expose
    private DataEmployee data;

    @Expose
    private String message;

    public UpdateEmployeeResponse() {
    }

    public UpdateEmployeeResponse(String status, DataEmployee data, String message) {
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

    public DataEmployee getData() {
        return data;
    }

    public void setData(DataEmployee data) {
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
        return "UpdateEmployeeResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}

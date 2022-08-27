package org.lulo.test.models.Responses;

import com.google.gson.annotations.Expose;

public class DeleteEmployeeResponse {

    @Expose
    private String status;

    @Expose
    private String data;

    @Expose
    private String message;

    public DeleteEmployeeResponse() {
    }

    public DeleteEmployeeResponse(String status, String data, String message) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
        return "DeleteEmployeeResponse{" +
                "status='" + status + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

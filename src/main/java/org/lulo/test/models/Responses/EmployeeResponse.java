package org.lulo.test.models.Responses;

import com.google.gson.annotations.Expose;
import org.lulo.test.models.Employee;

public class EmployeeResponse {

    @Expose
    private String status;

    @Expose
    private Employee data;

    @Expose
    private String message;

    public EmployeeResponse() {
    }

    public EmployeeResponse(String status, Employee data, String message) {
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

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
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
        return "EmployeeResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}

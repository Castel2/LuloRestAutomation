package org.lulo.test.models.Responses;

import com.google.gson.annotations.Expose;
import org.lulo.test.models.Employee;

import java.util.List;

public class EmployeesResponse {

    @Expose
    private String status;

    @Expose
    private List<Employee> data;

    @Expose
    private String message;

    public EmployeesResponse() {
    }

    public EmployeesResponse(String status, List<Employee> data, String message) {
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

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
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

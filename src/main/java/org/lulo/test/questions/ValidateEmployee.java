package org.lulo.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.lulo.test.models.Employee;
import org.lulo.test.models.Responses.*;

import static org.lulo.test.utils.KeysActor.EMPTY;
import static org.lulo.test.utils.KeysActor.RESPONSE_SERVICE;

public class ValidateEmployee implements Question<Boolean> {

    private String id;
    private String employee_name;
    private String employee_salary;
    private String employee_age;

    public ValidateEmployee(String id, String employee_name, String employee_salary, String employee_age) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean checkEmployee = true;
        Object objetoResponse = actor.recall(RESPONSE_SERVICE);
        if (objetoResponse instanceof EmployeesResponse) {
            System.out.println("El objetoResponse es instancia de EmployeesResponse");
            for (Employee iter : ((EmployeesResponse) objetoResponse).getData()) {
                if (iter.getId().equals(id) && iter.getEmployee_name().equals(employee_name)
                        && iter.getEmployee_salary().equals(employee_salary) && iter.getEmployee_age().equals(employee_age)) {
                    checkEmployee = true;
                }
            }
        }else if (objetoResponse instanceof EmployeeResponse) {
            System.out.println("El objetoResponse es instancia de EmployeeResponse");
            if (((EmployeeResponse) objetoResponse).getData().getId().equals(id) && ((EmployeeResponse) objetoResponse).getData().getEmployee_name().equals(employee_name)
                    && ((EmployeeResponse) objetoResponse).getData().getEmployee_salary().equals(employee_salary) && ((EmployeeResponse) objetoResponse).getData().getEmployee_age().equals(employee_age)) {
                checkEmployee = true;
            }
        } else if (objetoResponse instanceof CreateEmployeeResponse) {
            System.out.println("El objetoResponse es instancia de CreateEmployeeResponse");
            if (((CreateEmployeeResponse) objetoResponse).getData().getName().equals(employee_name) && ((CreateEmployeeResponse) objetoResponse).getData().getSalary().equals(employee_salary)
                    && ((CreateEmployeeResponse) objetoResponse).getData().getAge().equals(employee_age) && !((CreateEmployeeResponse) objetoResponse).getData().getId().equals(EMPTY)) {
                checkEmployee = true;
            }
        } else if (objetoResponse instanceof UpdateEmployeeResponse) {
            System.out.println("El objetoResponse es instancia de UpdateEmployeeResponse");
            if (((UpdateEmployeeResponse) objetoResponse).getData().getName().equals(employee_name) && ((UpdateEmployeeResponse) objetoResponse).getData().getSalary().equals(employee_salary)
                    && ((UpdateEmployeeResponse) objetoResponse).getData().getAge().equals(employee_age)) {
                checkEmployee = true;
            }
        } else if (objetoResponse instanceof DeleteEmployeeResponse) {
            System.out.println("El objetoResponse es instancia de DeleteEmployeeResponse");
            if (((DeleteEmployeeResponse) objetoResponse).getData().equals(id)) {
                checkEmployee = true;
            }
        }
        System.out.println(checkEmployee);
        return checkEmployee;
    }

    public static ValidateEmployee information(String id, String employee_name, String employee_salary, String employee_age) {
        return new ValidateEmployee(id, employee_name, employee_salary, employee_age);
    }


}

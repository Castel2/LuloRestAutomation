package org.lulo.test.models;

import com.google.gson.annotations.Expose;

public class CreateEmployee {

    @Expose
    private String name;

    @Expose
    private String salary;

    @Expose
    private String age;

    @Expose
    private String id;

    public CreateEmployee() {
    }

    public CreateEmployee(String name, String salary, String age, String id) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeCreate{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

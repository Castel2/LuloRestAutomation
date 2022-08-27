package org.lulo.test.models.Body;

import com.google.gson.annotations.Expose;

public class DataEmployee {

    @Expose
    private String name;

    @Expose
    private String salary;

    @Expose
    private String age;

    public DataEmployee() {
    }

    public DataEmployee(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
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

    @Override
    public String toString() {
        return "DataEmployee{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

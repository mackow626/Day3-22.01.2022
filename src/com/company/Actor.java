package com.company;

public class Actor {
    String name;
    String lastName;
    double salary;
    SexEnum sex;

    @Override
    public String toString() {
        return "Actor{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            ", sex=" + sex +
            '}';
    }

    public Actor(String name, String lastName, double salary, SexEnum sex) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}

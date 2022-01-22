package com.company;

public class Director {
    String name;
    String lastName;
    double salary;
    boolean hasOscar;

    public Director(String name, String lastName, double salary, boolean hasOscar) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.hasOscar = hasOscar;
    }

    @Override
    public String toString() {
        return "Director{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            ", hasOscar=" + hasOscar +
            '}';
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

    public boolean isHasOscar() {
        return hasOscar;
    }

    public void setHasOscar(boolean hasOscar) {
        this.hasOscar = hasOscar;
    }
}

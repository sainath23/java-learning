package com.sainath.lang;

import java.util.Objects;

public class Employee implements Cloneable {
    private String empId;
    private String name;
    private Address address;

    public Employee() {}

    public Employee(String empId) {
        this.empId = empId;
    }

    public Employee(String empId, String name, Address address) {
        this.empId = empId;
        this.name = name;
        Address cloneAddr = new Address(address.getCity());
        this.address = cloneAddr;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId.equals(employee.empId) &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Address {
    private String city;

    public Address() {
    }

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
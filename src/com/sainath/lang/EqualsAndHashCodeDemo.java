package com.sainath.lang;

public class EqualsAndHashCodeDemo implements Cloneable {
    private int x = 10;
    public static void main(String[] args) throws CloneNotSupportedException {

        Employee e1 = new Employee("e1", "Sainath", new Address("Mumbai"));
        Employee e2 = new Employee("e2");
        System.out.println(e1.equals(e2));
        System.out.println(e1 == e2);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e1.toString());
        System.out.println(Integer.toHexString(e1.hashCode()));
        System.out.println(e1.equals(null));
        EqualsAndHashCodeDemo d1 = new EqualsAndHashCodeDemo();
        EqualsAndHashCodeDemo d2 = (EqualsAndHashCodeDemo) d1.clone();
        Employee employee = (Employee) e1.clone();
        System.out.println(e1 == employee);
        System.out.println(e1.getName());
        employee.setName("ZZZ");
        System.out.println(e1.getName());
        System.out.println(employee.getName());

        System.out.println(e1.getAddress().getCity());
        e1.getAddress().setCity("Pune");
        System.out.println(employee.getAddress().getCity());
        employee.getAddress().setCity("Thane");
        System.out.println(e1.getAddress().getCity());

        e1.setEmpId("e5");
        System.out.println(employee.getEmpId());
        employee.setEmpId("e6");
        System.out.println(e1.getEmpId());
    }
}

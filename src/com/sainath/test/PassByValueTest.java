package com.sainath.test;

public class PassByValueTest {
    class Dog {
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        PassByValueTest obj = new PassByValueTest();
        Dog sheru = obj.new Dog("Sheru");
        Dog copySheru = sheru;

        System.out.println("1. " + sheru.hashCode());
        obj.modifyDog(sheru);

        System.out.println(sheru.getName());
        System.out.println(copySheru.getName());
        System.out.println(sheru.equals(copySheru));
    }

    public void modifyDog(Dog dog) {
        System.out.println("2. " + dog.hashCode());
        dog.setName("Raju");
        dog = new Dog("Pinki");
        System.out.println("3. " + dog.hashCode());
        dog.setName("Rinku");
    }
}

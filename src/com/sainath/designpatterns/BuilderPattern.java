package com.sainath.designpatterns;

// Creation Design Pattern
public class BuilderPattern {

    class Phone {
        private String name;
        private String os;
        private int ram;
        private String processor;
        private double size;

        public Phone(String name, String os, int ram, String processor, double size) {
            this.name = name;
            this.os = os;
            this.ram = ram;
            this.processor = processor;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "name='" + name + '\'' +
                    ", os='" + os + '\'' +
                    ", ram=" + ram +
                    ", processor='" + processor + '\'' +
                    ", size=" + size +
                    '}';
        }
    }

    class PhoneBuilder {
        private String name;
        private String os;
        private int ram;
        private String processor;
        private double size;

        public PhoneBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PhoneBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public PhoneBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public PhoneBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public PhoneBuilder setSize(double size) {
            this.size = size;
            return this;
        }

        public Phone buildPhone() {
            return new Phone(name, os, ram, processor, size);
        }
    }

    public static void main(String[] args) {
        BuilderPattern bp = new BuilderPattern();
        Phone myPhone = bp.new PhoneBuilder().setName("My Phone").setOs("Android 10").buildPhone();
        System.out.println(myPhone);
    }
}

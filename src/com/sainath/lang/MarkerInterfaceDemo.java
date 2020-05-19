package com.sainath.lang;

public class MarkerInterfaceDemo {

    // Marker interface
    interface AllowPrint {
    }

    static class PrintNotSupportedException extends RuntimeException {
        public PrintNotSupportedException() {
            super("Please implement AllowPrint interface...");
        }
    }

    static class Printer {
        public void print() {
            if (!(this instanceof AllowPrint)) {
                throw new PrintNotSupportedException();
            }
            System.out.println("You're allowed to print...");
        }
    }

    static class MyPrinter extends Printer implements AllowPrint {
    }

    public static void main(String[] args) {
        MyPrinter myPrinter = new MyPrinter();
        myPrinter.print();
    }
}

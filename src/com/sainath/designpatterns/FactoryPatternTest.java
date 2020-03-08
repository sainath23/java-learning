package com.sainath.designpatterns;

import java.util.Calendar;

// Creation Design Pattern
public class FactoryPatternTest {

    interface OperatingSystem {
        void aboutMe();
    }

    class Android implements OperatingSystem {
        @Override
        public void aboutMe() {
            System.out.println("I am Android OS");
        }
    }

    class Windows implements OperatingSystem {
        @Override
        public void aboutMe() {
            System.out.println("I am Windows 10 OS");
        }
    }

    class MacOs implements OperatingSystem {
        @Override
        public void aboutMe() {
            System.out.println("I am MacOs Catalina");
        }
    }

    class OsFactory {
        public OperatingSystem getOs(String name) {
            if ("Android".equals(name)) {
                return new Android();
            } else if ("Windows".equals(name)) {
                return new Windows();
            } else if ("MacOs".equals(name)) {
                return new MacOs();
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        FactoryPatternTest fpt = new FactoryPatternTest();
        OsFactory osFactory = fpt.new OsFactory();

        OperatingSystem androidOs = osFactory.getOs("Android");
        androidOs.aboutMe();

        Calendar calendar = Calendar.getInstance();
    }
    
}

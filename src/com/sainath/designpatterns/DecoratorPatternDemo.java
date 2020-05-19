package com.sainath.designpatterns;

public class DecoratorPatternDemo {
    // Beverage Interface
    interface Beverage {
        int getCost();
        String getDescription();
    }

    // Coffee is one of the beverage
    static class Coffee implements Beverage {
        private int cost;

        public Coffee(int cost) {
            this.cost = cost;
        }

        @Override
        public int getCost() {
            return cost;
        }

        @Override
        public String getDescription() {
            return "Coffee";
        }
    }

    // Tea is another beverage
    static class Tea implements Beverage {
        private int cost;

        public Tea(int cost) {
            this.cost = cost;
        }

        @Override
        public int getCost() {
            return cost;
        }

        @Override
        public String getDescription() {
            return "Tea";
        }
    }

    // Beverage decorator
    static abstract class BeverageDecorator implements Beverage {
        private Beverage beverage;

        public BeverageDecorator(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public int getCost() {
            return beverage.getCost();
        }

        @Override
        public String getDescription() {
            return beverage.getDescription();
        }
    }

    // Cream as add on i.e. one of the beverage decorator
    static class Cream extends BeverageDecorator {
        private int cost;

        public Cream(Beverage beverage, int cost) {
            super(beverage);
            this.cost = cost;
        }

        @Override
        public int getCost() {
            return super.getCost() + cost;
        }

        @Override
        public String getDescription() {
            return super.getDescription() + " topped with Cream";
        }
    }

    public static void main(String[] args) {
        Beverage beverage = new Cream(new Coffee(100), 10);
        System.out.println(beverage.getCost());
        System.out.println(beverage.getDescription());
    }
}

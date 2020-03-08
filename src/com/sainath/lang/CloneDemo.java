package com.sainath.lang;

public class CloneDemo {
    private class CloneMe implements Cloneable {
        private int x;
        private int y;
        private String str;
        private StringBuilder sb;

        public CloneMe() {
        }

        public CloneMe(int x, int y, String str, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.str = str;
            this.sb = sb;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public StringBuilder getSb() {
            return sb;
        }

        public void setSb(StringBuilder sb) {
            this.sb = sb;
        }

        @Override
        protected CloneMe clone() throws CloneNotSupportedException {
            CloneMe cloneMe = (CloneMe) super.clone();
            cloneMe.setSb(new StringBuilder(sb));
            return cloneMe;
        }

        @Override
        public String toString() {
            return "CloneMe{" +
                    "x=" + x +
                    ", y=" + y +
                    ", str='" + str + '\'' +
                    ", sb=" + sb +
                    '}';
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo cloneDemo = new CloneDemo();
        CloneMe c1 = cloneDemo.new CloneMe(10, 20, "Computer", new StringBuilder("Sainath"));
        CloneMe c2 = (CloneMe) c1.clone();

        System.out.println("Before making change: c1 = " + c1);
        System.out.println("Before making change: c2 = " + c2);

        c1.setX(100);
        c1.setY(200);
        c1.setStr("Engg");
        c1.setSb(c1.getSb().append(" Parkar"));

        System.out.println("After making change: c1 = " + c1);
        System.out.println("After making change: c2 = " + c2);

    }
}

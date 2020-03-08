package com.sainath.oops;

import java.util.Scanner;

public class WhackAMole {
    int score;
    int molesLeft;
    int attemptsLeft;

    char[][] moleGrid;

    WhackAMole(int numAttempts, int girdDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[girdDimension][girdDimension];
        //this.molesLeft = 10;
    }

    boolean place(int x, int y) {
        moleGrid[x][y] = 'M';
        molesLeft--;
        return true;
    }

    void whack(int x, int y) {
        char mole = moleGrid[x][y];
        if(mole == 'M') {
            moleGrid[x][y] = 'W';
            score++;
            attemptsLeft--;
            molesLeft--;
        }
    }

    void printGridToUser() {
        for(int i=0; i<moleGrid.length; i++) {
            for(int j=0; j<moleGrid.length; j++) {
                if(moleGrid[i][j] == 'W') {
                    System.out.print("W ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    void printGrid() {
        for(int i=0; i<moleGrid.length; i++) {
            for(int j=0; j<moleGrid.length; j++) {
                if(moleGrid[i][j] == 'M') {
                    System.out.print("M ");
                } else if(moleGrid[i][j] == 'W') {
                    System.out.print("W ");
                } else {
                    System.out.println("* ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WhackAMole wam = new WhackAMole(50, 10);
        wam.molesLeft = 10;
        System.out.println("molesLet = " + wam.molesLeft);
        wam.place(5, 5);
        wam.place(2, 3);
        wam.place(4, 2);
        wam.place(1, 9);
        wam.place(0, 8);
        wam.place(3, 6);
        wam.place(6, 5);
        wam.place(8, 1);
        wam.place(6, 3);
        wam.place(9, 6);

        Scanner sc = new Scanner(System.in);
        System.out.println("You max 50 attempts to whack a mole!");
        while(wam.attemptsLeft > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == -1 && y == -1) {
                wam.printGrid();
                break;
            }
            System.out.println("Moles left = " + wam.molesLeft);
            if(wam.molesLeft == 0) {
                break;
            }
            wam.whack(x, y);
            wam.printGridToUser();
        }
    }

}

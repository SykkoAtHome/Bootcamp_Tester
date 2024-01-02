package com.kodilla.jacoco;

public class Year {
    int yearToCheck;

    public Year(int year) {
        this.yearToCheck = year;
    }

    public boolean isLeap() {
        if (this.yearToCheck % 4 == 0) {
            if (this.yearToCheck % 100 == 0) {
                return this.yearToCheck % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
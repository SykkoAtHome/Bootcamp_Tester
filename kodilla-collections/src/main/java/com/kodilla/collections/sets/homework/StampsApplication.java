package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stampSet = new HashSet<>();
        stampSet.add(new Stamp("WOSP", 22, 45, false));
        stampSet.add(new Stamp("80-lecie PZPR", 20, 55, true));
        stampSet.add(new Stamp("Polska Walczaca", 20, 35, true));
        stampSet.add(new Stamp("WOSP", 22, 45, false));
        stampSet.add(new Stamp("Unia Europejska", 24, 52, true));

        for (Stamp stamp : stampSet) {
            System.out.println(stamp);
        }
    }
}

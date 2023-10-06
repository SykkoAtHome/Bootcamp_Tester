package com.kodilla.collections.adv.exercises.homework;

import java.util.*;

public class FlightFinder {
    public static List<Flight> findFlightsFrom(String departure) {
        List<Flight> flights = FlightRepository.getFlightsTable();
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().equals(departure)) {
                result.add(flight);
            }
        }
        return result;
    }
    public static List<Flight> findFlightsTo(String arrival) {
        List<Flight> flights = FlightRepository.getFlightsTable();
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getArrival().equals(arrival)) {
                result.add(flight);
            }
        }
        return result;
    }
}

package com.kodilla.collections.adv.exercises.homework;

import java.util.*;

public class FlightRepository {
    public static List<Flight> getFlightsTable() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Pcim", "New York"));
        flights.add(new Flight("Kudowa-Zdroj", "San Francisco"));
        flights.add(new Flight("Tokyo", "Zakopane"));
        flights.add(new Flight("Tokyo", "Newark"));
        flights.add(new Flight("Bielsko-Biala", "New York"));
        flights.add(new Flight("Honolulu", "Austin"));
        flights.add(new Flight("Piaceczno", "Radom"));
        flights.add(new Flight("CPK", "Berlin"));
        return flights;
    }
}

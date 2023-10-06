package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class FlightFinderTestSuite {
    @Test
    public void testFindFlightsFrom() {
        // given
        List<Flight> flights = FlightRepository.getFlightsTable();
        String departure = "Tokyo";

        // when
        List<Flight> result = FlightFinder.findFlightsFrom(departure);

        // then
        assertEquals(2, result.size());
    }
    @Test
    public void testFindFlightsTo() {
        // given
        List<Flight> flights = FlightRepository.getFlightsTable();
        String arrival = "New York";

        // when
        List<Flight> result = FlightFinder.findFlightsTo(arrival);

        // then
        assertEquals(2, result.size());
    }
}
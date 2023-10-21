package com.kodilla.mockito.homework;

import org.junit.jupiter.api.*;

import org.mockito.Mockito;
class AlertServiceTest {
    AlertService alertService = new AlertService();
    User obajtek = Mockito.mock(User.class);
    User suski = Mockito.mock(User.class);

    Location pcim = Mockito.mock(Location.class);
    Location gdansk = Mockito.mock(Location.class);


    @BeforeEach
    public void setUp() {
        alertService.clearAllData();
    }

    @AfterEach
    public void cleanUp() {
        alertService.clearAllData();
    }


    @Test
    public void subscribeToLocationShouldReceiveAlert() {
        alertService.subscribeToLocation(obajtek, pcim);
        alertService.subscribeToLocation(suski, gdansk);

        alertService.sendAlert(pcim, "Obajtek przejmuje Orlen");

        Mockito.verify(obajtek).receive(Mockito.any(Alert.class));
        Mockito.verify(suski, Mockito.never()).receive(Mockito.any(Alert.class));
    }

    @Test
    public void unsubscribeFromLocationShouldNotReceiveAnyAlerts() {
        alertService.subscribeToLocation(obajtek, pcim);
        alertService.subscribeToLocation(suski, pcim);

        alertService.sendAlert(pcim, "Lotos sprzedany za bezcen !");

        Mockito.verify(obajtek, Mockito.times(1)).receive(Mockito.any(Alert.class));
        Mockito.verify(suski, Mockito.times(1)).receive(Mockito.any(Alert.class));

        alertService.unsubscribeFromLocation(obajtek, pcim);

        alertService.sendAlert(pcim, "Lotos sprzedany za bezcen !");

        Mockito.verifyNoMoreInteractions(obajtek);
        Mockito.verify(suski, Mockito.times(2)).receive(Mockito.any(Alert.class));
    }
    @Test
    public void unsubscribeFromAllLocationsShouldNotReceiveAnyAlerts() {
        alertService.subscribeToLocation(obajtek, pcim);
        alertService.subscribeToLocation(obajtek, gdansk);

        alertService.unsubscribeFromAllLocations(obajtek);

        alertService.sendAlert(pcim, "Alert z Pcimia");
        alertService.sendAlert(gdansk, "Alert z Gdanska");

        Mockito.verify(obajtek, Mockito.never()).receive(Mockito.any(Alert.class));
    }
    @Test
    public void alertForLocationShouldReachSubscribedOnly() {
        alertService.subscribeToLocation(obajtek, pcim);
        alertService.subscribeToLocation(obajtek, gdansk);
        alertService.subscribeToLocation(suski, pcim);

        alertService.sendAlert(pcim, "For Pcim's eyes only");

        Mockito.verify(obajtek, Mockito.times(1)).receive(Mockito.any(Alert.class));
        Mockito.verify(suski, Mockito.times(1)).receive(Mockito.any(Alert.class));
    }
    @Test
    public void testSendAlertToAllUniqueSubscribers() {
        alertService.subscribeToLocation(obajtek, pcim);
        alertService.subscribeToLocation(obajtek, gdansk);
        alertService.subscribeToLocation(suski, pcim);

        alertService.sendAlertToAll("PiS wygrywa wybory z malym 'ale'");

        Mockito.verify(obajtek, Mockito.times(1)).receive(Mockito.any(Alert.class));
        Mockito.verify(suski, Mockito.times(1)).receive(Mockito.any(Alert.class));
    }
    @Test
    public void testDeleteLocation() {
        alertService.subscribeToLocation(obajtek, pcim);
        alertService.subscribeToLocation(obajtek, gdansk);
        alertService.subscribeToLocation(suski, pcim);

        alertService.deleteLocation(pcim);

        alertService.sendAlertToAll("Ostatni gasi swiatlo");

        Mockito.verify(obajtek, Mockito.times(1)).receive(Mockito.any(Alert.class));
        Mockito.verify(suski, Mockito.times(1)).receive(Mockito.any(Alert.class));
    }
    @Test
    public void testAddUser() {
        alertService.subscribeToLocation(obajtek, gdansk);
        alertService.subscribeToLocation(suski, pcim);

        alertService.deleteLocation(gdansk);
        alertService.deleteLocation(pcim);

        alertService.sendAlertToAll("Alert");

        Mockito.verify(obajtek, Mockito.times(1)).receive(Mockito.any(Alert.class));
        Mockito.verify(suski, Mockito.times(1)).receive(Mockito.any(Alert.class));
    }
}
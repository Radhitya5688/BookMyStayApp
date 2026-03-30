package com.bookmystay;

import java.util.*;

public class AddOnServiceManager {

    private Map<String, List<Service>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {
        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        double total = 0;

        List<Service> services = servicesByReservation.getOrDefault(reservationId, new ArrayList<>());

        for (Service s : services) {
            total += s.getCost();
        }

        return total;
    }
}

package com.bookmystay;

import java.util.*;

public class ReservationValidator {

    public void validate(String guestName, String roomType, RoomInventory inventory)
            throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty");
        }

        // Validate room type (case sensitive as per question)
        List<String> validTypes = Arrays.asList("Single", "Double", "Suite");

        if (!validTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type selected");
        }

        // Validate availability
        if (!inventory.isAvailable(roomType)) {
            throw new InvalidBookingException("No rooms available for selected type");
        }
    }
}
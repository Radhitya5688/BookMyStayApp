package com.bookmystay;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        // Simulate booking
        String reservationId = "Single-1";
        String roomType = "Single";

        service.registerBooking(reservationId, roomType);

        // Cancel booking
        service.cancelBooking(reservationId, inventory);

        // Show rollback history
        service.showRollbackHistory();

        // Display updated inventory
        System.out.println("\nUpdated Single Room Availability: " + inventory.isAvailable("Single"));
    }
}

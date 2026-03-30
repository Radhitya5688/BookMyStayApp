package com.bookmyStay;

import com.bookmystay.BookingRequestQueue;
import com.bookmystay.Reservation;
import com.bookmystay.RoomAllocationService;
import com.bookmystay.RoomInventory;

public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private final RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            // 🔐 Only one thread accesses queue at a time
            synchronized (bookingQueue) {

                if (!bookingQueue.hasPendingRequests()) {
                    break;
                }

                reservation = bookingQueue.getNextRequest();
            }

            // 🔐 Only one thread updates inventory at a time
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}
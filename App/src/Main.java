import java.util.LinkedList;
import java.util.Queue;

// RESERVATION CLASS
class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Guest: " + guestName + ", Room Type: " + roomType);
    }
}

// BOOKING QUEUE CLASS
class BookingQueue {
    Queue<Reservation> queue;

    BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request
    void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Booking added for " + reservation.guestName);
    }

    // Process booking (FIFO)
    void processBooking() {
        if (queue.isEmpty()) {
            System.out.println("No bookings to process");
        } else {
            Reservation r = queue.poll();
            System.out.println("Processing booking:");
            r.display();
        }
    }

    // Display all bookings
    void displayQueue() {
        System.out.println("\n----- Booking Requests Queue -----");
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (Reservation r : queue) {
                r.display();
            }
        }
    }
}

// MAIN CLASS (IMPORTANT)
public class Main {
    public static void main(String[] args) {

        BookingQueue bookingQueue = new BookingQueue();

        // Adding requests
        bookingQueue.addRequest(new Reservation("Sai", "Single Room"));
        bookingQueue.addRequest(new Reservation("Arun", "Double Room"));
        bookingQueue.addRequest(new Reservation("Priya", "Suite Room"));

        // Display queue
        bookingQueue.displayQueue();

        // Process one booking
        System.out.println("\n--- Processing Booking ---");
        bookingQueue.processBooking();

        // Display after processing
        bookingQueue.displayQueue();
    }
}
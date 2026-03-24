import java.util.HashMap;
import java.util.Map;

// ABSTRACT CLASS
abstract class Room {
    String type;
    int beds;
    double price;

    Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    void display() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Price: " + price);
    }
}

// CHILD CLASSES
class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1, 1000);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2, 2000);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 3, 5000);
    }
}

// INVENTORY CLASS
class RoomInventory {
    HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    // Returns full map (lab preferred)
    Map<String, Integer> getRoomAvailability() {
        return inventory;
    }
}

// SEARCH SERVICE
class SearchService {

    void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("----- Available Rooms -----");

        // Single Room
        if (availability.get("Single Room") > 0) {
            singleRoom.display();
            System.out.println("Available: " + availability.get("Single Room"));
            System.out.println();
        }

        // Double Room
        if (availability.get("Double Room") > 0) {
            doubleRoom.display();
            System.out.println("Available: " + availability.get("Double Room"));
            System.out.println();
        }

        // Suite Room
        if (availability.get("Suite Room") > 0) {
            suiteRoom.display();
            System.out.println("Available: " + availability.get("Suite Room"));
            System.out.println();
        }
    }
}

// MAIN CLASS
public class Main {
    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        SearchService searchService = new SearchService();

        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}
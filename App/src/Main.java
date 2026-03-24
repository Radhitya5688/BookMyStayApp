public class Main {
    public static void main(String[] args) {

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("----- Room Details -----");

        r1.display();
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        r2.display();
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        r3.display();
        System.out.println("Available: " + suiteAvailable);
    }
}
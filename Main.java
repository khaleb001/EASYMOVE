java
Copy code
// TransportationRequest.java
public class TransportationRequest {
    private String studentName;
    private String pickUpLocation;
    private String dropOffLocation;

    public TransportationRequest(String studentName, String pickUpLocation, String dropOffLocation) {
        this.studentName = studentName;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    @Override
    public String toString() {
        return "Student: " + studentName + ", Pick-up: " + pickUpLocation + ", Drop-off: " + dropOffLocation;
    }
}

// Driver.java
public class Driver {
    private String name;
    private boolean isAvailable;

    public Driver(String name) {
        this.name = name;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Driver: " + name + ", Available: " + isAvailable;
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolTransportationSystem {
    private List<TransportationRequest> requests = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SchoolTransportationSystem system = new SchoolTransportationSystem();
        system.run();
    }

    public void run() {
        initializeDrivers();
        boolean running = true;
        while (running) {
            System.out.println("1. Add Request");
            System.out.println("2. Assign Driver");
            System.out.println("3. List Requests");
            System.out.println("4. List Drivers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addRequest();
                    break;
                case 2:
                    assignDriver();
                    break;
                case 3:
                    listRequests();
                    break;
                case 4:
                    listDrivers();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void initializeDrivers() {
        drivers.add(new Driver("John Doe"));
        drivers.add(new Driver("Jane Smith"));
    }

    private void addRequest() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter pick-up location: ");
        String pickUpLocation = scanner.nextLine();
        System.out.print("Enter drop-off location: ");
        String dropOffLocation = scanner.nextLine();
        requests.add(new TransportationRequest(studentName, pickUpLocation, dropOffLocation));
        System.out.println("Request added.");
    }

    private void assignDriver() {
        listRequests();
        System.out.print("Enter the index of the request to assign a driver to: ");
        int requestIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (requestIndex < 0 || requestIndex >= requests.size()) {
            System.out.println("Invalid request index.");
            return;
        }

        listDrivers();
        System.out.print("Enter the index of the driver to assign: ");
        int driverIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (driverIndex < 0 || driverIndex >= drivers.size()) {
            System.out.println("Invalid driver index.");
            return;
        }

        Driver driver = drivers.get(driverIndex);
        if (!driver.isAvailable()) {
            System.out.println("Driver is not available.");
            return;
        }

        driver.setAvailable(false);
        System.out.println("Driver " + driver.getName() + " assigned to request " + requests.get(requestIndex));
    }

    private void listRequests() {
        if (requests.isEmpty()) {
            System.out.println("No requests available.");
        } else {
            for (int i = 0; i < requests.size(); i++) {
                System.out.println(i + ": " + requests.get(i));
            }
        }
    }

    private void listDrivers() {
        if (drivers.isEmpty()) {
            System.out.println("No drivers available.");
        } else {
            for (int i = 0; i < drivers.size(); i++) {
                System.out.println(i + ": " + drivers.get(i));
            }
        }
    }
}

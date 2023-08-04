package tttask2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private List<Booking> bookings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    // Getters and setters

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}

class ParkingSpot {
    private int spotNumber;
    private boolean isAvailable;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isAvailable = true;
    }

    // Getters and setters

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Booking {
    private User user;
    private ParkingSpot parkingSpot;

    public Booking(User user, ParkingSpot parkingSpot) {
        this.user = user;
        this.parkingSpot = parkingSpot;
    }

    // Getters

    public User getUser() {
        return user;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}

public class OnlineParkingSystem {
    private Map<Integer, ParkingSpot> parkingSpots;
    private List<User> users;
    private Scanner scanner;

    public OnlineParkingSystem() {
        this.parkingSpots = new HashMap<>();
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void registerUser(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
    }

    public void addParkingSpot(int spotNumber) {
        ParkingSpot newSpot = new ParkingSpot(spotNumber);
        parkingSpots.put(spotNumber, newSpot);
    }

    public void searchParkingSpot() {
        System.out.println("Available parking spots:");
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.isAvailable()) {
                System.out.println("Spot number: " + spot.getSpotNumber());
            }
        }
    }

    public void bookParkingSpot(User user, int spotNumber) {
        ParkingSpot spot = parkingSpots.get(spotNumber);
        if (spot != null && spot.isAvailable()) {
            Booking booking = new Booking(user, spot);
            user.addBooking(booking);
            spot.setAvailable(false);
            System.out.println("Booking confirmed for spot number " + spotNumber);
        } else {
            System.out.println("Spot number " + spotNumber + " is not available for booking.");
        }
    }

    public static void main(String[] args) {
        OnlineParkingSystem parkingSystem = new OnlineParkingSystem();

        // Example usage
        parkingSystem.registerUser("john_doe", "password123");
        parkingSystem.addParkingSpot(101);
        parkingSystem.addParkingSpot(102);
        parkingSystem.addParkingSpot(103);

        parkingSystem.searchParkingSpot();

        User user = parkingSystem.users.get(0);
        parkingSystem.bookParkingSpot(user, 101);
        parkingSystem.searchParkingSpot();
    }
}


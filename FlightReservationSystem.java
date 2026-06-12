class Passenger {
    private String name;
    private int id;
    public Passenger(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
class Flight {
    final int MAX_SEATS;          
    private Passenger[] seats;     

    public Flight(int maxSeats) {
        this.MAX_SEATS = maxSeats;
        seats = new Passenger[MAX_SEATS];
    }

    public void bookSeat(Passenger p) {
  
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null && seats[i].getId() == p.getId()) {
                System.out.println("Passenger " + p.getName() + " already has a seat.");
                return;
            }
        }

        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p;
                System.out.println("Seat booked for " + p.getName() + 
                                   " (ID: " + p.getId() + ") at Seat No: " + (i + 1));
                return;
            }
        }

        System.out.println("No seats available for " + p.getName());
    }

    public void displaySeats() {
        System.out.println("\n--- Seat Status ---");
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null) {
                System.out.println("Seat " + (i + 1) + ": " + seats[i].getName());
            } else {
                System.out.println("Seat " + (i + 1) + ": Empty");
            }
        }
    }

    public void cancelSeat(int passengerId) {
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null && seats[i].getId() == passengerId) {
                System.out.println("Booking cancelled for " + seats[i].getName());
                seats[i] = null;
                return;
            }
        }
        System.out.println("Passenger ID not found.");
    }
}

public class FlightReservationSystem {
    public static void main(String[] args) {

        Flight flight = new Flight(5);
        Passenger p1 = new Passenger("Ravi", 101);
        Passenger p2 = new Passenger("Aman", 102);
        Passenger p3 = new Passenger("Neha", 103);
        Passenger p4 = new Passenger("Simran", 104);
        Passenger p5 = new Passenger("Raj", 105);
        Passenger p6 = new Passenger("Extra", 106);

        flight.bookSeat(p1);
        flight.bookSeat(p2);
        flight.bookSeat(p3);
        flight.bookSeat(p4);
        flight.bookSeat(p5);
        flight.bookSeat(p6);
        flight.displaySeats();
        flight.cancelSeat(103);
        flight.displaySeats();
    }
}

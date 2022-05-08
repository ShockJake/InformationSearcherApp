import java.time.LocalDate;

public class FlightInformation {
    private long flightNumber = 0;
    private LocalDate date = null;
    private double cargoWeight = 0;
    private double baggageWeight = 0;
    private double totalWeight = 0;

    // Default constructor to build an empty Flight Information class
    public FlightInformation() {}

    // Constructor with arguments
    public FlightInformation(long flightNumber, LocalDate date, double cargoWeight, double baggageWeight, double totalWeight) {
        this.flightNumber = flightNumber;
        this.date = date;
        this.cargoWeight = cargoWeight;
        this.baggageWeight = baggageWeight;
        this.totalWeight = totalWeight;
    }

    @Override
    public String toString() {
        return "FlightInformation{" +
                "flightNumber=" + flightNumber +
                ", date=" + date +
                ", cargoWeight=" + cargoWeight +
                ", baggageWeight=" + baggageWeight +
                ", totalWeight=" + totalWeight +
                '}';
    }

    public String getInformation() {
        if (date == null) {
            return "Flight information with this id or date cannot be found";
        }
        return String.format("""
                        Flight with number: %s and flight date: %s has next information:
                        \tCargo weight: %s
                        \tBaggage weight: %s
                        \tTotal weight: %s""",
                flightNumber, date, cargoWeight, baggageWeight, totalWeight);
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public double getBaggageWeight() {
        return baggageWeight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FlightInformation flightInformation)) {
            return false;
        }
        if (flightInformation.date == null) {
            return false;
        }
        return this.flightNumber == flightInformation.flightNumber &&
                this.date.equals(flightInformation.date) &&
                this.cargoWeight == flightInformation.cargoWeight &&
                this.baggageWeight == flightInformation.baggageWeight &&
                this.totalWeight == flightInformation.totalWeight;
    }
}
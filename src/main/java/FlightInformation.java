import java.time.LocalDate;

public class FlightInformation {
    private long flightId = 0;
    private LocalDate date = null;
    private double cargoWeight = 0;
    private double baggageWeight = 0;
    private double totalWeight = 0;

    FlightInformation(){}
    FlightInformation(long flightId, LocalDate date, double cargoWeight, double baggageWeight, double totalWeight) {
        this.flightId = flightId;
        this.date = date;
        this.cargoWeight = cargoWeight;
        this.baggageWeight = baggageWeight;
        this.totalWeight = totalWeight;
    }

    @Override
    public String toString() {
        if (date == null) {
            return "Flight with this id and date cannot be found";
        }
        return String.format("""
                        Flight with id: %s and flight date: %s has next information:
                        \tCargo weight: %s
                        \tBaggage weight: %s
                        \tTotal weight: %s""",
                flightId, date, cargoWeight, baggageWeight, totalWeight);
    }

    public long getFlightId() {
        return flightId;
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
        if (!(obj instanceof FlightInformation)) {
            return false;
        }
        FlightInformation flightInformation = (FlightInformation) obj;
        if (flightInformation.date == null) {
            return false;
        }
        return this.flightId == flightInformation.flightId &&
                this.date.equals(flightInformation.date) &&
                this.cargoWeight == flightInformation.cargoWeight &&
                this.baggageWeight == flightInformation.baggageWeight &&
                this.totalWeight == flightInformation.totalWeight;
    }
}
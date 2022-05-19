package information;

import java.time.LocalDate;

public record FlightInformation(long flightNumber, LocalDate date, double cargoWeight, double baggageWeight,
                                double totalWeight) {

    @Override
    public String toString() {
        return "information.FlightInformation{" +
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

    @Override
    public int hashCode() {
        return (int) (flightNumber % (cargoWeight + baggageWeight + totalWeight));
    }
}
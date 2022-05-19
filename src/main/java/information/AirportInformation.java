package information;

import java.time.LocalDate;

public class AirportInformation {
    // Input data
    private final String IATACode;
    private final LocalDate date;
    // Requested data
    private final int departureFlights;
    private final int arrivalFlights;
    private final long arrivalBaggagePieces;
    private final long departureBaggagePieces;

    public AirportInformation(String IATACode, LocalDate date, int departureNumber,
                       int arrivalsNumber, long arrivalBaggagePieces, long departureBaggagePieces) {
        this.IATACode = IATACode;
        this.date = date;
        this.departureFlights = departureNumber;
        this.arrivalFlights = arrivalsNumber;
        this.arrivalBaggagePieces = arrivalBaggagePieces;
        this.departureBaggagePieces = departureBaggagePieces;
    }

    @Override
    public String toString() {
        return "information.AirportInformation{" +
                "IATACode='" + IATACode + '\'' +
                ", date=" + date +
                ", departureFlights=" + departureFlights +
                ", arrivalFlights=" + arrivalFlights +
                ", arrivalBaggagePieces=" + arrivalBaggagePieces +
                ", departureBaggagePieces=" + departureBaggagePieces +
                '}';
    }

    public String getInformation() {
        if (date == null || IATACode == null) {
            return "Airport information with this IATACode or this date cannot be found";
        }
        return String.format("""
                Airport with this IATACode: %s and with this date: %s has next information:
                \tDeparture flights: %s
                \tArrival flights: %s
                \tArrival Baggage(Pieces): %s
                \tDeparture Baggage(Pieces): %s
                """, IATACode, date, departureFlights, arrivalFlights, arrivalBaggagePieces, departureBaggagePieces);
    }

    public String getIATACode() {
        return IATACode;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDepartureFlights() {
        return departureFlights;
    }

    public int getArrivalFlights() {
        return arrivalFlights;
    }

    public long getArrivalBaggagePieces() {
        return arrivalBaggagePieces;
    }

    public long getDepartureBaggagePieces() {
        return departureBaggagePieces;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AirportInformation airportInformation)) {
            return false;
        }
        if (airportInformation.IATACode == null || airportInformation.date == null) {
            return false;
        }
        return this.IATACode.equals(airportInformation.IATACode) &&
                this.date.equals(airportInformation.date) &&
                this.departureFlights == airportInformation.departureFlights &&
                this.arrivalFlights == airportInformation.arrivalFlights &&
                this.departureBaggagePieces == airportInformation.departureBaggagePieces &&
                this.arrivalBaggagePieces == airportInformation.arrivalBaggagePieces;
    }

    @Override
    public int hashCode() {
        return (int) (IATACode.length() %
                (departureFlights + arrivalFlights + arrivalBaggagePieces + departureBaggagePieces));
    }
}

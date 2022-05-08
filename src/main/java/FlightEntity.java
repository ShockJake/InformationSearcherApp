import java.time.LocalDate;

// Class that represents Flight Entity
public class FlightEntity {
    // Flight data
    private long id;
    private long flightNumber;
    private String departureIATACode;
    private String arrivalIATACode;
    private LocalDate departureDate;

    // Constructor with arguments
    FlightEntity(long id, long flightNumber, String departureIATACode, String arrivalIATACode, LocalDate departureDate) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.departureIATACode = departureIATACode;
        this.arrivalIATACode = arrivalIATACode;
    }

    public long getId() {
        return id;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureIATACode() {
        return departureIATACode;
    }

    public String getArrivalIATACode() {
        return arrivalIATACode;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }
}

import java.time.LocalDate;

public interface InformationSearcher {
    FlightInformation getFlightInformationById(int flightNumber, LocalDate flightDate);
    String getAirportInformation(String IATACode, LocalDate date);
}

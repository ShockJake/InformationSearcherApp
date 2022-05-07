import java.time.LocalDate;

public interface InformationSearcher {
    String getFlightInformationById(int flightNumber, LocalDate flightDate);
    String getAirportInformation(String IATACode, LocalDate date);
}

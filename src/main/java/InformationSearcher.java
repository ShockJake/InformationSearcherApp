import java.util.Date;

public interface InformationSearcher {
    String getFlightInformationById(int flightNumber, Date flightDate);
    String getAirportInformation(String IATACode, Date date);
}

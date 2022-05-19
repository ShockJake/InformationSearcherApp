import information.AirportInformation;
import information.FlightInformation;

import java.time.LocalDate;

// Interface for users
public interface InformationSearcher {

    // Method to get data for requested flight number and flight date
    FlightInformation getFlightInformationById(int flightNumber, LocalDate flightDate);

    // Method to get data for requested Airport IATACode and date
    AirportInformation getAirportInformation(String IATACode, LocalDate date);
}

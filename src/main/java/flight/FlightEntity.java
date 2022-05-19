package flight;

import java.time.LocalDate;

/**
 * @param id Flight data
 */ // Class that represents Flight Entity
public record FlightEntity(long id, long flightNumber, String departureIATACode, String arrivalIATACode,
                           LocalDate departureDate) {
}

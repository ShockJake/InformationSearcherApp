import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class AirportInformationSearcher implements InformationSearcher {
    private ArrayList<FlightEntity> flightEntities;
    private ArrayList<CargoEntity> cargoEntities;

    @Override
    public String getFlightInformationById(int flightNumber, LocalDate flightDate) {
        // Searching flight by number
        for (FlightEntity flight : flightEntities) {
            if (flight.getFlightNumber() == flightNumber && flight.getDepartureDate().equals(flightDate)) {
                double cargoWeight = 0;
                double baggageWeight = 0;
                double totalWeight;
                CargoEntity cargoEntity = cargoEntities.get(flightEntities.indexOf(flight));
                // Summing baggage weight
                for (Cargo baggage : cargoEntity.getBaggage()) {
                     baggageWeight += baggage.getWeight();
                }
                // Summing cargo weight
                for (Cargo cargo : cargoEntity.getCargos()) {
                    cargoWeight += cargo.getWeight();
                }
                // Summing total weight
                totalWeight = cargoWeight + baggageWeight;
                return String.format("""
                        Flight with id: %s and flight date: %s has next information
                        Cargo weight: %s
                        Baggage weight: %s
                        Total weight: %s""",
                        flightNumber, flightDate, cargoWeight, baggageWeight, totalWeight);
            }
        }
        return String.format("Flight with id: %s and flight date: %s - cannot be found", flightNumber, flightDate);
    }

    @Override
    public String getAirportInformation(String IATACode, LocalDate date) {
        return null;
    }

    public AirportInformationSearcher(String flightFilePath, String cargoFilePath) {
        flightEntities = new ArrayList<>();
        cargoEntities = new ArrayList<>();
        try {
            FlightParser.parseFlights(flightFilePath, flightEntities);
            CargoParser.parseCargoEntities(cargoFilePath, cargoEntities);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        flightEntities.forEach(flightEntity -> {
            System.out.println(flightEntity.getFlightNumber());
        });
    }
}

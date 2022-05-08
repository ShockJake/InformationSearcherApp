import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class InformationSearcherApplication implements InformationSearcher {
    // Array List for all parsed flights
    private ArrayList<FlightEntity> flightEntities = null;
    // Array List for all parsed cargo
    private ArrayList<CargoEntity> cargoEntities = null;

    @Override
    public FlightInformation getFlightInformationById(int flightNumber, LocalDate flightDate) {
        // Searching flight by number
        for (FlightEntity flight : flightEntities) {
            if (flight.getFlightNumber() == flightNumber && flight.getDepartureDate().equals(flightDate)) {
                // Setting requested data
                double cargoWeight = 0;
                double baggageWeight = 0;
                double totalWeight;
                // Getting corresponding cargoEntity
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
                return new FlightInformation(flightNumber, flightDate, cargoWeight, baggageWeight, totalWeight);
            }
        }
        // Returning empty FightInformation class if no flight were found
        return new FlightInformation();
    }

    @Override
    public AirportInformation getAirportInformation(String IATACode, LocalDate date) {
        // Requested data
        int departuresNumber = 0;
        int arrivalsNumber = 0;
        long departureBaggagePieces = 0;
        long arrivalBaggagePieces = 0;
        // Finding departure and arrival flights and calculating baggage pieces
        for (FlightEntity flight : flightEntities) {
            if (flight.getDepartureIATACode().equals(IATACode)) {
                departuresNumber++; // Incrementing number of departure flights if such flight was found
                CargoEntity cargoEntity = cargoEntities.get(flightEntities.indexOf(flight));
                departureBaggagePieces += cargoEntity.getAllBaggagePieces(); // getting departure baggage pieces
            }
            if (flight.getArrivalIATACode().equals(IATACode)) {
                arrivalsNumber++; // Incrementing number of arrivals flights if such flight was found
                CargoEntity cargoEntity = cargoEntities.get(flightEntities.indexOf(flight));
                arrivalBaggagePieces += cargoEntity.getAllBaggagePieces(); // getting departure baggage pieces
            }
        }
        if (departuresNumber != 0 || arrivalsNumber != 0) {
            return new AirportInformation(IATACode, date, departuresNumber,
                    arrivalsNumber, arrivalBaggagePieces, departureBaggagePieces);
        }
        // Returning empty airport information class if no flights were found
        return new AirportInformation();
    }

    // Constructor with arguments that parses flights and corresponding cargo entities to them
    public InformationSearcherApplication(String flightFilePath, String cargoFilePath) {
        flightEntities = new ArrayList<>();
        cargoEntities = new ArrayList<>();
        try {
            // Parsing flight Entities
            FlightParser.parseFlightEntities(flightFilePath, flightEntities);
            // Parsing cargo Entities
            CargoParser.parseCargoEntities(cargoFilePath, cargoEntities);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

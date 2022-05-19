import cargo.CargoEntity;
import cargo.CargoParser;
import flight.FlightEntity;
import information.AirportInformation;
import information.FlightInformation;
import flight.FlightParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class InformationSearcherApplication implements InformationSearcher {
    // Array List for all parsed flights
    private final ArrayList<FlightEntity> flightEntities;
    // Array List for all parsed cargo
    private final ArrayList<CargoEntity> cargoEntities;

    @Override
    public FlightInformation getFlightInformationById(int flightNumber, LocalDate flightDate) {
        // Searching flight by number
        for (FlightEntity flight : flightEntities) {
            if (flight.flightNumber() == flightNumber && flight.departureDate().equals(flightDate)) {
                // Setting requested data
                double cargoWeight;
                double baggageWeight;
                double totalWeight;
                // Getting corresponding cargoEntity
                CargoEntity cargoEntity = cargoEntities.get(flightEntities.indexOf(flight));
                baggageWeight = cargoEntity.getBaggageWeightSum();
                cargoWeight = cargoEntity.getCargoWeightSum();
                totalWeight = cargoWeight + baggageWeight;
                return new FlightInformation(flightNumber, flightDate, cargoWeight, baggageWeight, totalWeight);
            }
        }
        // if information about requested flight wasn't found performing "fail-fast"
        throw new RuntimeException(String.format("""
                Can't find information about flight with provided data: %s %s""", flightNumber, flightDate));
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
            if (flight.departureIATACode().equals(IATACode)) {
                departuresNumber++; // Incrementing number of departure flights if such flight was found
                CargoEntity cargoEntity = cargoEntities.get(flightEntities.indexOf(flight));
                departureBaggagePieces += cargoEntity.getAllBaggagePieces(); // getting departure baggage pieces
            }
            if (flight.arrivalIATACode().equals(IATACode)) {
                arrivalsNumber++; // Incrementing number of arrivals flights if such flight was found
                CargoEntity cargoEntity = cargoEntities.get(flightEntities.indexOf(flight));
                arrivalBaggagePieces += cargoEntity.getAllBaggagePieces(); // getting departure baggage pieces
            }
        }
        if (departuresNumber != 0 || arrivalsNumber != 0) {
            return new AirportInformation(IATACode, date, departuresNumber,
                    arrivalsNumber, arrivalBaggagePieces, departureBaggagePieces);
        }
        // If information about requested airport wasn't found performing "fail-fast"
        throw new RuntimeException(String.format("""
                Can't find information about airport with provided data: %s %s
                """, IATACode, date));
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
            System.exit(1);
        }
    }
}

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class AirportInformationSearcher implements InformationSearcher {
    private ArrayList<FlightEntity> flightEntities;
    private ArrayList<CargoEntity> cargoEntities;

    @Override
    public FlightInformation getFlightInformationById(int flightNumber, LocalDate flightDate) {
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
                return new FlightInformation(flightNumber, flightDate, cargoWeight, baggageWeight, totalWeight);
            }
        }
        return new FlightInformation();
    }

    @Override
    public String getAirportInformation(String IATACode, LocalDate date) {
        int departuresNumber = 0;
        int arrivalsNumber = 0;
        long departureBaggagePieces = 0;
        long arrivalBaggagePieces = 0;

        for (FlightEntity flight : flightEntities) {
            if (flight.getDepartureIATACode().equals(IATACode)) {
                departuresNumber++;
                CargoEntity cargoEntity = cargoEntities.get(flightEntities.indexOf(flight));
                departureBaggagePieces += cargoEntity.getAllBaggagePieces();
            }
            if (flight.getArrivalIATACode().equals(IATACode)) {
                arrivalsNumber++;
                CargoEntity cargoEntity = cargoEntities.get(flightEntities.indexOf(flight));
                arrivalBaggagePieces += cargoEntity.getAllBaggagePieces();
            }
        }
        if (departuresNumber != 0 || arrivalsNumber != 0) {
            return String.format("""
                    Information about Airport with IATA code: %s and with date: %s
                    Departing flights: %s
                    Arriving flights: %s
                    Total number of (pieces) baggage arriving from this airport: %s
                    Total number of (pieces) baggage departing from this airport: %s
                    """,
                    IATACode, date, departuresNumber, arrivalsNumber, arrivalBaggagePieces, departureBaggagePieces);
        }

        return String.format("""
                        Information about Airport with IATA code: %s and with this date: %s - cannot be found""",
                IATACode, date);
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
    }
}

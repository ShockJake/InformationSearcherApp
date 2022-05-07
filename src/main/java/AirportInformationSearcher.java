import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class AirportInformationSearcher implements InformationSearcher {

    private ArrayList<FlightEntity> flightEntities;
    private ArrayList<CargoEntity> cargoEntities;

    @Override
    public String getFlightInformationById(int flightNumber, Date flightDate) {
        return null;
    }

    @Override
    public String getAirportInformation(String IATACode, Date date) {
        return null;
    }

    private FlightEntity parseFlight(JSONObject f) throws java.text.ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ssz", Locale.ENGLISH);
        LocalDate date = LocalDate.parse((String)f.get("departureDate"), formatter);
        FlightEntity flight = new FlightEntity(
                (long) f.get("flightId"),
                (long) f.get("flightNumber"),
                (String) f.get("departureAirportIATACode"),
                (String) f.get("arrivalAirportIATACode"),
                date
        );
        return flight;
    }

    private void parseFlightEntities(String flightFilePath) throws IOException, ParseException {
        JSONArray flights = (JSONArray) new JSONParser().parse(new FileReader(flightFilePath));
        flights.forEach(f -> {
            JSONObject flightObj = (JSONObject) f;
            try {
                FlightEntity flight = parseFlight(flightObj);
                flightEntities.add(flight);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        });
    }

    private Cargo parseCargo(JSONObject cargoObj) {
        return new Cargo(
                (long) cargoObj.get("id"),
                (long) cargoObj.get("weight"),
                (String) cargoObj.get("weightUnit"),
                (long) cargoObj.get("pieces")
        );
    }

    private List<Cargo> parseCargos(JSONArray jsonCargo) {
        ArrayList<Cargo> cargoArray = new ArrayList<>();
        jsonCargo.forEach(c -> {
            JSONObject cargoObj = (JSONObject) c;
            cargoArray.add(parseCargo(cargoObj));
        });

        return cargoArray;
    }

    private CargoEntity parseCargoEntity(JSONObject cargoObj) {
        return new CargoEntity(
                (long) cargoObj.get("flightId"),
                parseCargos((JSONArray) cargoObj.get("baggage")),
                parseCargos((JSONArray) cargoObj.get("cargo"))
        );
    }

    private void parseCargosEntities(String cargoFilePath) throws IOException, ParseException {
        JSONArray cargoEntityArray = (JSONArray) new JSONParser().parse(new FileReader(cargoFilePath));
        cargoEntityArray.forEach(c -> {
            JSONObject cargoEntityObj = (JSONObject) c;
            CargoEntity cargoEntity = parseCargoEntity(cargoEntityObj);
            cargoEntities.add(cargoEntity);
        });
    }

    public AirportInformationSearcher(String flightFilePath, String cargoFilePath) {
        flightEntities = new ArrayList<>();
        cargoEntities = new ArrayList<>();
        try {
            FlightParser.parseFlights(flightFilePath, flightEntities);
            // parseFlightEntities(flightFilePath);
            CargoParser.parseCargoEntities(cargoFilePath, cargoEntities);
            //parseCargosEntities(cargoFilePath);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        flightEntities.forEach(flightEntity -> {
            System.out.println(flightEntity.getFlightNumber());
        });
    }
}

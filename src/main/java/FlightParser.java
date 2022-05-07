import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class FlightParser {

    private static FlightEntity parseFlight(JSONObject f) throws java.text.ParseException {
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

    private static void parseFlightEntities(String flightFilePath, ArrayList<FlightEntity> flightEntities) throws IOException, ParseException {
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

    public static void parseFlights(String flightsFilePath, ArrayList<FlightEntity> flightEntities) throws IOException, ParseException {
        parseFlightEntities(flightsFilePath, flightEntities);
    }
}

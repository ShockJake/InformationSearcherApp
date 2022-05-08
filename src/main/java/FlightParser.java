import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class FlightParser {

    // Method to parse Flight Entity objects from JSON object
    private static FlightEntity parseFlightEntity(JSONObject f) throws java.text.ParseException {
        LocalDate date = DateUtil.parseDate((String)f.get("departureDate"));
        return new FlightEntity(
                (long) f.get("flightId"),
                (long) f.get("flightNumber"),
                (String) f.get("departureAirportIATACode"),
                (String) f.get("arrivalAirportIATACode"),
                date
        );
    }

    // Method to parse Array List of Flight Entity objects from JSON file
    public static void parseFlightEntities(String flightFilePath, ArrayList<FlightEntity> flightEntities)
            throws IOException, ParseException {
        JSONArray flights = (JSONArray) new JSONParser().parse(new FileReader(flightFilePath));
        flights.forEach(f -> {
            JSONObject flightObj = (JSONObject) f;
            try {
                FlightEntity flight = parseFlightEntity(flightObj);
                flightEntities.add(flight);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        });
    }
}

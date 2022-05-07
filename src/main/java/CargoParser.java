import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CargoParser {

    private static Cargo parseCargo(JSONObject cargoObj) {
        return new Cargo(
                (long) cargoObj.get("id"),
                (long) cargoObj.get("weight"),
                (String) cargoObj.get("weightUnit"),
                (long) cargoObj.get("pieces")
        );
    }

    private static List<Cargo> parseCargos(JSONArray jsonCargo) {
        ArrayList<Cargo> cargoArray = new ArrayList<>();
        jsonCargo.forEach(c -> {
            JSONObject cargoObj = (JSONObject) c;
            cargoArray.add(parseCargo(cargoObj));
        });

        return cargoArray;
    }

    private static CargoEntity parseCargoEntity(JSONObject cargoObj) {
        return new CargoEntity(
                (long) cargoObj.get("flightId"),
                parseCargos((JSONArray) cargoObj.get("baggage")),
                parseCargos((JSONArray) cargoObj.get("cargo"))
        );
    }

    public static void parseCargoEntities(String cargoEntitiesFilePath, ArrayList<CargoEntity> cargoEntities) throws IOException, ParseException {
        JSONArray cargoEntityArray = (JSONArray) new JSONParser().parse(new FileReader(cargoEntitiesFilePath));
        cargoEntityArray.forEach(c -> {
            JSONObject cargoEntityObj = (JSONObject) c;
            CargoEntity cargoEntity = parseCargoEntity(cargoEntityObj);
            cargoEntities.add(cargoEntity);
        });
    }
}

package cargo;
import java.util.List;

/**
 * @param baggage List for all baggage and cargo to the corresponding flights
 */
public record CargoEntity(long flightId, List<Cargo> baggage, List<Cargo> cargos) {

    // Calculating and getting all baggage pieces
    public long getAllBaggagePieces() {
        return baggage.stream().mapToLong(Cargo::getPieces).sum();
    }

    // Summing baggage weight
    public double getBaggageWeightSum() {
        double result = 0;
        for (Cargo baggageEl : baggage) {
            result += baggageEl.getWeight();
        }
        return result;
    }

    public double getCargoWeightSum() {
        double result = 0;
        for (Cargo cargo : cargos) {
            result += cargo.getWeight();
        }
        return result;
    }
}

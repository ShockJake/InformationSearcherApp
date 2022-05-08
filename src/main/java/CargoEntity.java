import java.util.List;

public class CargoEntity {
    private long flightId = 0;
    // List for all baggage and cargo to the corresponding flights
    private List<Cargo> baggage = null;
    private List<Cargo> cargos = null;

    // Constructor with arguments
    CargoEntity(long flightId, List<Cargo> baggage, List<Cargo> cargos) {
        this.flightId = flightId;
        this.baggage = baggage;
        this.cargos = cargos;
    }

    public long getFlightId() {
        return flightId;
    }

    public List<Cargo> getBaggage() {
        return baggage;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    // Calculating and getting all baggage pieces
    public long getAllBaggagePieces() {
        return baggage.stream().mapToLong(Cargo::getPieces).sum();
    }
}

import java.util.List;

public class CargoEntity {
    private long flightId;
    private List<Cargo> baggage;
    private List<Cargo> cargos;

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

    public long getAllBaggagePieces() {
        return baggage.stream().mapToLong(Cargo::getPieces).sum();
    }
}

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

//    @Override
//    public String toString() {
//        return "[flightId=" + flightId + ", baggage=" + List.toString(baggage) + ", cargos=" + Arrays.toString(cargos) + "]";
//    }
    public long getFlightId() {
        return flightId;
    }

//    public Baggage[] getBaggage() {
//        return baggage;
//    }
//
//    public Cargo[] getCargos() {
//        return cargos;
//    }
}

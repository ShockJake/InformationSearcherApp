public class Cargo {
    private long id;
    private long weight;
    private String weightUnit;
    private long pieces;

    Cargo(long id, long weight, String weightUnit, long pieces) {
        this.id = id;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", weight=" + weight + ", weightUnit=" + weightUnit + ", pieces=" + pieces + "]";
    }

    public long getId() {
        return id;
    }

    public double getWeight() {
        if (weightUnit.equals("lb")) {
            return WeightUtil.lbTokg(weight);
        }
        return weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public long getPieces() {
        return pieces;
    }
}

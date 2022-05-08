public class Cargo {
    private long id = 0;
    private long weight = 0;
    private String weightUnit = null;
    private long pieces = 0;

    // Constructor with arguments
    Cargo(long id, long weight, String weightUnit, long pieces) {
        this.id = id;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", weight=" + weight +
                ", weightUnit='" + weightUnit + '\'' +
                ", pieces=" + pieces +
                '}';
    }

    public long getId() {
        return id;
    }

    public double getWeight() {
        // Checking if weight unit equals to pounds and converting it
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

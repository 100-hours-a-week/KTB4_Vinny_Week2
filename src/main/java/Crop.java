public class Crop {
    final String name;
    private int cropId;
    public int requiredGrowDays;
    public int cost;
    public int sellPrice;

    Crop(int cropId, String name, int requiredGrowDays, int cost, int sellPrice) {
        this.cropId = cropId;
        this.name = name;
        this.requiredGrowDays = requiredGrowDays;
        this.cost = cost;
        this.sellPrice = sellPrice;
    }
}

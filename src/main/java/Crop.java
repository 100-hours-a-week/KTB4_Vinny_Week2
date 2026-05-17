public class Crop {
    private int cropId;
    public String cropName;
    public int requiredGrowDays;
    public int cost;
    public int sellPrice;

    Crop(int cropId, String cropName, int requiredGrowDays, int cost, int sellPrice) {
        this.cropId = cropId;
        this.cropName = cropName;
        this.requiredGrowDays = requiredGrowDays;
        this.cost = cost;
        this.sellPrice = sellPrice;
    }
}

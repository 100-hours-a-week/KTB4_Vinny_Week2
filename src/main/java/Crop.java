public class Crop {
    private final String name;
    private final int cropId;
    private final int requiredGrowDays;
    private final int cost;
    private final int sellPrice;

    Crop(int cropId, String name, int requiredGrowDays, int cost, int sellPrice) {
        this.cropId = cropId;
        this.name = name;
        this.requiredGrowDays = requiredGrowDays;
        this.cost = cost;
        this.sellPrice = sellPrice;
    }

    public int  getCropId() {
        return cropId;
    }

    public String getName(){
        return this.name;
    }

    public int getRequiredGrowDays(){
        return this.requiredGrowDays;
    }

    public int getCost(){
        return this.cost;
    }

    public int getSellPrice(){
        return this.sellPrice;
    }
}

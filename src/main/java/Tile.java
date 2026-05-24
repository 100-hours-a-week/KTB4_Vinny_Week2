public class Tile {
    private int tileId;
    private int cropId;
    protected int remainingDay;

    public Tile(int tileId, int cropId, int remainingDay) {
        this.tileId = tileId;
        this.cropId = cropId;
        this.remainingDay = remainingDay;
    }

    public void planting(int cropId, int remainingDay ){
        this.cropId = cropId;
        this.remainingDay = remainingDay;
    }

    public int getTileId() {
        return tileId;
    }

    public int getCropId() {
        return cropId;
    }

    public int getRemainingDay() {
        return remainingDay;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

}

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

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public String noCropString(){
        return tileId+1 + "번째 타일에는 심어진 작물이 없습니다.";
    }

    public String toString(){
        return tileId+1 + "번째 타일에는 " + cropId+1 +"작물이 심어져있고 자랄 때까지 " + remainingDay + "일 남았습니다.";
    }
}

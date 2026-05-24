import java.util.Scanner;

public class Farm {
    public String farmName;
    protected int size;

    public Farm(String farmName, int size) {
        this.farmName = farmName;
        this.size = size;
    }

    public boolean plantCrop(Scanner sc, Tile[] tiles, Crop[] crops, User user, Farm farm) {
        System.out.printf("작물 심기를 선택하셨습니다. 몇 번 타일에 심으시겠습니까? %d번까지 존재합니다\n", farm.size);
        int selectTileId = Validator.validateInt(sc, 1, farm.size) - 1;
        if (0 <= tiles[selectTileId].getCropId()) {
            System.out.println("이미 작물이 심어져있습니다.");
            return false;
        } else {
            System.out.println("어떤 작물을 심으시겠습니까?");
            System.out.println("1. 당근\n2. 감자\n3. 오이");
            int selectCrop = Validator.validateInt(sc, 1, crops.length) - 1;
            tiles[selectTileId].planting(selectCrop, crops[selectCrop].getRequiredGrowDays());
            return user.setMinusMoney(crops[selectCrop].getCost());
        }
    }

    public void havestCrop(Tile[] tiles, Crop[] crops, User user) {
        int revenue = 0;

        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].remainingDay == 0 && tiles[i].getCropId() != -1) {
                revenue += crops[tiles[i].getCropId()].getSellPrice();
                tiles[i].setCropId(-1);
            }
        }
        user.setPlusMoney(revenue);
        System.out.println("수확 가능한 작물을 모두 수확하였습니다.");
    }

    public boolean useFertilizer(Tile[] tiles, User user, Fertilizer fertilizer) {
        //TODO: 개별 타일로 구현
        boolean available = user.setMinusMoney(fertilizer.getCost());
        if (available == true) {
            System.out.printf("비료를 사용하셨습니다. 소지금 %d원이 감소합니다. 모든 작물의 수확일이 하루 감소합니다.", fertilizer.getCost());
            for (int i = 0; i < tiles.length; i++) {
                if (0 < tiles[i].remainingDay) {
                    tiles[i].remainingDay -= 1;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}

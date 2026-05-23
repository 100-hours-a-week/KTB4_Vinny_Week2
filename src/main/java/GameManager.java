import java.util.Scanner;

public class GameManager {
    private User user;
    Scanner sc = new Scanner(System.in);

    public GameManager(User user) {
        this.user = user;
    }

    public void plantCrop(Tile[] tiles, Crop[] crops) {
            System.out.println("작물 심기를 선택하셨습니다. 몇 번 타일에 심으시겠습니까? 4번까지 존재합니다");
            int selectTileId = sc.nextInt() - 1;
            if (0 <= tiles[selectTileId].getCropId()) {
                System.out.println("이미 작물이 심어져있습니다.");
            } else {
                System.out.println("어떤 작물을 심으시겠습니까?");
                System.out.println("1. 당근\n2. 감자\n3. 오이");
                int selectCrop = sc.nextInt() - 1;
                tiles[selectTileId].planting(selectCrop, crops[selectCrop].requiredGrowDays);
                user.setMinusMoney(crops[selectCrop].cost);
            }
    }

    public void havestCrop(Tile[] tiles, Crop[] crops) {
        int count = 0;
        int revenue = 0;

        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].remainingDay == 0 && tiles[i].getCropId() != -1) {
                count += 1;
                revenue += crops[tiles[i].getCropId()].sellPrice;
                tiles[i].setCropId(-1);
            }
        }

        if (count == 0) {
            // TODO: 시간 남으면 되돌아가기 구현
            System.out.println("수확 가능한 작물이 없습니다. 다음 날로 넘어갑니다.");
        } else {
            user.setPlusMoney(revenue);
            System.out.println("수확 가능한 작물을 모두 수확하였습니다.");
        }
    }

    public void useFertilizer(Tile[] tiles) {
        //TODO: 개별 타일로 구현
        System.out.println("비료를 사용하셨습니다. 소지금 2원이 감소합니다. 모든 작물의 수확일이 하루 감소합니다.");
        for (int i = 0; i < tiles.length; i++) {
            if (0 < tiles[i].remainingDay) {
                tiles[i].remainingDay -= 1;
            }
        }
        user.setMinusMoney(2);
    }

    public void currentStatus(User user, Tile[] tiles) {
        System.out.println("현재 농장 정보를 알려드리겠습니다");
        System.out.println("현재 소지금은 " + user.getMoney() + "원 입니다.");

        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].getCropId() == -1) {
                System.out.println(tiles[i].noCropString());
            } else {
                System.out.println(tiles[i].toString());
            }
        }
        System.out.println();
    }


    public void nextDay(User user, Tile[] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            if (0 < tiles[i].remainingDay) {
                tiles[i].remainingDay -= 1;
            }
        }
        user.setCurrentDay();
        System.out.println("현재 소지금은 " + user.getMoney() + "원 입니다.");
        System.out.println();
    }
}

public class OutputView {

    public void gameStart(){
        System.out.println("=====================================");
        System.out.println("        농장 경영을 시작합니다             ");
        System.out.println("=====================================");
    }

    public void gameMenu(){
        System.out.println("=====================================");
        System.out.println("           할 일을 선택해주세요           ");
        System.out.println("=====================================");
        for (Menu menu : Menu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }

    public void gameInfo(Crop[] crops, User user, Farm farm) {
        System.out.printf("\n총 자산이 %d원이 되면 클리어입니다.\n", user.getGoalMoney());
        System.out.printf("초기 자금은 %d원이며, 농장은 %d칸의 타일로 이루어져있습니다.\n", user.getMoney(), farm.size);
        System.out.println("하루에 할 수 있는 행동은 작물 심기, 작물 수확하기, 비료주기 3가지 중 하나입니다.");
        System.out.println();

        System.out.println("작문은 감자, 당근, 오이 3가지로");

        for(int i = 0; i < crops.length; i++){
            System.out.printf("%s: 성장일 %d일, 심을 때 %d원, 팔 때 %d원\n",crops[i].getName(), crops[i].getRequiredGrowDays(), crops[i].getCost(), crops[i].getSellPrice());
        }
        System.out.println("이 필요합니다");
        System.out.println("수확 시 자동으로 판매됩니다,");
        System.out.println();
    }

    public void currentStatus( Tile[] tiles, Crop[] crops,User user) {
        System.out.println("=====================================");
        System.out.println("현재 농장 정보를 알려드리겠습니다");
        System.out.printf("%d일차이며, 현재 소지금은 %d원 입니다.\n",user.getCurrentDay(), user.getMoney());
        System.out.println("=====================================");
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].getCropId() == -1) {
                System.out.printf("%d번째 타일에는 심어진 작물이 없습니다.\n", tiles[i].getTileId()+1);
            } else {
                System.out.printf("%d번째 타일에는 %s가(이) 심어져있고 다 자랄 때까지 %d일 남았습니다.\n", tiles[i].getTileId()+1, crops[tiles[i].getCropId()].getName(), tiles[i].getRemainingDay());
            }
        }
        System.out.println();
    }
}

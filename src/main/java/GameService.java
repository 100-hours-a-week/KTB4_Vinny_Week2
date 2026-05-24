import java.util.Scanner;

public class GameService {
    Scanner sc = new Scanner(System.in);
    User user = new User(200, 1, 1);
    Farm farm = new Farm("",4);
    Music music = new Music("farm.mp3",true);
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Carrot carrot = new Carrot();
    Potato potato = new Potato();
    Cucumber cucumber = new Cucumber();
    Fertilizer fertilizer = new Fertilizer("성장 쑥쑥 비료", 2);

    Tile[] tiles = new Tile[farm.size];
    Crop[] crops = new Crop[3];

    public void run(){
        gameStart();
    }

    public void gameStart() {
        crops[0] = carrot;
        crops[1] = potato;
        crops[2] = cucumber;

        for (int i = 0; i < farm.size; i++) {
            tiles[i] = new Tile(i, -1, -1);
        }

        music.start();
        System.out.println("=========농장 시뮬레이션을 시작합니다!=========");
        inputView.writeFarmName(sc, farm);
        outputView.gameInfo(crops, user, farm);

        while (true) {
            boolean actionSuccess = false;
            checkGameOver();
            System.out.println("할 일을 선택해주세요 ");
            System.out.println("0. 게임 설명 다시보기\n1. 작물 심기 \n2. 수확하기 \n3. 비료 주기\n4. 현재 농장 정보 보기\n5. 음악 종료하기");

            int userSelect = Validator.validateInt(sc, 0, 5);
            System.out.println();
            switch (userSelect) {
                case 0:
                    outputView.gameInfo(crops, user, farm);
                    break;
                case 1:
                    actionSuccess =  farm.plantCrop(sc, tiles, crops, user, farm);
                    break;
                case 2:
                    if (harvestAvailable()) {
                        farm.havestCrop(tiles, crops, user);
                        actionSuccess = true;
                    } else {
                        System.out.println("수확 가능한 작물이 없습니다. 다른 번호를 선택해주세요");
                    }
                    break;
                case 3:
                    actionSuccess = farm.useFertilizer(tiles, user, fertilizer);
                    break;
                case 4:
                    outputView.currentStatus(tiles, crops, user);
                    break;
                case 5:
                    music.close();
                    break;
                default:
                    System.out.println("올바르지 않은 입력입니다. 다시 입력해주세요.");
                    break;
            }
            if (user.getGoalMoney() <= user.getMoney()) {
                gameFinish();
                break;
            }
            if (actionSuccess) {
                nextDay(user, tiles);
            }
        }
    }

    public boolean harvestAvailable(){
        boolean isAvailable = false;

        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].remainingDay == 0 && tiles[i].getCropId() != -1) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }

    public void nextDay(User user, Tile[] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            if (0 < tiles[i].remainingDay) {
                tiles[i].remainingDay -= 1;
            }
        }
        user.setCurrentDay();
        System.out.println();
    }

    public void checkGameOver(){
        int count = 0;
        for(int i = 0; i < farm.size; i++){
            if(tiles[i].getCropId() == -1){
                count +=1;
            }
        }

        if(user.getMoney() <= 0 && count == farm.size){
            System.out.println("금액을 모두 소진하여 게임 오버 되었습니다.");
            System.exit(0);
        }
    }

    public void gameFinish(){
        System.out.println(farm.farmName+"농장의 경영이 종료 되었습니다.");
        System.out.printf("총 %d원, %d일 만에 완료하였습니다!", user.getMoney(), user.getCurrentDay());
    }
}

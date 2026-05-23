import javax.swing.*;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user = new User(200, 100, 0);
        GameManager gm = new GameManager(user);
        Farm farm = new Farm("",4);

        Carrot carrot = new Carrot();
        Potato potato = new Potato();
        Cucumber cucumber = new Cucumber();

        Tile[] tiles = new Tile[4];
        Crop[] crops = new Crop[3];

        crops[0] = carrot;
        crops[1] = potato;
        crops[2] = cucumber;

        for(int i = 0; i < 4; i++){
            tiles[i] = new Tile(i, -1, -1);
        }

        Fertilizer fertilizer = new Fertilizer("성장 단축 비료", 5);

        System.out.println("농장 시뮬레이션을 시작합니다!");
        System.out.print("농장 이름을 작성해주세요: ");
        farm.farmName = sc.nextLine();
        System.out.println();

        System.out.printf("총 자산이 %d원이 되면 클리어입니다.\n", user.getGoalMoney());
        System.out.printf("초기 자금은 %d원이며, 농장은 %d칸의 타일로 이루어져있습니다.\n", user.getMoney(), farm.size);
        System.out.println("하루에 할 수 있는 행동은 작물 심기, 작물 수확하기, 비료주기 3가지 중 하나입니다.");
        System.out.println();

        System.out.println("작문은 감자, 당근, 오이 3가지로");
        System.out.printf("%s: 성장일 %d일, 심을 때 %d원, 팔 때 %d원\n", carrot.name, carrot.requiredGrowDays, carrot.cost, carrot.sellPrice);
        System.out.printf("%s: 성장일 %d일, 심을 때 %d원, 팔 때 %d원\n", potato.name, potato.requiredGrowDays, potato.cost, potato.sellPrice);
        System.out.printf("%s: 성장일 %d일, 심을 때 %d원, 팔 때 %d원\n", cucumber.name, cucumber.requiredGrowDays, cucumber.cost, cucumber.sellPrice);
        System.out.println("이 필요합니다");
        System.out.println("수확 시 자동으로 판매됩니다,");
        System.out.println();

        while(true) {
            //매번 이렇게 검사..?
            int count = 0;
            for(int i = 0; i < 4; i++){
                if(tiles[i].getCropId() == -1){
                    count +=1;
                }
            }

            if(user.getMoney() == 0 && count ==4){
                System.out.println("금액을 모두 소진하여 게임 오버 되었습니다.");
                break;
            }

            boolean correctNumber = true;
            while(correctNumber){
            System.out.println("할 일을 선택해주세요 ");
            System.out.println("1. 작물 심기 \n2. 수확하기 \n3. 비료 주기\n4. 현재 농장 정보 보기");
            int userSelect = sc.nextInt();
            System.out.println();
            switch (userSelect) {
                case 1:
                    correctNumber = false;
                    gm.plantCrop(tiles, crops);
                    break;
                case 2:
                    correctNumber = false;
                    gm.havestCrop(tiles, crops);
                    break;
                case 3:
                    correctNumber = false;
                    gm.useFertilizer(tiles);
                    break;
                case 4:
                    gm.currentStatus(user, tiles);
                    break;
                default:
                    System.out.println("올바르지 않은 선택 입니다. 다시 선태갷주세요.");
                    break;
            }
            }
            gm.nextDay(user, tiles);

            if(user.getGoalMoney() <= user.getMoney()){
                System.out.println(farm.farmName+"농장의 경영이 종료 되었습니다.");
                System.out.printf("총 %d원, %d일 만에 완료하였습니다!", user.getMoney(), user.getCurrentDay());
                break;
            }
        }



    }
}

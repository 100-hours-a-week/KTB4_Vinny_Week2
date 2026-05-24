import java.util.Scanner;

public class InputView {

    public static void writeFarmName(Scanner sc, Farm farm){
        System.out.print("농장 이름을 작성해주세요: ");
        farm.farmName = sc.nextLine();
    }
}

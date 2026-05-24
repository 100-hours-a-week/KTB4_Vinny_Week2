import java.util.Scanner;

public class Validator {
    public static int validateInt(Scanner sc, int min, int max) {
        while(true){
            String input = sc.nextLine().trim();
            try {
                int num = Integer.parseInt(input);
                if(min <= num && num <= max){
                    return num;
                }
                System.out.println("유효한 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("유효한 번호를 입력해주세요.");
            }
        }
    }
}

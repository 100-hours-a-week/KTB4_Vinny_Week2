public class User {
    private final int goalMoney;
    private int money;
    private int currentDay;

    public User(int goalMoney, int money, int currentDay) {
        this.goalMoney = goalMoney;
        this.money = money;
        this.currentDay = currentDay;
    }

    public int getGoalMoney() {
        return goalMoney;
    }

    public int getMoney() {
        return money;
    }

    public boolean setMinusMoney(int money) {
        if(this.money < money){
            System.out.println("금액이 부족합니다");
            return false;
        } else {
            this.money -= money;
            return true;
        }
    }

    public void setPlusMoney(int money) {
        this.money += money;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay() {
        this.currentDay +=1;
    }
}

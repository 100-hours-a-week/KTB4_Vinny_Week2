public class User {
    private final int goalMoney;
    private int money;
    private int currentDay;

    public User(int goalMoney, int money, int currentDay) {
        this.goalMoney = goalMoney;
        this.money = money;
        this.currentDay = currentDay;
    }

    public String toString() {
        return "User(goalMoney=" + goalMoney + ", money=" + money + ", currentDay=" + currentDay + ")";
    }

    public int getGoalMoney() {
        return goalMoney;
    }

    public int getMoney() {
        return money;
    }

    public void setMinusMoney(int money) {
        this.money -= money;
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

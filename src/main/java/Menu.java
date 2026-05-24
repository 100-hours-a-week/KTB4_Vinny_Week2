public enum Menu {
    GAME_INFO(0, "게임 설명 다시보기"),
    PLANT_CROP(1, "작물 심기"),
    HARVEST_CROP(2, "수확하기"),
    USE_FERTILIZER(3, "비료 주기"),
    SHOW_STATUS(4, "현재 농장 정보 보기"),
    EXIT_MUSIC(5, "음악 종료하기");

    private final int code;
    private final String title;

    Menu(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static Menu toString(int userSelect) {
        for (Menu menu : Menu.values()) {
            if (menu.code == userSelect) {
                return menu;
            }
        }
        return null;
    }
}


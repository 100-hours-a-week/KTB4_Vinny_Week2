import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
    private boolean isLoop;
    private Player player;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean isLoop) {
        try{
            this.isLoop = isLoop;
            file = new File(Music.class.getResource("/music/" + name).toURI());
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void close(){
        isLoop = false;
        System.out.println("음악을 종료합니다.");
        player.close();
        this.interrupt();
    }

    @Override
    public void run() {
        try{
            do{
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while (isLoop);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

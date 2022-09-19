import mayflower.*;
import java.awt.MouseInfo;

public class TitleScreen extends World {

    Point p = MouseInfo.getPointerInfo().getLocation();

    public TitleScreen() {
//        setBackground("");
        showText("GAME", 350, 250, Color.BLACK);
        showText("Press P to play", 350, 350,Color.BLACK);
    }
    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_P) ) {
            World mw = new MyWorld();
            Mayflower.setWorld(mw);
        }
        int x = p.x;
        int y = p.y;
    }
}

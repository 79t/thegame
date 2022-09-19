import mayflower.*;

public class TitleScreen extends World {

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
    }
}

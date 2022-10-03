import mayflower.*;
import kuusisto.tinysound.*;

public class TitleScreen extends World {
    private Music m;
    public TitleScreen() {
        TinySound.init();
        m = TinySound.loadMusic("assets/halo.wav");
        m.play(true);
        setBackground("assets/BG/BG.png");
        showText("GAME", 350, 250, Color.BLACK);
        showText("Press P to play", 350, 350,Color.BLACK);

    }
    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_P) ) {
            World mw = new LevelOne();
            m.stop();
            Mayflower.setWorld(mw);
        }

    }
}

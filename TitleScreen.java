import mayflower.*;
import kuusisto.tinysound.*;

public class TitleScreen extends World {
    private Music m;
    public TitleScreen() {
        TinySound.init();
        m = TinySound.loadMusic("assets/music/halo.wav");
        m.play(true);
        setBackground("assets/BG/BG.png");
        showText("GAME", 350, 250, Color.BLACK);
        showText("Press P to play", 350, 350,Color.BLACK);

    }
    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_P) ) {
            // TODO: change this back to levelOne
            //World mw = new LevelOne();
            World mw = new LevelThree(0, 100);
            m.stop();
            Mayflower.setWorld(mw);
        }

    }
}

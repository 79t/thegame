import kuusisto.tinysound.TinySound;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.World;

// screen for the non-pro gamers
public class GameOverLose extends World {
    private TextRenderer t;
    public GameOverLose(int sc) {
        t = new TextRenderer(this);
        t.showText("you lost 💀", 350, 250);
        t.showText("press q to quit", 350, 350);
        t.showText("your final score was " + sc, 150, 450);
        TinySound.shutdown();
    }

    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_Q)) {
            Mayflower.exit();
        }
    }
}
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.World;
import kuusisto.tinysound.*;

// screen for the pro gamers
public class GameOverWin extends World {
    private TextRenderer t;
    public GameOverWin(int sc, int h) {
        t = new TextRenderer(this);
        t.showText("you won! good job", 350, 250);
        t.showText("press q to quit", 350, 350);
        t.showText("your final score was " + sc, 150, 450);
        t.showText("and your final health was " + h, 150, 550);
        TinySound.shutdown();
    }

    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_Q)) {
            Mayflower.exit();
        }
    }
}
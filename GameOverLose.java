import mayflower.Color;
import mayflower.Keyboard;
import mayflower.Mayflower;
import mayflower.World;

// screen for the non-pro gamers
public class GameOverLose extends World {
    public GameOverLose() {
        showText("you lose!!", 350, 250, Color.BLACK);
        showText("press q to quit", 350, 350, Color.BLACK);
    }

    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_Q)) {
            Mayflower.exit();
        }
    }
}
import mayflower.*;


// screen for pro gamers
public class GameOverWin extends World {
    public GameOverWin() {
        showText("you win!!", 350, 250, Color.BLACK);
        showText("press q to quit", 350, 350, Color.BLACK);
    }

    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_Q)) {
            Mayflower.exit();
        }
    }
}
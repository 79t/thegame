import mayflower.*;

public class TitleScreen extends World {

    private Zombie zombie;
    public TitleScreen() {
        setBackground("assets/BG/BG.png");
        showText("GAME", 350, 250, Color.BLACK);
        showText("Press P to play", 350, 350,Color.BLACK);
        zombie = new Zombie();
        addObject(zombie, 400, 100);
    }
    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_P) ) {
            World mw = new LevelOne();
            Mayflower.setWorld(mw);
        }

    }
}

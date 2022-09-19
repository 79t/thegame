import mayflower.*;
public class LevelOne extends World {

    public LevelOne()
    {

        Mayflower.showBounds(true);
        showText("this is the world", 350, 250, Color.BLACK);
        showText("press w to win; l to lose", 350, 350, Color.BLACK);
        addObject(new Block(), 0, 500);
        addObject(new Block(), 128, 500);
        addObject(new Cat(), 0, 0);

    }

    public void act()
    {
        if (Mayflower.isKeyPressed(Keyboard.KEY_W)) {
            World win = new GameOverWin();
            Mayflower.setWorld(win);
        } else if (Mayflower.isKeyPressed(Keyboard.KEY_L)) {
            World lose = new GameOverLose();
            Mayflower.setWorld(lose);
        }
    }

}
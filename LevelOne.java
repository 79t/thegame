import mayflower.*;
public class LevelOne extends World {

    private String[][] tiles;

    public LevelOne()
    {
        setBackground("assets/BG/overworldBG.png");

        // TODO: Build Overworld
        //      objects, hazards, etc
        Mayflower.showBounds(true);
        showText("this is the world", 350, 250, Color.BLACK);
        showText("press w to win; l to lose", 350, 350, Color.BLACK);

        tiles = new String[6][8];
        for (int i = 0; i < tiles[0].length; i++) {
            if (i != 6) addObject(new Block(), i * 100, (tiles.length - 1) * 100);
        }

        addObject(new Cat(),0, 300);


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
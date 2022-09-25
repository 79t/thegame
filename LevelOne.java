import mayflower.*;
public class LevelOne extends World {

    private String[][] tiles;
    public LevelOne()
    {
        Mayflower.showBounds(true);
        setBackground("assets/BG/overworldBG.png");

        // TODO: Build Overworld
        //      objects, hazards, etc
        Mayflower.showBounds(true);
        showText("this is the world", 350, 250, Color.BLACK);
        showText("press w to win; l to lose", 350, 350, Color.BLACK);

        Emerald e = new Emerald();
        addObject(e, 100, 400);

        tiles = new String[6][8];
        int bc = 0;
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j == 5) {
                    addObject(new Block(), i * 100, j * 100);
                }
            }
        }
        System.out.println(bc);

        Cat c = new Cat();
        addObject(c,0, 300);
        showText("score is " + c.getScore(), 10, 30, Color.BLACK);


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
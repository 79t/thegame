import mayflower.*;

public class LevelOne extends World {

    private String[][] tiles;
    private TextRenderer t;
    private Cat c;
    public LevelOne()
    {
        t = new TextRenderer(this);
        Mayflower.showBounds(true);
        setBackground("assets/BG/overworldBG.png");

        // TODO: Build Overworld
        //      objects, hazards, etc
        Mayflower.showBounds(true);
        t.showText("this is the world", 350, 250);
        t.showText("press w to win; l to lose", 350, 350);

        NetherPortal n = new NetherPortal();
        addObject(n, 700, 380);

        Emerald e = new Emerald();
        addObject(e, 100, 400);

        tiles = new String[6][8];

        tiles[4][5] = "lava";
        addObject(new Lava(), 400, 515);

        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j == 5 && i != 4) {
                    addObject(new Block(), i * 100, j * 100);
                    tiles[j][i] = "block";
                }
            }
        }


        c = new Cat(0, 100);
        addObject(c,0, 200);
        showText("score is " + c.getScore(), 10, 30, Color.BLACK);


    }

    public TextRenderer getTextRenderer() {
        return t;
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

        t.removeText(10, 30);
        t.showText("score: " + c.getScore() + " health: " + c.getHealth(), 10, 30);

    }

}
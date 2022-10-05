import mayflower.*;


// THe first level
public class LevelOne extends World {

    private String[][] tiles;
    private TextRenderer t;
    private Cat c;
    public LevelOne()
    {
        t = new TextRenderer(this);
        Mayflower.showBounds(true);
        setBackground("assets/BG/overworldBG.png");

        Mayflower.showBounds(true);
        t.showText("welcome to the overworld!", 350, 250);

        NetherPortal n = new NetherPortal();
        addObject(n, 700, 380);

        EmeraldOld e = new EmeraldOld();
        addObject(e, 100, 400);

        // tiles array
        tiles = new String[6][8];
        // add hazards
        tiles[4][5] = "lava";
        addObject(new Lava(), 400, 515);
        // add blocks
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j == 5 && i != 4) {
                    addObject(new Block(), i * 100, j * 100);
                    tiles[j][i] = "block";
                }
            }
        }

        // add main character
        c = new Cat(0, 100);
        addObject(c,0, 200);
        showText("score is " + c.getScore(), 10, 30, Color.BLACK);


    }



    public void act()
    {

        // score and health text
        t.removeText(10, 30);
        t.showText("score: " + c.getScore() + " health: " + c.getHealth(), 10, 30);
        


    }

}
import mayflower.*;

public class LevelThree extends World {

    private String[][] tiles;
    private String[][] upperTiles;
    private Cat c;

    private TextRenderer t;

    public LevelThree(int score, int health) {
        t = new TextRenderer(this);
        Mayflower.showBounds(true);
        setBackground("assets/BG/nethre.jpeg");

        // TODO: Build Overworld
        //      objects, hazards, etc
        Mayflower.showBounds(true);
        t.showText("this is the FINAL WORLD", 350, 250);
        t.showText("press w to win; l to lose", 350, 350);

        tiles = new String[6][8];
        int bc = 0;
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j == 5) {
                    addObject(new Block(), i * 45, j * 100);
                    addObject(new Lava(), i * 50 + 350, j * 100);
                }
            }
        }
        upperTiles = new String[6][8];
        for(int i = 0; i < upperTiles[0].length; i++)
        {
            for(int j = 0; j < upperTiles.length; j++)
            {
                if(j == 5)
                {
                    addObject(new Block(), i * 45 + 400, j * 100 + 300);
                }
            }
        }
        addObject(new Ladder(), 400, 200);
        addObject(new EmeraldOld(), 100, 400);
        NetherPortal n = new NetherPortal();
        addObject(n, 700, 120);
        System.out.println(bc);

        c = new Cat(score, health);

        addObject(c, 0, 300);


    }

    public void act() {

     

        t.removeText(10, 30);
        t.showText("score: " + c.getScore() + " health: " + c.getHealth(), 10, 30);


    }


    public TextRenderer getTextRenderer() {
        return t;
    }
}




import mayflower.*;

public class LevelThree extends World {

    private String[][] tiles;
    // private String[][] upperTiles;
    private Cat c;

    private TextRenderer t;

    public LevelThree(int score, int health) {
        t = new TextRenderer(this);
        Mayflower.showBounds(true);
        setBackground("assets/BG/end.jpeg");

        Mayflower.showBounds(true);
        t.showText("this is the FINAL WORLD", 350, 450);

        addObject(new EnderDragon(100, 0), 100, 0);

        tiles = new String[6][8];
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j == 5) {
                    addObject(new Block(), i * 45, j * 100);
                    addObject(new Lava(), i * 50 + 350, j * 100);
                }

                if (j == 1 && i != 4) {
                    addObject(new Block(), i * 100, j * 100 + 50);
                }
            }
        }
        
        addObject(new Ladder(), 400, 200);
        addObject(new Emerald(100, 400), 100, 400);

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




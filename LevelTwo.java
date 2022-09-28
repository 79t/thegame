import mayflower.*;

public class LevelTwo extends World {

    private String[][] tiles;
    private Cat c;

    private TextRenderer t;
    public LevelTwo(int score, int health)
    {
        t = new TextRenderer(this);
        Mayflower.showBounds(true);
        setBackground("assets/BG/nethre.jpeg");

        // TODO: Build Overworld
        //      objects, hazards, etc
        Mayflower.showBounds(true);
        t.showText("this is world 2", 350, 250);
        t.showText("press w to win; l to lose", 350, 350);

        tiles = new String[6][8];
        int bc = 0;
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j == 5) {
                    addObject(new Block(), i * 100, j * 100);
                }
            }
        }
        addObject(new Block(), 400, 400);
        System.out.println(bc);

        c = new Cat(score, health);

        addObject(c,0, 300);


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


    public TextRenderer getTextRenderer() {
        return t;
    }


}
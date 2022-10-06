import mayflower.*;

// this is the 2nd level
public class LevelTwo extends World {

    private String[][] tiles;
    // private String[][] tilesTwo;
    private Cat c;
    private TextRenderer t;
    public LevelTwo(int score, int health)
    {
        t = new TextRenderer(this);
        Mayflower.showBounds(true);
        setBackground("assets/BG/nethre.jpeg");

        Mayflower.showBounds(true);
        t.showText("welcome to the nether", 350, 250);

        // make tiles, add blocks
        tiles = new String[6][8];
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j == 5) {
                    addObject(new Block(), i * 100, j * 100);
                }
            }
        }

        // add climbing ladder
        // addObject(new Block(), 475, 375);
        addObject(new Emerald(100, 400), 100, 400);
        // addObject(new Block(), 400, 400);
        
        addObject(new Blaze(700, 400), 700, 400);

        EndPortal e = new EndPortal();
        addObject(e, 700, 120);

        addObject(new Ladder(), 700, 220);
        addObject(new Ladder(), 700, 320);


        // make cat with same score and health as LevelOne
        c = new Cat(score, health);

        addObject(c,0, 300);
        
        
    }
    
    public void automatedDogMovement(Dog d)
    {
        
        while(c.getHealth() != 0)
        {
        int z = (int)Math.random()*4;
        if(z < 1  && ((d.getX() >= 0)))
            d.setLocation(d.getX()-1, d.getY());
        else if (z >= 1 && z < 2  && (d.getX() + 1 + d.getWidth() <= 800))
            d.setLocation(d.getX() + 1, d.getY());
         else if(z >= 2 && !d.isFalling() && d.getY() <= 200)
            d.setLocation(d.getX(), d.getY() - 1);
            //jumping = true;
            //velY = -1;
            d.setLocation(d.getX(), d.getY() + 1);
         if(d.isTouching(Blaze.class))
         {
            d.setLocation(d.getX(), d.getY() - 1);
            d.setLocation(d.getX(), d.getY()+1);
            //jumping = true;
            //velY = -1;
         
         }
        }
    }
    
         
    
    public void act()
    {

        
        t.removeText(10, 30);
        t.showText("score: " + c.getScore() + " health: " + c.getHealth(), 10, 30);


    }



}
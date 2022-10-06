import mayflower.*;
import kuusisto.tinysound.*;

public class EnderDragon extends Actor {
    private MayflowerImage left;
    private MayflowerImage right;
    private String dir;
    private int health;
    public EnderDragon(int x, int y) {
        health = 50;
        left = new MayflowerImage("assets/enderdragon.png");
        right = new MayflowerImage(left);
        right.mirrorHorizontally();

        left.scale(0.7);
        right.scale(0.7);
        dir = "left";
        setImage(left);
    }

    public int getHealth() { return health; }
    public void decrHealth(int howMany) { health -= howMany; }

    public void act() {
        int x = getX();
        int y = getY();
        int h = getHeight();

        if (health <= 0) {
            World w = getWorld();
            w.addObject(new DragonEgg(), 200, 0);
        }

        if (isTouching(Cat.class)) {
            Cat c = getOneIntersectingObject(Cat.class);
            Music m = TinySound.loadMusic("assets/music/oof.wav");
            m.play(false);
            dir = "left";
            c.respawn();
            c.decrHealth(10);
            
        }

        if (dir.equals("right") && x <= 800 - h) {
            setLocation(x + 1, y);
            setImage(right);

            if (x >= 800 - h) {
                dir = "left";
            }
        }

        if (dir.equals("left") && x >= 0) {
            setImage(left);
            setLocation(x - 1, y);

            if (x <= 0) {
                dir = "right";
            }

        }

    }
}

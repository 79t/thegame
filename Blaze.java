import mayflower.*;
import kuusisto.tinysound.*;

public class Blaze extends Actor {
    private MayflowerImage left;
    private MayflowerImage right;
    private String dir;
    private int ogx, ogy;
    public Blaze(int x, int y) {
        ogx = x;
        ogy = y;
        left = new MayflowerImage("assets/blaze.png");
        right = new MayflowerImage(left);
        right.mirrorHorizontally();

        left.scale(50, 100);
        right.scale(50, 100);
        dir = "left";
        setImage(left);
    }

    public void act() {
        int x = getX();
        int y = getY();
        int h = getHeight();

        if (isTouching(Cat.class)) {
            Cat c = getOneIntersectingObject(Cat.class);
            // TODO: fix this so the blaze moves back to ogx, ogy
            setLocation(ogx, ogy);
            Music m = TinySound.loadMusic("assets/music/oof.wav");
            m.play(false);
            dir = "left";
            c.respawn();
            c.decrHealth(25);
            
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

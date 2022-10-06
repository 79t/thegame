import mayflower.*;


public class Emerald extends Actor {
    private MayflowerImage left;
    private MayflowerImage right;
    private String dir;
    public Emerald(int x, int y) {
        left = new MayflowerImage("assets/Object/emerald.png");
        right = new MayflowerImage(left);
        right.mirrorHorizontally();

        left.scale(62, 62);
        right.scale(62, 62);
        dir = "right";
        setImage(right);
    }

    public void act() {
        int x = getX();
        int y = getY();
        int h = getHeight();
        if (isTouching(Cat.class)) {
            Cat c = (Cat)getOneIntersectingObject(Cat.class);
            c.incScore();
            if(getWorld() instanceof LevelTwo)
                c.incScore();
            World w = getWorld();
            w.removeObject(this);
        }
        if(isTouching(Blaze.class))
        {
            if(dir.equals("right"))
            {
                dir = "left";
                setLocation(x-5, y);
                setImage(left);
            }
        }
        if(isTouching(Blaze.class))
        {
            if(dir.equals("left"))
            {
                dir = "right";
                setLocation(x + 5, y);
                setImage(right);
            }
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

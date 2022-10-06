import mayflower.*;

public class DragonEgg extends Actor {
    public DragonEgg() {
        MayflowerImage m = new MayflowerImage("assets/egg.png");
        m.scale(50,50);
        setImage(m);
    }

    public void act() {
        if (isFalling()) {
            setLocation(getX(), getY()+1);
        }
    }

    public boolean isFalling() {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class) || isTouching(Ladder.class) ;
        setLocation(getX(), getY() - 1);
        return !ret;
    }

}

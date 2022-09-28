import mayflower.*;

import java.util.logging.Level;

public class Emerald extends Actor {
    public Emerald() {
        MayflowerImage e = new MayflowerImage("assets/Object/emerald.png");
        e.scale(62, 62);
        setImage(e);
    }

    public void act() {
        if (isTouching(Cat.class)) {
            Cat c = (Cat)getOneIntersectingObject(Cat.class);
            c.incScore();
            if(getWorld() instanceof LevelTwo)
                c.incScore();
            World w = getWorld();
            w.removeObject(this);
        }
    }
}
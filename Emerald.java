import mayflower.*;

// Bonus score object
public class Emerald extends Actor {
    public Emerald() {
        MayflowerImage e = new MayflowerImage("assets/Object/emerald.png");
        e.scale(62, 62);
        setImage(e);
    }

    // if the cat hits an emerald, change its score and delete the emerald
    public void act() {
        if (isTouching(Cat.class)) {
            Cat c = (Cat)getOneIntersectingObject(Cat.class);
            c.incScore();
            World w = getWorld();
            w.removeObject(this);
        }
    }
}
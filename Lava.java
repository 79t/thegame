import mayflower.*;

public class Lava extends Actor {
    public Lava() {
        MayflowerImage m = new MayflowerImage("assets/Object/lava.jpeg");
        m.scale(128, 128);
        setImage(m);
    }

    public void act() {
        if (isTouching(Cat.class)) {
            Cat c = getOneIntersectingObject(Cat.class);
            c.respawn();
            c.decrHealth(50);
        }
    }
}
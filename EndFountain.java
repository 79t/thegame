import mayflower.*;

public class EndFountain extends Actor {
    public EndFountain() {
        MayflowerImage m = new MayflowerImage("assets/endfountain.png");
        setImage(m);
    }

    public void act() {
        if (isTouching(Cat.class)) {
            Cat c = getOneIntersectingObject(Cat.class);
            World w = new GameOverWin(c.getScore(), c.getHealth());
            Mayflower.setWorld(w);
        }
    }

}

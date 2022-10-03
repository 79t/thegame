import kuusisto.tinysound.Music;
import kuusisto.tinysound.TinySound;
import mayflower.*;

public class NetherPortal extends Actor {
    private final Music mu;
    public NetherPortal() {
        MayflowerImage m = new MayflowerImage("assets/Object/netherportal2.png");
        m.scale(128, 128);
        setImage(m);
        TinySound.init();
        mu = TinySound.loadMusic("assets/pigstep.wav");
        mu.play(true);
    }
    public void act() {
        // move to LevelTwo if cat hits nether portal, with same health and score as the one from world1
        if (isTouching(Cat.class)) {
            Cat c = getOneIntersectingObject(Cat.class);
            int currentHealth, currentScore;
            currentHealth = c.getHealth();
            currentScore = c.getScore();
            mu.stop();
            World newWorld = new LevelTwo(currentScore, currentHealth);
            Mayflower.setWorld(newWorld);
        }
    }
}

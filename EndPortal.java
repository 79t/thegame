import kuusisto.tinysound.TinySound;
import kuusisto.tinysound.Music;
import mayflower.*;
public class EndPortal extends Actor
{
    private Music mu;
    public EndPortal() {
        MayflowerImage m = new MayflowerImage("assets/end_portal.png");
        TinySound.init();
        mu = TinySound.loadMusic("assets/music/pigstep.wav");
        mu.play(true); 
        m.scale(128, 128);
        setImage(m);
    }
    public void act() {
        if (isTouching(Cat.class)) {
            Cat c = getOneIntersectingObject(Cat.class);
            mu.stop();
            World newWorld = new LevelThree(c.getScore(), c.getHealth()); 
            Mayflower.setWorld(newWorld);
        }
    }

    public void pause() { mu.pause(); }
    public void resume() { mu.resume(); }

}

import mayflower.*;
import kuusisto.tinysound.*;

public class Sword extends Actor {

    public Sword() {
        MayflowerImage m = new MayflowerImage("assets/sword.png");
        m.scale(50, 50);
        m.mirrorHorizontally();
    
        setImage(m);
    }
    
    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_A) && isTouching(EnderDragon.class) && isTouching(Cat.class)) {
            EnderDragon e = getOneIntersectingObject(EnderDragon.class);
            e.decrHealth(20);
            e.setLocation(100, 0);
            Music m = TinySound.loadMusic("assets/music/enderdragonhit.wav");
            m.play(false);
        }
    }
    
}

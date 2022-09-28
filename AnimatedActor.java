import mayflower.*;

/**
 * @author suhas
 * @version 1.0.0
 * This class extends the Mayflower.Actor class, and embeds an Animation,
 * in order to add support for animated characters
 * @see Animation
 */

public class AnimatedActor extends GravityActor {
    // Instance variables, embedded Animation, and a Timer to control frame shifts
    private Animation animation;
    private final Timer animationTimer;

    /**
     * Initialize an Animated actor class
     */
    public AnimatedActor() {
        animationTimer = new Timer(1000);
        animation = null;
    }

    public void setAnimation(Animation a) {
        animation = a;
    }

    // runs every frame, when the timer is finished, go to the next frame (handled by Animation), set the image to the next frame
    // and reset the timer
    public void act() {
        super.act();
        if (animation != null && animationTimer.isDone())
        {

            MayflowerImage m = animation.getNextFrame();
            setImage(m);
            animationTimer.reset();
        }
    }
}

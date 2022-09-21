import mayflower.*;

public class GravityActor extends Actor {
    private boolean isFallingTrue;
    public GravityActor() {
        boolean isFallingTrue = true;
    }
    public void act() {
        setLocation(getX(), getY() + 1);
        if (isBlocked() && isFallingTrue) setLocation(getX(), getY() - 1);

        if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE) && isBlocked()) {
            isFallingTrue = false;
            Timer jumpTimer = new Timer(4000);
            while (!jumpTimer.isDone()) {
                setLocation(getX(), getY() - 1);
            }
            isFallingTrue = true;
        }
    }

    private boolean isBlocked() {
        return isTouching(Block.class);
    }

    public boolean isFalling() {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}
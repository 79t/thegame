import mayflower.*;

public class GravityActor extends Actor {
    private boolean isJumping;
    public GravityActor() {
        boolean isJumping = false;
    }
    public void act() {
        if (!isJumping) setLocation(getX(), getY() + 1);
        if (isBlocked()) setLocation(getX(), getY() - 1);

        if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE) && isBlocked()) {
            isJumping = true;
            Timer jumpTimer = new Timer(4000);
            while (!jumpTimer.isDone()) {
                setLocation(getX(), getY() - 1);
            }
            isJumping = false;
            // g
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
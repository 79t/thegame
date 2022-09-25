import mayflower.*;

public class GravityActor extends Actor {
    private float gravity = 0.1f;
    private float velY;
    private boolean jumping = false;

    public void act() {
        if (isFalling() || jumping) {
            velY += gravity;
            setLocation(getX(), getY() + velY);
        }

        if (isBlocked()) {
            setLocation(getX(), getY() - velY);
            velY = 0;
        }

        if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE) && isBlocked()) {
            velY = -5;
        }
    }

    private boolean isBlocked() {
        setLocation(getX(), getY() + 1);
        boolean it = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return it;
    }

    public boolean isFalling() {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}

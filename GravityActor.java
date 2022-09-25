import mayflower.*;

public class GravityActor extends Actor {
    private float gravity = 0.1f;
    private float velY;
    final int TERMINAL = 5;
    private boolean jumping = false;

    public void act() {
        if (isFalling() || jumping) {
            velY += gravity;
            setLocation(getX(), getY() + velY);
        }

        if (isBlocked()) {
            setLocation(getX(), getY());
            velY = 0;
        }

        if (velY >= TERMINAL)
            velY = TERMINAL;

        if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE)) {
            if(isBlocked()) {
                    setLocation(getX(), getY() - 5);
                velY = -5;
            }
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

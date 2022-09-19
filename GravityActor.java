import mayflower.*;

public class GravityActor extends Actor {
    final int GRAVITY = 10;
    int vertical_speed = 0;
    public void act() {
        if (!isBlocked() && vertical_speed < 300) {
            vertical_speed = vertical_speed + GRAVITY;
            if (vertical_speed > TERMINAL_VELOCITY) {
                vertical_speed = TERMINAL_VELOCITY;
            }
            setLocation(getX(), getY() + vertical_speed);
        }
        if (isBlocked()) setLocation(getX(), getY() - 1);

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
import mayflower.*;

public class GravityActor extends GravityTimer {
    final double GRAVITY = 9.8;
    final int TERMINAL_VELOCITY = 300;
    double vertical_speed = 0;
    private int t = 0;
    public void act() {
        //t = 0;
        while(!isBlocked() && vertical_speed < TERMINAL_VELOCITY)
        {
            vertical_speed = vertical_speed + GRAVITY*((1000-g.getTimeLeft())+ t);
            t+=1000;
        }

        /*
        int t = 0;
        if (!isBlocked() && vertical_speed < 300) {
            vertical_speed = vertical_speed + GRAVITY;
            if (vertical_speed > TERMINAL_VELOCITY) {
                vertical_speed = TERMINAL_VELOCITY;
            }
            setLocation(getX(), getY() + vertical_speed);

         */

        if (isBlocked()) {
            setLocation(getX(), getY() - vertical_speed);
            vertical_speed = 0;
        }

        if (Mayflower.isKeyPressed(Keyboard.KEY_UP)) {
            vertical_speed = 20;
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
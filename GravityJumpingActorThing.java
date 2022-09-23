import mayflower.*;

public class GravityJumpingActorThing extends GravityTimer {
    final double GRAVITY = 9.8;
    final int TERMINAL_VELOCITY = 300;
    double vertical_speed = 0;
    private int t = 0;
    private boolean isJumping;
    public GravityJumpingActorThing()
    {
        isJumping = false;
    }
    public void act() {
        //t = 0;
        /*
        while (!isBlocked() && vertical_speed < TERMINAL_VELOCITY) {
            vertical_speed = vertical_speed + GRAVITY * ((1000 - g.getTimeLeft()) + t);
            setLocation(getX(), getY() + vertical_speed*t);
            t += 1000;
        }
        */
        //if (isBlocked()) {
           // setLocation(getX(), getY() - vertical_speed);
           // vertical_speed = 0;
       // }

        //if (Mayflower.isKeyPressed(Keyboard.KEY_UP)) {
           // vertical_speed = 20;
        //}

        if(!isJumping)
            setLocation(getX(), getY()+1);
        if(isBlocked())
            setLocation(getX(), getY()-1);
        if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE)&&Mayflower.isKeyPressed(Keyboard.KEY_RIGHT)) {
            setLocation(getX(), getY()+1);
            if (isBlocked()) {
                isJumping = true;
                Timer jumpTimer = new Timer(40000);
                while (!jumpTimer.isDone()) {
                    setLocation(getX()+100, getY() - 100);
                }
                isJumping = false;
                jumpTimer.reset();
            }
            setLocation(getX(), getY() - 1);
        }
        else if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE))
        {
            setLocation(getX(), getY()+1);
            if (isBlocked()) {
                isJumping = true;
                Timer jumpTimer = new Timer(40000);
                while (!jumpTimer.isDone()) {
                    setLocation(getX(), getY() - 100);
                }
                isJumping = false;
                jumpTimer.reset();
            }
            setLocation(getX(), getY() - 1);
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

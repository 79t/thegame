import mayflower.*;

public class GravityActor extends Actor {
    private float gravity = 0.2f;
    private float velY;
    final int TERMINAL = 5;
    private boolean jumping = false;

    public void act() {
        if (isFalling() || jumping) {
            velY += gravity;
            setLocation(getX(), getY() + velY);
        }

        if (isBlocked()) {
            setLocation(getX(), getY() - 1);
            jumping = false;
            velY = 0;
        }

        if (velY >= TERMINAL)
            velY = TERMINAL;

        if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE) && !isFalling()) {
            setLocation(getX(), getY() - 5);
            jumping = true;
            velY = -7;
        }
        if (isTouching(Ladder.class)) {
            velY = 0;
            if (Mayflower.isKeyDown(Keyboard.KEY_SPACE) || Mayflower.isKeyDown(Keyboard.KEY_UP)) {
                setLocation(getX(), getY() - 1);
            }
            if (Mayflower.isKeyDown(Keyboard.KEY_DOWN)){
                setLocation(getX(), getY() + 1);
            }
        }


    }

    private boolean isBlocked() {
        return isTouching(Block.class);
    }

    public boolean isFalling() {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class) || isTouching(Ladder.class) ;
        setLocation(getX(), getY() - 1);
        return !ret;
    }


}

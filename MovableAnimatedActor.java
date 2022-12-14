import mayflower.*;

/**
 * an actor that can move, has animations for each move type as well as idling
 */
public class MovableAnimatedActor extends AnimatedActor {
    // animations for each type of movement
    private Animation walkRight;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation walkLeft;
    private Animation falling;
    private Animation fallingRight;

    private Animation jumpLeft;

    private Animation jumpRight;

    private Animation climb;
    // variables to keep track of which way its going, and whats happening right now
    private String currentAction;
    private String direction;

    public MovableAnimatedActor() {
        walkRight = null;
        idleLeft = null;
        idleRight = null;
        currentAction = null;
        falling = null;
        fallingRight = null;
        direction = "right";
    }

    public void act() {
        // if there isnt an action, set the action to idleRight
        String newAction = null;
        if (currentAction == null) {
            newAction = "idleRight";
        }

        super.act();
        int x = getX();
        int y = getY();
        int w = getWidth();

        // movement commands, with bounds checking
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && (x + 1 + w <= 800)) {
            setLocation(x + 2, y);
            newAction = "walkRight";
            direction = "right";
            if (isTouching(Block.class)) {
                setLocation(x-2, y);
            }
        } else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && (x - 1 >= 0)) {
            setLocation(x - 2, y);
            newAction = "walkLeft";
            direction = "left";
            if (isTouching(Block.class)) {
                setLocation(x+2,y);
            }


            // change action based on direction and newaction

            // } else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && (y + 1 + h <= 600)) {
            // setLocation(x, y + 1);
            // if (isTouching(Block.class)) {
            // setLocation(x, y - 1);
            // }
            // } else if (Mayflower.isKeyDown(Keyboard.KEY_UP) && (y - 1 >= 0)) {
            // setLocation(x, y - 1);
            // if (isTouching(Block.class)) {                
            // setLocation(x, y + 1);
            // }
        } else {
            if (direction != null && direction.equals("left")) {
                newAction = "idleLeft";
            } else if (direction != null && direction.equals("right")) {
                newAction = "idleRight";
            }
        }

        if (isFalling() && direction.equals("right") && direction != null) newAction = "fallRight";
        if (isFalling() && direction.equals("left") && direction != null) newAction = "fallLeft";
        if (isJumping() && direction.equals("right") && direction != null) newAction = "jumpRight";
        if (isJumping() && direction.equals("left") && direction != null) newAction = "jumpLeft";
        if (isClimbing()) newAction = "climb";


        if (!newAction.equals(currentAction) && newAction != null) {
            if (newAction.equals("walkRight")) {
                setAnimation(walkRight);
                currentAction = newAction;
            } else if (newAction.equals("idleLeft")) {
                setAnimation(idleLeft);
                currentAction = newAction;
            } else if (newAction.equals("idleRight")) {
                setAnimation(idleRight);
                currentAction = newAction;
            } else if (newAction.equals("walkLeft")) {
                setAnimation(walkLeft);
                currentAction = newAction;
            } else if (newAction.equals("fallRight")) {
                setAnimation(fallingRight);
                currentAction = newAction;
            } else if (newAction.equals("fallLeft")) {
                setAnimation(falling);
                currentAction = newAction;
            } else if (newAction.equals("jumpLeft")) {
                setAnimation(jumpLeft);
                currentAction = newAction;
            } else if (newAction.equals("jumpRight")) {
                setAnimation(jumpRight);
                currentAction = newAction;
            } else if (newAction.equals("climb")) {
                setAnimation(climb);
                currentAction = newAction;
            }
        }

    }

    // setters
    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }

    public void setWalkRightAnimation(Animation ani) {
        walkRight = ani;
    }

    public void setIdleRightAnimation(Animation ani) {
        idleRight = ani;
    }

    public void setIdleLeftAnimation(Animation ani) {
        idleLeft = ani;
    }

    public void setWalkLeftAnimation(Animation ani) {
        walkLeft = ani;
    }

    public void setFallLeftAnimation(Animation a) {
        falling = a;
    }

    public void setFallRightAnimation(Animation a) { fallingRight = a; }

    public void setJumpRightAnimation(Animation a) { jumpRight = a; }

    public void setJumpLeftAnimation(Animation a) { jumpLeft = a; }

    public void setClimbAnimation(Animation a) { climb = a; }


}
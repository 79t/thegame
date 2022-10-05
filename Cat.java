import mayflower.*;

/**
 * @author suhas, alex, tarun
 * A cat that moves, falls, idles, and has a score and health
 */
public class Cat extends MovableAnimatedActor
{
    // Initialize the variables
    // animations for walk idle fall in both directions
    // score and health trackers
    private Animation walkRight;
    private Animation idleRight;
    private Animation walkLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation idleLeft;
    private int score;
    private int health;


    // create a new cat with a starting score and health attached
    public Cat(int startScore, int startHealth)
    {
        score = startScore;
        health = startHealth;
        String[] idleImages = new String[10];
        // make list of images for walking, idling, and falling
        for (int i = 0; i < idleImages.length; i++)
            idleImages[i] = String.format("assets/cat/Idle (%d).png", i + 1);

        String[] walkImages = new String[10];
        for (int i = 0; i < walkImages.length; i++)
            walkImages[i] = String.format("assets/cat/Walk (%d).png", i + 1);

        String[] fallImages = new String[8];
        for (int i = 0; i < fallImages.length; i++)
            fallImages[i] = String.format("assets/cat/Fall (%d).png", i + 1);


        // make animation for idleright, change size and bounds
        // and do the same for idleleft, but mirrored
        idleRight = new Animation(50000000, idleImages);
        idleRight.scale(100, 87);
        idleRight.setBounds(18, 5, 54, 80);


        idleLeft = new Animation(50000000, idleImages);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(18, 5, 54, 80);

        // do the same thing for walking and fallign but with different images and stuff i guess
        walkRight = new Animation(50000000, walkImages);
        walkRight.scale(100, 87);
        walkRight.setBounds(18, 5, 54, 80);

        walkLeft = new Animation(50000000, walkImages);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);


        fallRight = new Animation(50000000, fallImages);
        fallRight.scale(100, 87);
        fallRight.setBounds(18, 5, 54, 80);

        fallLeft = new Animation(50000000, fallImages);
        fallLeft.mirrorHorizontally();
        fallLeft.scale(100, 87);
        fallLeft.setBounds(28, 5, 54, 80);

        // set animations to the animatiosn
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setFallLeftAnimation(fallLeft);
        setFallRightAnimation(fallRight);
    }
    public void act()
    {
        // movement logic (moving + gravity) is in superclasses, so call those
        super.act();
        // die if health is too low
        if (health <= 0) {
            World gameOver = new GameOverLose(this.score);
            Mayflower.setWorld(gameOver);
        }
    }

    // getters and setters for score
    public int getScore() { return score; }
    public void incScore() { score++; }

    // getters and setters for health
    public int getHealth() { return health; }
    public void decrHealth(int howMany) {
        health -= howMany;
    }
    public void incrHealth(int howMany) {
        health += howMany;
    }

    // remake actors, used when damage is taken
    public void respawn() {
        setLocation(0, 200);
    }



}

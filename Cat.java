import mayflower.*;
public class Cat extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation idleRight;
    private Animation walkLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation idleLeft;

    private Animation jumpRight;

    private Animation jumpLeft;

    private int score;
    private int health;

    public Cat(int startScore, int startHealth)
    {
        score = startScore;
        health = startHealth;
        String[] idleImages = new String[10];
        for (int i = 0; i < idleImages.length; i++)
            idleImages[i] = String.format("assets/cat/Idle (%d).png", i + 1);

        String[] walkImages = new String[10];
        for (int i = 0; i < walkImages.length; i++)
            walkImages[i] = String.format("assets/cat/Walk (%d).png", i + 1);

        String[] fallImages = new String[8];
        for (int i = 0; i < fallImages.length; i++)
            fallImages[i] = String.format("assets/cat/Fall (%d).png", i + 1);

        String[] jumpImages = new String[8];
        for (int i = 0; i < jumpImages.length; i++)
            jumpImages[i] = String.format("assets/cat/Jump (%d).png", i + 1);


        idleRight = new Animation(50000000, idleImages);
        idleRight.scale(100, 87);
        idleRight.setBounds(18, 5, 54, 80);


        idleLeft = new Animation(50000000, idleImages);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(18, 5, 54, 80);

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

        jumpRight = new Animation(50000000, jumpImages);
        jumpRight.scale(100, 87);
        jumpRight.setBounds(18, 5, 54, 80);

        jumpLeft = new Animation(50000000, jumpImages);
        jumpLeft.mirrorHorizontally();
        jumpLeft.scale(100, 87);
        jumpLeft.setBounds(18, 5, 54, 80);


        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setFallLeftAnimation(fallLeft);
        setFallRightAnimation(fallRight);
        setJumpRightAnimation(jumpRight);
        setJumpLeftAnimation(jumpLeft);
    }
    public void act()
    {
        super.act();

        if (health <= 0 || getY() >= getWorld().getHeight()) {
            World gameOver = new GameOverLose(this.score);
            Mayflower.setWorld(gameOver);
        }
    }

    public int getScore() { return score; }
    public void incScore() { score++; }


    public int getHealth() { return health; }
    public void decrHealth(int howMany) {
        health -= howMany;
    }
    public void incrHealth(int howMany) {
        health += howMany;
    }

    // remake actors, used when damage is taken
    public void respawn() {
        setLocation(0, 300);
    }




}

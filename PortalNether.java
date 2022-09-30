import mayflower.*;
public class PortalNether extends Actor
{
    public PortalNether() {
        MayflowerImage m = new MayflowerImage("assets/Object/netherportal2.png");
        m.scale(128, 128);
        setImage(m);
    }
    public void act() {
        if (isTouching(Cat.class)) {
            Cat c = getOneIntersectingObject(Cat.class);
            int currentHealth, currentScore;
            currentHealth = c.getHealth();
            currentScore = c.getScore();
            World newWorld = new LevelTwo(currentScore, currentHealth);
            Mayflower.setWorld(newWorld);
        }
    }
}

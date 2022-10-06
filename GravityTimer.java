import mayflower.*;

//a timer for falling
public class GravityTimer extends Actor
{
    public Timer g;
    public GravityTimer()
    {
        g = new Timer(1000);
    }
    public void act()
    {
        if(g.isDone())
            g.reset();
    }
}


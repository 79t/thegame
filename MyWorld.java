import mayflower.*;


public class MyWorld extends World {

    public MyWorld()
    {

        Mayflower.showBounds(true);
        showText("this is the world", 350, 250, Color.BLACK);
        showText("press w to win; l to lose", 350, 350, Color.BLACK);

    }

    public void act()
    {
    }

}
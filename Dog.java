import mayflower.*;
public class Dog extends MovableAnimatedActor
{
   private Animation walkRight;
   private Animation idleRight;
   private Animation walkLeft;
   private Animation fallRight;
   private Animation fallLeft;
   private Animation idleLeft;
   public Dog()
   {
       String[] idleImages = new String[10];
       // make list of images for walking, idling, and falling
       for (int i = 0; i < idleImages.length; i++)
           idleImages[i] = String.format("assets/dog/Idle (%d).png", i + 1);

       String[] walkImages = new String[10];
       for (int i = 0; i < walkImages.length; i++)
           walkImages[i] = String.format("assets/dog/Walk (%d).png", i + 1);

       String[] fallImages = new String[8];
       for (int i = 0; i < fallImages.length; i++)
           fallImages[i] = String.format("assets/dog/Fall (%d).png", i + 1);


       // make animation for idleright, change size and bounds
       // and do the same for idleleft, but mirrored
       idleRight = new Animation(50000000, idleImages);
       idleRight.scale(100, 87);
       idleRight.setBounds(18, 5, 54, 80);


       idleLeft = new Animation(50000000, idleImages);
       idleLeft.scale(100, 87);
       idleLeft.mirrorHorizontally();
       idleLeft.setBounds(18, 5, 54, 80);

       // do the same thing for walking and falling but with different images and stuff i guess
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
        super.act();
        //DogMovements();
   }

   public boolean isTouching(Class<? extends Actor> cls) {
    return super.isTouching(cls);
   }




}

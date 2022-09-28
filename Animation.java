import mayflower.*;

/**
 * @author suhas
 * A class that helps to animate a character, using a list of MayflowerImages, and a set framerate to shift images at
 */
public class Animation {
    private int framerate;
    private final MayflowerImage[] frames;
    private int currentFrame;

    /**
     * Initialize an animation
     * @param fr the framerate the animation runs at
     * @param fns a list of filenames of your animation (used to fetch the images for the MayflowerImages)
     */
    public Animation(int fr, String[] fns) {
        frames = new MayflowerImage[fns.length];
        for (int i = 0; i < fns.length; i++) {
            frames[i] = new MayflowerImage(fns[i]);
        }
        currentFrame = 0;

    }

    private int getFramerate() { return framerate; }

    // Switch to the next frame, and if the new frame is more than the total # of frames, go back to frame 0
    // and return the new frame
    public MayflowerImage getNextFrame() {
        MayflowerImage re = frames[currentFrame];
        currentFrame += 1;
        currentFrame %= frames.length;
        return re;
    }

    /**
     * Scale every image in the Animation
     * @param w width to be scaled to
     * @param h height to be scaled to
     */
    public void scale(int w, int h) {
        for (MayflowerImage frame : frames) {
            frame.scale(w, h);
        }
    }

    /**
     * Set the transparency of every image in the Animation
     * @param percent % transparency to set to
     */
    public void setTransparency(int percent) {
        for (MayflowerImage frame : frames) {
            frame.setTransparency(percent);
        }
    }

    // Flip every image in an animation
    public void mirrorHorizontally() {
        for (MayflowerImage frame : frames) {
            frame.mirrorHorizontally();
        }
    }

    /**
     * bulk crop every image
     * @param x x coordinate
     * @param y y coordinate
     * @param w width
     * @param h height
     */
    public void setBounds(int x, int y, int w, int h) {
        for (MayflowerImage frame : frames) {
            frame.crop(x, y, w, h);
        }
    }

}
import mayflower.*;

public class Animation {
    private int framerate;
    private MayflowerImage[] frames;
    private int currentFrame;

    public Animation(int fr, String[] fns) {
        frames = new MayflowerImage[fns.length];
        for (int i = 0; i < fns.length; i++) {
            frames[i] = new MayflowerImage(fns[i]);
        }
        currentFrame = 0;
        framerate = fr;

    }

    public int getFrameRate() { return framerate; }

    public MayflowerImage getNextFrame() {
        MayflowerImage re = frames[currentFrame];
        currentFrame += 1;
        currentFrame %= frames.length;
        return re;
    }

    public void scale(int w, int h) {
        for (MayflowerImage frame : frames) {
            frame.scale(w, h);
        }
    }

    public void setTransparency(int percent) {
        for (MayflowerImage frame : frames) {
            frame.setTransparency(percent);
        }
    }

    public void mirrorHorizontally() {
        for (MayflowerImage frame : frames) {
            frame.mirrorHorizontally();
        }
    }

    public void setBounds(int x, int y, int w, int h) {
        for (MayflowerImage frame : frames) {
            frame.crop(x, y, w, h);
        }
    }

}
import mayflower.*;
import java.util.HashMap;

/**
 * Helper class to dynamically change the color of the text and remember it based on the current world
 */

public class TextRenderer {
    private final World w;
    private final Color color;

    public TextRenderer(World wo) {
        w = wo;
        HashMap<Class<? extends World>, Color>  mappings = new HashMap<>(); 
        mappings.put(LevelOne.class, Color.BLACK);
        mappings.put(LevelTwo.class, Color.WHITE);
        mappings.put(LevelThree.class, Color.CYAN);
        mappings.put(GameOverLose.class, Color.RED);
        color = (Color) mappings.get(w.getClass());
    }

    public void showText(String t, int x, int y) {
        w.showText(t, x, y, color);
    }

    public void removeText(int x, int y) {
        w.removeText(x, y);
    }
}

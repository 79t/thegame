import mayflower.*;
import java.util.Map;


public class TextRenderer {
    private final World w;
    private final Color color;

    public TextRenderer(World wo) {
        w = wo;
        Map<?, ?> mappings = Map.of(
                LevelOne.class, Color.BLACK,
                LevelTwo.class, Color.WHITE
        );
        color = (Color) mappings.get(w.getClass());
    }

    public void showText(String t, int x, int y) {
        w.showText(t, x, y, color);
    }

    public void removeText(int x, int y) {
        w.removeText(x, y);
    }
}

package zelda.items;

import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.engine.Game;

/**
 *
 * @author Bas Harteveld
 */

public class GuiRupee extends GObject
{
    private final static String[] rupeeAnimation = {"rupee"};

    public GuiRupee(Game game, int x, int y)
    {
        super(game, x, y, 11, 10, "images/rupeegui2.png");
        spriteLoc.put("rupee",new Rectangle(0, 0, 11, 10));

        setAnimation(rupeeAnimation);

		z = 2;

        screenAdjust = false;
        checkcollision = false;
        liquid = true;
    }
}

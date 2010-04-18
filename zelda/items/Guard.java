package zelda.items;

import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.karacter.Direction;

/**
 *
 * @author Christiaan
 */
public class Guard extends GObject
{
    private final static String[] downAnimation = {"DOWN"};
    private final static String[] upAnimation = {"UP"};
    private final static String[] leftAnimation = {"LEFT"};
    private final static String[] rightAnimation = {"RIGHT"};

    public Guard(Game game, int x, int y, Direction direction)
	{
        super(game, x, y, 25, 25, "images/items.png");

        spriteLoc.put("DOWN",	new Rectangle(0, 25, 25, 30));
        spriteLoc.put("LEFT",	new Rectangle(25, 25, 21, 28));
        spriteLoc.put("UP",		new Rectangle(50, 25, 25, 28));
        spriteLoc.put("RIGHT",	new Rectangle(75, 25, 21, 28));

        switch (direction)
		{
            case UP:
                sprite.setSprite(spriteLoc.get("UP"));
                setAnimation(upAnimation);
                break;

            case DOWN:
                sprite.setSprite(spriteLoc.get("DOWN"));
                setAnimation(downAnimation);
                break;

            case LEFT:
				width = 21;
                sprite.setSprite(spriteLoc.get("LEFT"));
                setAnimation(leftAnimation);
                break;

            case RIGHT:
                sprite.setSprite(spriteLoc.get("RIGHT"));
                setAnimation(rightAnimation);
                break;
        }
    }
}

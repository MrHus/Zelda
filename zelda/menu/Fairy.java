package zelda.menu;

import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.engine.Game;

/**
 *
 * @author maartenhus
 */
public class Fairy extends GObject
{
	private static String[] flyani = {"Fly1", "Fly2"};

	public Fairy(Game game, int x, int y)
	{
		super(game, x, y, 14, 16, "images/fairy.png");

		spriteLoc.put("Fly1",	new Rectangle(0, 0, 14, 16));
		spriteLoc.put("Fly2",	new Rectangle(20, 0, 14, 16));

		sprite.setSprite(spriteLoc.get("Fly1"));

		setAnimationInterval(250);
		setAnimation(flyani);
	}
}

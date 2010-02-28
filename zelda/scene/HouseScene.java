package zelda.scene;

import java.awt.Rectangle;
import zelda.Game;
import zelda.engine.Scene;

/**
 *
 * @author maartenhus
 */
public class HouseScene extends Scene
{
	public HouseScene(Game game)
	{
		super(game, "../images/link-house.png");
		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));
	}
}

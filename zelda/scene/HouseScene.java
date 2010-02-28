package zelda.scene;

import java.awt.Rectangle;
import zelda.ZeldaGame;
import zelda.engine.Scene;

/**
 *
 * @author maartenhus
 */
public class HouseScene extends Scene
{
	public HouseScene(ZeldaGame game)
	{
		super(game, "../images/link-house.png");
		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));
	}

	public void handleInput()
	{
		
	}
}

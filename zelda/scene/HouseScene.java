package zelda.scene;

import java.awt.Rectangle;
import zelda.ZeldaGame;
import zelda.engine.Scene;
import zelda.link.Link;

/**
 *
 * @author maartenhus
 */
public class HouseScene extends Scene
{
	private Link link;

	public HouseScene(ZeldaGame game)
	{
		super(game, "../images/link-house.png");
		link = game.getLink();
		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));
	}

	public void handleInput()
	{
		if (!link.getStateString().equals("SwordState"))
		{
			int currentMaxX = sprite.getX() + sprite.getWidth();
			int currentMaxY = sprite.getY() + sprite.getHeight();

			int mod = 1;
			int sens = 10;
			int box = 200;

			if ((link.getX()) > (currentMaxX - box))
			{
				int newX = sprite.getX() + mod;
				if ((newX + game.getWidth()) <= sprite.getImageWidth())
				{
					link.setX(link.getX() - mod);
					sprite.setX(newX);
				}
			}

			if (link.getX() < (sprite.getX() + box))
			{
				int newX = sprite.getX() - mod;

				if (newX > 0)
				{
					link.setX(link.getX() + mod);
					sprite.setX(newX);
				}
			}

			if (link.getY() > (currentMaxY - box))
			{
				int newY = sprite.getY() + mod;
				if ((newY + game.getHeight()) <= sprite.getImageHeight())
				{
					link.setY(link.getY() - mod);
					sprite.setY(newY);
				}
			}

			if (link.getY() < (sprite.getY() + box))
			{
				int newY = sprite.getY() - mod;

				if (newY > 0)
				{
					link.setY(link.getY() + mod);
					sprite.setY(newY);
				}
			}
		}
	}
}

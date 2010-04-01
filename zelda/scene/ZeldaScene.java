package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.ZeldaGame;
import zelda.engine.GObject;
import zelda.engine.Scene;
import zelda.link.Link;

/**
 * A specialised Scene object for the Zelda game.
 *
 * @author maartenhus
 */
public class ZeldaScene extends Scene
{
	protected Link link;
	private ZeldaGame game;

	public ZeldaScene(ZeldaGame game, String img)
	{
		super(game, img);
		this.game = game;
		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));
	}

	@Override
	public void handleInput()
	{
		super.handleInput();

		// If links walks to the border of the screen it should scroll.
		if (!link.getStateString().equals("SwordState")) //ignore swordstate
		{
			final int currentMaxX = sprite.getX() + sprite.getWidth();
			final int currentMaxY = sprite.getY() + sprite.getHeight();

			final int mod = 1;
			final int box = 200;

			if ((link.getX()) > (currentMaxX - box))
			{
				int newX = sprite.getX() + mod;
				if ((newX + game.getWidth()) <= sprite.getImageWidth())
				{
					link.setX(link.getX() - mod);
					modShapes(-mod, 0);
					sprite.setX(newX);
				}
			}

			if (link.getX() < (sprite.getX() + box))
			{
				int newX = sprite.getX() - mod;

				if (newX > 0)
				{
					link.setX(link.getX() + mod);
					modShapes(mod, 0);
					sprite.setX(newX);
				}
			}

			if (link.getY() > (currentMaxY - box))
			{
				int newY = sprite.getY() + mod;
				if ((newY + game.getHeight()) <= sprite.getImageHeight())
				{
					link.setY(link.getY() - mod);
					modShapes(0, -mod);
					sprite.setY(newY);
				}
			}

			if (link.getY() < (sprite.getY() + box))
			{
				int newY = sprite.getY() - mod;

				if (newY > 0)
				{
					link.setY(link.getY() + mod);
					modShapes(0, mod);
					sprite.setY(newY);
				}
			}
		}
	}

	@Override
	public void initScene()
	{
		link = game.getLink();
	}

	/**
	 * When the screen moves everything else should move in the opposite direction.
	 * otherwise they won't sit still.
	 *
	 * @param modX
	 * @param modY
	 */
	private void modShapes(int modX, int modY)
	{
		for (Polygon poly : solids)
		{
			poly.translate(modX, modY);
		}

		for (GObject obj : gameObjects)
		{
			if (!(obj instanceof Link)) // ignore link
			{
				obj.setX(obj.getX() + modX);
				obj.setY(obj.getY() + modY);
			}
		}
	}
}
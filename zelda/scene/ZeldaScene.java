package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.engine.Scene;
import zelda.items.GuiHeart;
import zelda.link.Link;

/**
 * A specialised Scene object for the Zelda game.
 *
 * @author maartenhus
 */
public class ZeldaScene extends Scene
{
	protected Link link;
	protected boolean move;

	private int XSen; //left/right sensitivity for when the scene adapts too link
	private int YSen; //up/down sensitivity for when the scene adapts too link
	private final static int MOD = 1;

	public ZeldaScene(Game game, String img)
	{
		super(game, img);

		XSen = game.getWidth() / 2;
		YSen = game.getHeight() / 2;
		
		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));

        GuiHeart heart = new GuiHeart(game, 370, 50, true);
        gameObjects.add(heart);
	}

	@Override
	public void handleInput()
	{
		super.handleInput();

		// If links walks to the border of the screen it should scroll.
		if (!link.getStateString().equals("SwordState")) //ignore swordstate
		{
			if (link.getX() > (sprite.getWidth() - XSen)) // link moves too far to the right.
			{
				int newX = sprite.getX() + MOD;
				if ((newX + sprite.getWidth()) <= sprite.getImageWidth())
				{
					link.setX(link.getX() - MOD);
					modShapes(-MOD, 0);
					sprite.setX(newX);
				}
			}

			if (link.getX() < (sprite.getX() + XSen)) // link moves too far to the left
			{
				int newX = sprite.getX() - MOD;

				if (newX > 0)
				{
					link.setX(link.getX() + MOD);
					modShapes(MOD, 0);
					sprite.setX(newX);
				}
			}

			if (link.getY() > (sprite.getHeight() - YSen)) // link moves too far down
			{
				int newY = sprite.getY() + MOD;
				if ((newY + sprite.getHeight()) <= sprite.getImageHeight())
				{
					link.setY(link.getY() - MOD);
					modShapes(0, -MOD);
					sprite.setY(newY);
				}
			}

			if (link.getY() < YSen) // link moves to far up
			{
				int newY = sprite.getY() - MOD;

				if (newY > 0)
				{
					link.setY(link.getY() + MOD);
					modShapes(0, MOD);
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
			if (obj.isScreenAdjust()) // should it adjust when screen moves.
			{
				obj.setX(obj.getX() + modX);
				obj.setY(obj.getY() + modY);
			}
		}
	}
}

package zelda.scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Graphics2D;
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

        for(int i = 0; i < 5; i++)
        {
			GuiHeart heart = new GuiHeart(game, 370+i*12, 50, true);
			gameObjects.add(heart);
        }
	}

	@Override
	public void handleInput()
	{
		super.handleInput();

		// If links walks to the border of the screen it should scroll.
		if (!link.getStateString().equals("SwordState")) //ignore swordstate
		{
            //System.out.println(link.getX() + " > " + (sprite.getWidth() - XSen));
			if (link.getX() > (sprite.getWidth() - XSen)) // link moves too far to the right.
			{
				int newX = sprite.getX() + MOD;
               // System.out.println((newX + sprite.getWidth()) + " <= " + sprite.getImageWidth());
				if ((newX + sprite.getWidth()) <= sprite.getImageWidth())
				{
                    //System.out.println(newX + " " + sprite.getX());
					link.setX(link.getX() - MOD);
					modShapes(-MOD, 0);
					sprite.setX(newX);
				}
			}

			if (link.getX() < XSen) // link moves too far to the left
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
//                    System.out.println(newY + " " + sprite.getY());
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
				obj.setXHardCore(obj.getX() + modX);
				obj.setYHardCore(obj.getY() + modY);
			}
		}
	}

    @Override
    public void draw(Graphics2D g2)
	{
		g2.drawImage(sprite.getImage(), 0, 0, game.getWidth(), game.getHeight(), null);
        g2.setColor(Color.white);
        Font f = new Font ("Serif", Font.BOLD, 12);
        g2.setFont (f);
        g2.drawString("-- LIFE --", game.getWidth() - 122, game.getHeight() / 9);
	}
}

    


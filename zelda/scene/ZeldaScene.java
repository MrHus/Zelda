package zelda.scene;


import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.util.ArrayList;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.engine.Scene;
import zelda.items.GuiHeart;
import zelda.items.GuiRupee;
import zelda.link.Link;

/**
 * A specialised Scene object for the Zelda game.
 *
 * @author maartenhus
 */
public abstract class ZeldaScene extends Scene
{
	protected ArrayList<Rectangle> exits = new ArrayList<Rectangle>();

	protected Link link;
	protected boolean move;

	private int XSen; //left/right sensitivity for when the scene adapts too link
	private int YSen; //up/down sensitivity for when the scene adapts too link
	private final static int MOD = 1;

  	public ZeldaScene(Game game, String img, String entrance)
	{
		super(game, img, entrance);

		XSen = game.getWidth() / 2;
		YSen = game.getHeight() / 2;
        link = game.getLink();
		
		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));

        GuiHeart heart;

        for(int i = 0; i < 5; i++) //draw live bar hearts
        {
            heart = new GuiHeart(game, (game.getWidth() - 130)+i*12 , 50);
            gameObjects.add(heart);
        }
         
        GuiRupee rupee = new GuiRupee(game, 100, game.getHeight() / 11); // draw rupee amount
        gameObjects.add(rupee);
	}

	@Override
	public void handleInput()
	{
		super.handleInput();
		
		checkLinkIsInExit();
		
		if (!link.getStateString().equals("SwordState") && !link.getStateString().equals("BowState")) //ignore swordstate and bowstate
		{
			moveScene(link.getX(), link.getY());
		}
	}

	private void checkLinkIsInExit()
	{
		for(Rectangle exit : exits)
		{
			if (exit.intersects(link.getRectangle()))
			{
				handleSwitchScene(exit);
			}
		}
	}

	public boolean moveScene(int moveToX, int moveToY)
	{
		boolean moved = false;

		if (moveToX > (sprite.getWidth() - XSen)) // link moves too far to the right.
		{
			int newX = sprite.getX() + MOD;
		   // System.out.println((newX + sprite.getWidth()) + " <= " + sprite.getImageWidth());
			if ((newX + sprite.getWidth()) <= sprite.getImageWidth())
			{
				//System.out.println(newX + " " + sprite.getX());
				link.setX(link.getX() - MOD);
				modShapes(-MOD, 0);
				sprite.setX(newX);
				moved = true;
			}
		}

		if (moveToX < XSen) // link moves too far to the left
		{
			int newX = sprite.getX() - MOD;

			if (newX > 0)
			{
				link.setX(link.getX() + MOD);
				modShapes(MOD, 0);
				sprite.setX(newX);
				moved = true;
			}
		}

		if (moveToY > (sprite.getHeight() - YSen)) // link moves too far down
		{
			int newY = sprite.getY() + MOD;
			if ((newY + sprite.getHeight()) <= sprite.getImageHeight())
			{
				link.setY(link.getY() - MOD);
				modShapes(0, -MOD);
				sprite.setY(newY);
				moved = true;
			}
		}

		if (moveToY < YSen) // link moves to far up
		{
			int newY = sprite.getY() - MOD;

			if (newY > 0)
			{
				link.setY(link.getY() + MOD);
				modShapes(0, MOD);
				sprite.setY(newY);
				moved = true;
			}
		}
		
		return moved;
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

		for (Rectangle rect : exits)
		{
			rect.translate(modX, modY);
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
        g2.drawString("" + link.getRupee(), 98, game.getHeight() / 7);
	}

	public ArrayList<Rectangle> getExits()
	{
		 return exits;
	}
}

    


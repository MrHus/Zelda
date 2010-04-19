package zelda.engine;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * This represents a level in the game.
 *
 * @author maartenhus
 */
public abstract class Scene implements DrawAble
{
	protected Sprite sprite;
	protected Game game;

    protected ArrayList<GObject> newGameObjects = new ArrayList<GObject>();
	protected ArrayList<GObject> gameObjects = new ArrayList<GObject>();
	protected ArrayList<Polygon> solids = new ArrayList<Polygon>();
	protected ArrayList<Rectangle> hitters = new ArrayList<Rectangle>();
    protected ArrayList<Polygon> eyeViews = new ArrayList<Polygon>();

	protected String sceneName;

	protected final static int MOD = 1;

	public Scene(Game game, String img, String sceneName)
	{
		this.game = game;
		sprite = new Sprite(img);
		this.sceneName = sceneName;
	}
	
	public void draw(Graphics2D g2)
	{
		g2.drawImage(sprite.getImage(), 0, 0, game.getWidth(), game.getHeight(), null);
	}

	public synchronized void handleInput()
	{
		for (GObject obj : newGameObjects)
        {
            gameObjects.add(obj);
        }

		Collections.sort(gameObjects, new GObjectComparator());

        for (Iterator<GObject> it = gameObjects.iterator(); it.hasNext();) // remove dead objects
		{
			GObject obj = it.next();
			if (!obj.isAlive())
			{
				it.remove();
			}
		}
        newGameObjects.clear();
	}

	public void moveScene(int toX, int toY)
	{
		boolean moved = false;

		do
		{
			moved = false;

			if (sprite.getX() < toX)
			{
				int newX = sprite.getX() + MOD;

				if ((newX + sprite.getWidth()) <= sprite.getImageWidth())
				{
					game.getLink().setX(game.getLink().getX() - MOD);
					modShapes(-MOD, 0);
					sprite.setX(newX);
					moved = true;
				}
			}

			if (sprite.getX() > toX) // link moves too far to the left
			{
				int newX = sprite.getX() - MOD;

				if (newX > 0)
				{
					game.getLink().setX(game.getLink().getX() + MOD);
					modShapes(MOD, 0);
					sprite.setX(newX);
					moved = true;
				}
			}

			if (sprite.getY() < toY)
			{
				int newY = sprite.getY() + MOD;
				if ((newY + sprite.getHeight()) <= sprite.getImageHeight())
				{
					game.getLink().setY(game.getLink().getY() - MOD);
					modShapes(0, -MOD);
					sprite.setY(newY);
					moved = true;
				}
			}

			if (sprite.getY() > toY)
			{
				int newY = sprite.getY() - MOD;

				if (newY > 0)
				{
					game.getLink().setY(game.getLink().getY() + MOD);
					modShapes(0, MOD);
					sprite.setY(newY);
					moved = true;
				}
			}
		}
		while(moved);
	}

	/**
	 * When the screen moves everything else should move in the opposite direction.
	 * otherwise they won't sit still.
	 *
	 * @param modX
	 * @param modY
	 */
	public void modShapes(int modX, int modY)
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
	
	public void addGObject(GObject gObject)
	{
		gameObjects.add(gObject);
	}

    public void addNewGObject(GObject gObject)
	{
		newGameObjects.add(gObject);
	}

	public ArrayList<Polygon> getSolids()
	{
		return solids;
	}

	public ArrayList<GObject> getGObjects()
	{
		return gameObjects;
	}

	public void addHitter(Rectangle rect)
	{
		hitters.add(rect);
	}

	public void removeHitter(Rectangle rect)
	{
		hitters.remove(rect);
	}

	public ArrayList<Rectangle> getHitters()
	{
		return hitters;
	}

    public void addEyeView(Polygon poly)
	{
		eyeViews.add(poly);
	}

	public void removeEyeView(Polygon poly)
	{
		eyeViews.remove(poly);
	}

	public ArrayList<Polygon> getEyeViews()
	{
		return eyeViews;
	}

	public String getName()
	{
		return sceneName;
	}

	//remove after done with PolyCreator
	public Sprite getSprite()
	{
		return sprite;
	}
}

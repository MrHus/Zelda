package zelda.engine;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
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

	protected ArrayList<GObject> gameObjects = new ArrayList<GObject>();
	protected ArrayList<Polygon> solids = new ArrayList<Polygon>();
	protected ArrayList<Rectangle> hitters = new ArrayList<Rectangle>();

	public Scene(Game game, String img)
	{
		this.game = game;
		sprite = new Sprite(img);
	}

	public void initScene(){}

	public void handleInput()
	{
		for (Iterator<GObject> it = gameObjects.iterator(); it.hasNext();) // remove dead objects
		{
			GObject obj = it.next();
			if (!obj.isAlive())
			{
				it.remove();
			}
		}
	}

	public void draw(Graphics2D g2)
	{
		g2.drawImage(sprite.getImage(), 0, 0, game.getWidth(), game.getHeight(), null);
	}

	public void addGObject(GObject gObject)
	{
		gameObjects.add(gObject);
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

	//remove after done with PolyCreator
	public Sprite getSprite()
	{
		return sprite;
	}
}

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

    protected ArrayList<GObject> newGameObjects = new ArrayList<GObject>();
	protected ArrayList<GObject> gameObjects = new ArrayList<GObject>();
	protected ArrayList<Polygon> solids = new ArrayList<Polygon>();
	protected ArrayList<Rectangle> hitters = new ArrayList<Rectangle>();
    protected ArrayList<Polygon> eyeViews = new ArrayList<Polygon>();

	public Scene(Game game, String img)
	{
		this.game = game;
		sprite = new Sprite(img);
		//initScene();
	}

	public abstract void handleExit(Rectangle exit);
	//public abstract void initScene();

	public synchronized void handleInput()
	{
		for (GObject obj : newGameObjects)
        {
            gameObjects.add(obj);
        }

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

	public void draw(Graphics2D g2)
	{
		g2.drawImage(sprite.getImage(), 0, 0, game.getWidth(), game.getHeight(), null);
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

	//remove after done with PolyCreator
	public Sprite getSprite()
	{
		return sprite;
	}
}

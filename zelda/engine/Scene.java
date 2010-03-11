package zelda.engine;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author maartenhus
 */
public abstract class Scene implements DrawAble
{

	protected Sprite sprite;
	protected Game game;
	protected ArrayList<GObject> gameObjects = new ArrayList<GObject>();
	protected ArrayList<Polygon> solids = new ArrayList<Polygon>();

	public Scene(Game game, String img)
	{
		this.game = game;
		sprite = new Sprite(img);
	}

	public void initScene()
	{
	}

	public void handleInput()
	{
		for (Iterator<GObject> it = gameObjects.iterator(); it.hasNext();)
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

	//remove after done with PolyCreator
	public Sprite getSprite()
	{
		return sprite;
	}
}

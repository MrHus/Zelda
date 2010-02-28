package zelda;

import java.awt.Dimension;
import java.util.ArrayList;
import zelda.engine.GObject;
import zelda.link.Link;
import zelda.scene.HouseScene;
import zelda.engine.Scene;

/**
 *
 * @author maartenhus
 */
public class Game
{
	private int gameSpeed = 10;
	private int width = 400;
	private int height = 400;
	private ArrayList<GObject> gameObjects = new ArrayList<GObject>();
	private Link link = new Link(this, 100, 100);
	private Scene scene = new HouseScene(this);

	public Game()
	{
		gameObjects.add(link);
	}

	public ArrayList<GObject> getGObjects()
	{
		return gameObjects;
	}

	public Link getLink()
	{
		return link;
	}

	public int getGameSpeed()
	{
		return gameSpeed;
	}

	public void setGameSpeed(int gameSpeed)
	{
		this.gameSpeed = gameSpeed;
	}

	public Scene getScene()
	{
		return scene;
	}

	public void setScene (Scene scene)
	{
		this.scene = scene;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}
}

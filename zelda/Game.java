package zelda;

import java.util.ArrayList;

/**
 *
 * @author maartenhus
 */
public class Game
{
	private int gameSpeed = 10;
	private ArrayList<GObject> gameObjects = new ArrayList<GObject>();
	private Link link = new Link(this, 100, 100);

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
}

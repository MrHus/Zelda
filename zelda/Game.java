package zelda;

import java.util.ArrayList;

/**
 *
 * @author maartenhus
 */
public class Game
{
	private ArrayList<GObject> gameObjects = new ArrayList<GObject>();
	private Link link = new Link(100, 100);

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
}

package zelda.engine;

import java.util.ArrayList;

/**
 *
 * @author maartenhus
 */
public abstract class Game
{
	protected int gameSpeed = 10;
	protected int width = 400;
	protected int height = 400;
	protected ArrayList<GObject> gameObjects = new ArrayList<GObject>();
	protected Scene scene;

	public ArrayList<GObject> getGObjects()
	{
		return gameObjects;
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

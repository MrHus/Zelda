package zelda.engine;

/**
 *
 * @author maartenhus
 */
public abstract class Game
{
	protected boolean running = true;
	protected int gameSpeed = 10;
	protected int width = 500;
	protected int height = 400;
	
	protected Scene scene;

	public void quit()
	{
		//do other stuff like stop music.
		System.exit(0);
	}

	public boolean isRunning()
	{
		return running;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
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

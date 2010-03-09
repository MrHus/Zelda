package zelda.engine;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import zelda.Main;

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
	protected Music music;

	public void quit()
	{
		music.stop();

		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException ex){}

		System.exit(0);
	}

	public void playMusic(String mp3file, boolean loop)
	{
		URL mp3 = Main.class.getResource(mp3file);
		music = new Music(this, mp3, loop);
		music.play();
	}

	public void playMusic(URL mp3, boolean loop)
	{
		music = new Music(this, mp3, loop);
		music.play();
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

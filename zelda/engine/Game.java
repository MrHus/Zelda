package zelda.engine;

import java.net.URL;
import zelda.Main;
import zelda.link.Link;
import zelda.scene.HouseScene;
import zelda.scene.HyruleScene;

/**
 * This class represents the Game: Legend of Zelda: a Link to the Past!
 *
 * @author maartenhus
 */
public class Game
{
	private boolean running = true;
	private boolean paused  = false;
	private int gameSpeed = 10;
	private int width = 500;
	private int height = 400;

    private Link link;
	private Scene scene;
	private Music music;
	

	private boolean aPressed = false;
	private boolean sPressed = false;
	private boolean dPressed = false;
	private boolean wPressed = false;
	private boolean jPressed = false;
	private boolean kPressed = false;
	private boolean lPressed = false;

	public Game()
	{
		link = new Link(this, 100, 100);
		scene = new HouseScene(this);
//        scene = new HyruleScene(this);
		scene.initScene();
	}

	public void quit()
	{
		music.stop();

		try
		{
			Thread.sleep(1000); // give it some time to shutdown the music nicely.
		}
		catch (InterruptedException ex){}

		System.exit(0);
	}

	/**
	 * Make the game play music.
	 * 
	 * @param mp3file
	 * @param loop
	 */
	public void playMusic(String mp3file, boolean loop)
	{
		URL mp3 = Main.class.getResource(mp3file);
		music = new Music(this, mp3, loop);
		music.play();
	}

	/**
	 * Make the game play music.
	 * 
	 * @param mp3
	 * @param loop
	 */
	public void playMusic(URL mp3, boolean loop)
	{
		music = new Music(this, mp3, loop);
		music.play();
	}

	public Link getLink()
	{
		return link;
	}

	public boolean isRunning()
	{
		return running;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}

	public boolean isPaused()
	{
		return paused;
	}

	public void setPaused(boolean paused)
	{
		this.paused = paused;
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

	public void setaPressed(boolean aPressed)
	{
		this.aPressed = aPressed;
	}

	public void setdPressed(boolean dPressed)
	{
		this.dPressed = dPressed;
	}

	public void setjPressed(boolean jPressed)
	{
		this.jPressed = jPressed;
	}

	public void setkPressed(boolean kPressed)
	{
		this.kPressed = kPressed;
	}

	public void setlPressed(boolean lPressed)
	{
		this.lPressed = lPressed;
	}

	public void setsPressed(boolean sPressed)
	{
		this.sPressed = sPressed;
	}

	public void setwPressed(boolean wPressed)
	{
		this.wPressed = wPressed;
	}

	public boolean isaPressed()
	{
		return aPressed;
	}

	public boolean isdPressed()
	{
		return dPressed;
	}

	public boolean isjPressed()
	{
		return jPressed;
	}

	public boolean iskPressed()
	{
		return kPressed;
	}

	public boolean islPressed()
	{
		return lPressed;
	}

	public boolean issPressed()
	{
		return sPressed;
	}

	public boolean iswPressed()
	{
		return wPressed;
	}
}

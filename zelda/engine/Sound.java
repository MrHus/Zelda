package zelda.engine;

import java.net.URL;
import javazoom.jl.player.Player;

/**
 *
 * @author maartenhus
 */
public abstract class Sound implements Runnable
{
	protected Game game;
	protected Player player;
	protected Thread th;
	protected URL mp3;

	public Sound(Game game, URL mp3)
	{
		this.game = game;
		this.mp3  = mp3;
		th = new Thread(this, mp3.getFile());
	}

	public void play()
	{
		try
		{
			player = new Player(mp3.openStream());
			th.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public abstract void run();
}

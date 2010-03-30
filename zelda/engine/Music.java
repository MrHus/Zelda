package zelda.engine;

import java.net.URL;
import javazoom.jl.player.Player;

/**
 * This class plays Music.
 *
 * @author maartenhus
 */
public class Music implements Runnable
{
	private Game game;
	private Player player;
	private Thread th = new Thread(this);
	private URL mp3;
	private boolean loop;

	public Music(Game game, URL mp3, boolean loop)
	{
		this.game = game;
		this.loop = loop;
		this.mp3 = mp3;
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

	public void run()
	{
		while (!player.isComplete()) // if song is not over
		{
			try
			{
				player.play();
				Thread.sleep(1000);
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}

		if (loop) //if song is over but its on a loop replay the song.
		{
			game.playMusic(mp3, true);
		}
	}

	public void stop()
	{
		player.close();
	}
}

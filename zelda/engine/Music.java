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
	private String songname = "";
	private boolean loop;

	public Music(Game game, URL mp3, String songname, boolean loop)
	{
		this.game = game;
		this.loop = loop;
		this.mp3 = mp3;
		this.songname = songname;
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
			game.playMusic(songname, true);
		}
	}

	public void stop()
	{
		player.close();
	}

	public String getSong()
	{
		return songname;
	}
}

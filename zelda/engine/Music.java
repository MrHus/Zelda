package zelda.engine;

import java.net.URL;

/**
 * This class plays Music.
 *
 * @author maartenhus
 */
public class Music extends Sound
{
	private String songname = "";
	private boolean loop;

	public Music(Game game, URL mp3, String songname, boolean loop)
	{
		super(game, mp3);

		this.loop = loop;
		this.songname = songname;
	}

	public void run()
	{
		while (!player.isComplete()) // if song is not over
		{
			try
			{
				player.play();
				Thread.sleep(10);
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}

		if (loop) //if song is over but its on a loop replay the song.
		{
			game.playFx(songname);
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

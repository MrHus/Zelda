package zelda.engine;

import java.net.URL;
import javazoom.jl.player.Player;
import zelda.Main;

public class Music implements Runnable
{

	private Player player;
	private Thread th = new Thread(this);
	private URL mp3;
	private boolean play = true;
	private boolean loop;

	public Music(URL mp3, boolean loop)
	{
		this.loop = loop;
		this.mp3 = mp3;
	}

	public Music(String mp3file, boolean loop)
	{
		this.loop = loop;
		mp3 = Main.class.getResource(mp3file);
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
		while (play)
		{
			if (!player.isComplete())
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
			else
			{
				if (loop)
				{
					stop();
					Music music = new Music(mp3, true);
					music.play();
				}
			}
		}
	}

	public void stop()
	{
		play = false;
	}
}

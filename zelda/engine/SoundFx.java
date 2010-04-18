package zelda.engine;

import java.net.URL;

/**
 *
 * @author maartenhus
 */
public class SoundFx extends Sound
{
	public SoundFx(Game game, URL mp3)
	{
		super(game, mp3);
	}

	public void run()
	{
		while (!player.isComplete()) // if song is not over
		{
			try
			{
				player.play();
				Thread.sleep(100);
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
	}
}

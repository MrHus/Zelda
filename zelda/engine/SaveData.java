package zelda.engine;

import java.io.Serializable;
import zelda.link.Link;

/**
 *
 * @author maartenhus
 */
public class SaveData implements Serializable
{
	private int health;
	private int rupee;

	private String sceneName;

	public SaveData(Link link, Scene scene)
	{
		health = link.getHealth();
		rupee = link.getRupee();

		sceneName = scene.getName();
	}
	
	public int getHealth()
	{
		return health;
	}

	public int getRupee()
	{
		return rupee;
	}

	public String getSceneName()
	{
		return sceneName;
	}
}

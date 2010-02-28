package zelda;

import zelda.engine.Game;
import zelda.link.Link;
import zelda.scene.HouseScene;

/**
 *
 * @author maartenhus
 */
public class ZeldaGame extends Game
{
	private Link link = new Link(this, 100, 100);

	public ZeldaGame()
	{
		scene = new HouseScene(this);
		gameObjects.add(link);
	}

	public Link getLink()
	{
		return link;
	}
}

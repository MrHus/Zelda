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
	private Link link;

	public ZeldaGame()
	{
		link = new Link(this, 100, 100);
		scene = new HouseScene(this);

		scene.initScene();
	}

	public Link getLink()
	{
		return link;
	}
}

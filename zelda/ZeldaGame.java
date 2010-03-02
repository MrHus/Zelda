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
		scene = new HouseScene(this);
		link = new Link(this, 100, 100);

		scene.initScene();
		scene.addGObject(link);
	}

	public Link getLink()
	{
		return link;
	}
}

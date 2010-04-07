package zelda.link;

import zelda.engine.Game;
import zelda.karacter.KaracterState;

/**
 * Superclass for link's state.
 * 
 * @author maartenhus
 */
public class LinkState extends KaracterState
{
	protected Link link;
	protected Game game;

	public LinkState(Link link)
	{
		super(link);
		this.link = link;
		this.game = link.getGame();
	}
}

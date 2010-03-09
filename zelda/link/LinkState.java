package zelda.link;

import zelda.karacter.KaracterState;

/**
 *
 * @author maartenhus
 */
public class LinkState extends KaracterState
{
	protected Link link;

	public LinkState(Link link)
	{
		super(link);
		this.link = link;
	}
}

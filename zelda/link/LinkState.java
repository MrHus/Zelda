package zelda.link;

/**
 *
 * @author maartenhus
 */
public abstract class LinkState
{
	protected Link link;
	protected String name;

	public LinkState(Link link)
	{
		this.link = link;
		link.resetAnimationCounter();
	}

	public void handleInput(){};
	public void handleAnimation(){};

	@Override
	public String toString()
	{
		return name;
	}
}

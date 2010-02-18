package zelda;

/**
 *
 * @author maartenhus
 */
public abstract class LinkState
{
	protected Link link;

	public LinkState(Link link)
	{
		this.link = link;
		link.resetAnimationCounter();
	}

	public void handleAnimation(){}
	public abstract void handleInput();
}

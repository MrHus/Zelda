package zelda.link;

/**
 *
 * @author maartenhus
 */
public class StandState extends LinkState
{
	private static String[] downAnimation	= {"Link stand down"};
	private static String[] upAnimation		= {"Link stand up"};
	private static String[] leftAnimation	= {"Link stand left"};
	private static String[] rightAnimation	= {"Link stand right"};

	public StandState(Link link)
	{
		super(link);

		switch (link.getDirection())
		{
			case UP:
				link.setAnimation(upAnimation);
				break;

			case DOWN:
				link.setAnimation(downAnimation);
				break;

			case LEFT:
				link.setAnimation(leftAnimation);
				break;

			case RIGHT:
				link.setAnimation(rightAnimation);
				break;
		}
	}

	@Override
	public void handleAnimation()
	{
		if (link.isjPressed())
		{
			link.setState(new SwordState(link));
		}
		else
		{
			if (link.moveinput())
				link.setState(new WalkState(link));
		}
	}
}

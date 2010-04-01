package zelda.link;

/**
 * State for when link is standing still.
 *
 * @author maartenhus
 */
public class StandState extends LinkState
{
	private final static String[] downAnimation	= {"Link stand down"};
	private final static String[] upAnimation	= {"Link stand up"};
	private final static String[] leftAnimation	= {"Link stand left"};
	private final static String[] rightAnimation= {"Link stand right"};

	public StandState(Link link)
	{
		super(link);
		name = "StandState";

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
	public void handleInput()
	{
		if (link.isjPressed())
		{
			link.setState(new SwordState(link));
		}
        else if(link.islPressed())
        {
            link.setState(new BombState(link));
        }
		else
		{
			if (link.moveinput())
				link.setState(new WalkState(link));
		}
	}
}

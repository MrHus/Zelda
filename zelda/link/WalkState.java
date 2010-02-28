package zelda.link;

import zelda.character.Direction;

/**
 *
 * @author maartenhus
 */
public class WalkState extends LinkState
{
	private static String[] downAnimation = {"Link walk down 1", "Link walk down 2", "Link walk down 3", "Link walk down 6", "Link walk down 5", "Link walk down 4"};
	private static String[] upAnimation   = {"Link walk up 3", "Link walk up 2", "Link walk up 1", "Link walk up 4", "Link walk up 6", "Link walk up 5"};
	private static String[] leftAnimation   = {"Link walk left 3", "Link walk left 2", "Link walk left 1", "Link walk left 4", "Link walk left 5", "Link walk left 6"};
	private static String[] rightAnimation   = {"Link walk right 3", "Link walk right 2", "Link walk right 1", "Link walk right 4", "Link walk right 5", "Link walk right 6"};
	private static int WALK_SPEED = 4;

	public WalkState(Link link)
	{
		super(link);
		name = "WalksState";
	}

	@Override
	public void handleInput()
	{
		if(link.isjPressed())
		{
			link.setState(new SwordState(link));
		}
		else
		{
			if (link.noMoveinput())
			{
				link.setState(new StandState(link));
			}
			else
			{
				if (link.isaPressed())
					left();

				if (link.isdPressed())
					right();

				if (link.iswPressed())
					up();

				if (link.issPressed())
					down();
			}
		}
	}

	private void left()
	{
		if(link.getAnimation() != leftAnimation)
			link.setAnimation(leftAnimation);

		if(link.getDirection() != Direction.LEFT)
			link.setDirection(Direction.LEFT);

		link.setX(link.getX() - WALK_SPEED);
	}

	private void right()
	{
		if(link.getAnimation() != rightAnimation)
			link.setAnimation(rightAnimation);

		if(link.getDirection() != Direction.RIGHT)
			link.setDirection(Direction.RIGHT);

		link.setX(link.getX() + WALK_SPEED);
	}

	private void up()
	{
		if(link.getAnimation() != upAnimation)
			link.setAnimation(upAnimation);

		if(link.getDirection() != Direction.UP)
			link.setDirection(Direction.UP);

		link.setY(link.getY() - WALK_SPEED);
	}

	private void down()
	{
		if(link.getAnimation() != downAnimation)
			link.setAnimation(downAnimation);

		if(link.getDirection() != Direction.DOWN)
			link.setDirection(Direction.DOWN);

		link.setY(link.getY() + WALK_SPEED);
	}
}

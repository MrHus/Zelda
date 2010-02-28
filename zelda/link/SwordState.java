package zelda.link;

import zelda.character.Direction;

/**
 *
 * @author maartenhus
 */
public class SwordState extends LinkState
{
	private static String[] downAnimation	= {"Link sword down 1", "Link sword down 2", "Link sword down 3", "Link sword down 4", "Link sword down 5", "Link sword down 6"};
	private static String[] upAnimation		= {"Link sword up 1", "Link sword up 2", "Link sword up 3", "Link sword up 4", "Link sword up 5", "Link sword up 6", "Link sword up 7", "Link sword up 8", "Link sword up 9"};
	private static String[] leftAnimation	= {"Link sword left 1", "Link sword left 2", "Link sword left 3", "Link sword left 4", "Link sword left 5", "Link sword left 6", "Link sword left 7", "Link sword left 8", "Link sword left 9"};
	private static String[] rightAnimation	= {"Link sword right 1", "Link sword right 2", "Link sword right 3", "Link sword right 4", "Link sword right 5", "Link sword right 6", "Link sword right 7", "Link sword right 8"};

	private int oldX, oldY;
	private long oldAnimationInterval;

	public SwordState(Link link)
	{
		super(link);
		name = "SwordState";

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

		oldX = link.getX();
		oldY = link.getY();
		oldAnimationInterval = link.getAnimationInterval();

		if(link.getDirection() == Direction.DOWN)
		{
			link.setAnimationInterval(20);
		}
		else
		{
			link.setAnimationInterval(10);
		}
	}

	@Override
	public void handleAnimation()
	{
		int animationCounter = link.getAnimationCounter();

		//System.out.println("Animation Counter is " + animationCounter);

		//sword is done swinging revert back to former state
		if (animationCounter == link.getAnimation().length)
		{
			link.setY(oldY);
			link.setX(oldX);
			link.setAnimationInterval(oldAnimationInterval);
			link.setState(new StandState(link));
		}
		else
		{
			// This section of the code corrects the position of link when he's striking.
			// If you don't do this link appears to be moving when he swings his sword.
			// Go ahead and remove the entire body of this else statement. You'll see what i mean.

			Direction dir = link.getDirection();

			if (dir == Direction.UP)
			{
				switch(animationCounter)
				{
					case 0:
						link.setY(link.getY() + 1);
						break;

					case 2:
						link.setY(link.getY() - 2);
						break;

					case 3:
						link.setY(link.getY() - 6);
						break;

					case 4:
						link.setY(link.getY() - 1);
						break;

					case 6:
						link.setY(link.getY() + 2);
						link.setX(link.getX() - 4);
						break;

					case 7:
						link.setY(link.getY() + 2);
						link.setX(link.getX() - 6);
						break;

					case 8:
						link.setY(link.getY() + 3);
						link.setX(link.getX() - 2);
						break;
				}
			}
			else if (dir == Direction.LEFT)
			{
				switch(animationCounter)
				{
					case 0:
						link.setY(link.getY() - 1);
						link.setX(link.getX() + 3);
						break;

					case 1:
						link.setX(link.getX() - 2);
						break;

					case 2:
						link.setY(link.getY() - 1);
						link.setX(link.getX() - 5);
						break;

					case 3:
						link.setX(link.getX() - 2);
						break;

					case 4:
						link.setY(link.getY() + 2);
						link.setX(link.getX() - 4);
						break;

					case 6:
						link.setX(link.getX() + 1);
						break;

					case 8:
						link.setX(link.getX() + 6);
						break;
				}
			}
			else if(dir == Direction.DOWN)
			{
				switch(animationCounter)
				{
					case 0:
						link.setX(link.getX() - 4);
						break;

					case 1:
						link.setX(link.getX() - 1);
						break;

					case 2:
						link.setX(link.getX() + 1);
						break;
				}
			}
		}
	}
}

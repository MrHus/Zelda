package zelda.link;

import java.awt.Rectangle;
import zelda.karacter.Direction;

/**
 * State for when link is using the bow.
 *
 * @author frankie
 */
public class BowState extends LinkState
{
	private final static String[] downAnimation	= {"Link bow down 1", "Link bow down 2","Link bow down 3"};
	private final static String[] upAnimation	= {"Link bow up 1", "Link bow up 2","Link bow up 3"};
	private final static String[] leftAnimation	= {"Link bow left 1", "Link bow left 2","Link bow left 3"};
	private final static String[] rightAnimation= {"Link bow right 1", "Link bow right 2"};

    private Rectangle bow;

	private int oldX, oldY;
	private long oldAnimationInterval;

	public BowState(Link link)
	{
		super(link);
		name = "BowState";

        oldX = link.getX();
		oldY = link.getY();
		oldAnimationInterval = link.getAnimationInterval();
		link.setCheckcollision(false);

		switch (link.getDirection())
		{
			case UP:
				link.setAnimation(upAnimation);
                link.setAnimationInterval(20);
				bow = new Rectangle(oldX - 10, oldY - 10, 30, 10);
				break;

			case DOWN:
				link.setAnimation(downAnimation);
                link.setAnimationInterval(30);
				bow = new Rectangle(oldX, oldY + link.getHeight(), 25, 10);
				break;

			case LEFT:
				link.setAnimation(leftAnimation);
                link.setAnimationInterval(20);
				bow = new Rectangle(oldX - 10, oldY, 20, 30);
				break;

			case RIGHT:
				link.setAnimation(rightAnimation);
                link.setAnimationInterval(20);
				bow = new Rectangle(oldX + link.getWidth(), oldY, 13, 28);
				break;
		}
	}

    public Rectangle getBow()
	{
		return bow;
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
			link.setCheckcollision(true);
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


	@Override
	public void handleInput()
	{
		if (game.iskPressed())
		{
			link.setState(new BowState(link));
		}
		else
		{
			if (link.moveinput())
				link.setState(new WalkState(link));
		}
	}
}
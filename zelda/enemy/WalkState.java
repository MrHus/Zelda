package zelda.enemy;

import zelda.karacter.Direction;
import zelda.karacter.KaracterState;

/**
 *
 * @author maartenhus
 */
public class WalkState extends KaracterState
{
	private final String[] downAnimation	= {"Stand down", "Walk down 1", "Walk down 2", "Walk down 3"};
	private final String[] upAnimation		= {"Stand up", "Walk up 1", "Walk up 2"};
	private final String[] leftAnimation	= {"Stand left", "Walk left 1", "Walk left 2"};
	private final String[] rightAnimation	= {"Stand right", "Walk right 1", "Walk right 2"};
	
	private final static int WALK_SPEED = 2;
	private int oldX, oldY;
	private long oldAnimationInterval;

    private BlueSoldier soldier;

    public WalkState(BlueSoldier soldier)
	{
		super(soldier);
		name = "WalkState";

        oldAnimationInterval = karacter.getAnimationInterval();

        //karacter.setAnimationInterval(1000);
    }

	@Override
	public void handleInput()
	{
		switch (karacter.getDirection())
		{
			case UP:
                up();
				break;

			case DOWN:
                down();
                break;

			case LEFT:
				left();
                break;

			case RIGHT:
                right();
                break;
		}
	}

	public void left()
	{
		if (karacter.getAnimation() != leftAnimation)
		{
			karacter.setAnimation(leftAnimation);
		}

		if (karacter.getDirection() != Direction.LEFT)
		{
			karacter.setDirection(Direction.LEFT);
		}

		karacter.setX(karacter.getX() - WALK_SPEED);
	}

	public void right()
	{
		if (karacter.getAnimation() != rightAnimation)
		{
			karacter.setAnimation(rightAnimation);
		}

		if (karacter.getDirection() != Direction.RIGHT)
		{
			karacter.setDirection(Direction.RIGHT);
		}

		karacter.setX(karacter.getX() + WALK_SPEED);
	}

	public void up()
	{
		if (karacter.getAnimation() != upAnimation)
		{
			karacter.setAnimation(upAnimation);
		}

		if (karacter.getDirection() != Direction.UP)
		{
			karacter.setDirection(Direction.UP);
		}

		karacter.setY(karacter.getY() - WALK_SPEED);
	}

	public void down()
	{
		if (karacter.getAnimation() != downAnimation)
		{
			karacter.setAnimation(downAnimation);
		}

		if (karacter.getDirection() != Direction.DOWN)
		{
			karacter.setDirection(Direction.DOWN);
		}

		karacter.setY(karacter.getY() + WALK_SPEED);
	}

    @Override
	public void handleAnimation()
	{
		int animationCounter = karacter.getAnimationCounter();

        // This section of the code corrects the position of karacter when he's striking.
        // If you don't do this karacter appears to be moving when he swings his sword.
        // Go ahead and remove the entire body of this else statement. You'll see what i mean.

        Direction dir = karacter.getDirection();


			if (dir == Direction.UP)
			{
				switch (animationCounter)
				{
                    case 0:
						karacter.setY(karacter.getY() + 0);
						break;

					case 1:
						karacter.setY(karacter.getY() + 1);
						break;

                    case 2:
						karacter.setY(karacter.getY() - 7);
                        //karacter.setX(karacter.getX() + 3);
						break;
				}
			}
			else if (dir == Direction.LEFT)
			{
				switch (animationCounter)
				{
                    case 0:
						karacter.setX(karacter.getX() - 0);
						break;

					case 1:
						karacter.setX(karacter.getX() - 5);
						break;

                    case 2:
						karacter.setX(karacter.getX() + 4);
						break;
				}
			}
		}
}

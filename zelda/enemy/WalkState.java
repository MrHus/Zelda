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
	private final static int WALK_SPEED	= 2;

	public WalkState(BlueSoldier soldier)
	{
		super(soldier);
		name = "WalkState";
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
		if(karacter.getAnimation() != leftAnimation)
			karacter.setAnimation(leftAnimation);

		if(karacter.getDirection() != Direction.LEFT)
			karacter.setDirection(Direction.LEFT);

		karacter.setX(karacter.getX() - WALK_SPEED);
	}

	public void right()
	{
		if(karacter.getAnimation() != rightAnimation)
			karacter.setAnimation(rightAnimation);

		if(karacter.getDirection() != Direction.RIGHT)
			karacter.setDirection(Direction.RIGHT);

		karacter.setX(karacter.getX() + WALK_SPEED);
	}

	public void up()
	{
		if(karacter.getAnimation() != upAnimation)
			karacter.setAnimation(upAnimation);

		if(karacter.getDirection() != Direction.UP)
			karacter.setDirection(Direction.UP);

		karacter.setY(karacter.getY() - WALK_SPEED);
	}

	public void down()
	{
		if(karacter.getAnimation() != downAnimation)
			karacter.setAnimation(downAnimation);

		if(karacter.getDirection() != Direction.DOWN)
			karacter.setDirection(Direction.DOWN);

		karacter.setY(karacter.getY() + WALK_SPEED);
	}
}

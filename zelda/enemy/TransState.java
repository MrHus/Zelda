package zelda.enemy;

import zelda.karacter.Direction;
import zelda.karacter.Karacter;
import zelda.karacter.KaracterState;

/**
 *
 * @author vincentklarholz
 */
public class TransState extends KaracterState
{
    private final static String[] downAnimation	= {"Stand down", "Stand down", "Stand down", "Stand down", "Stand down", "Stand down", "Stand down", "Stand down", "Stand down", "Stand down"};
	private final static String[] upAnimation	= {"Stand up", "Stand up", "Stand up", "Stand up", "Stand up", "Stand up", "Stand up", "Stand up", "Stand up", "Stand up"};
	private final static String[] leftAnimation	= {"Stand left", "Stand left", "Stand left", "Stand left", "Stand left", "Stand left", "Stand left", "Stand left", "Stand left", "Stand left"};
	private final static String[] rightAnimation= {"Stand right", "Stand right", "Stand right", "Stand right", "Stand right", "Stand right", "Stand right", "Stand right", "Stand right", "Stand right"};

    private Direction direction;

    public TransState(Karacter soldier, Direction direction)
    {
        super(soldier);
		name = "TransState";
        karacter.setAnimationInterval(40);

        this.direction = direction;
    }

    public void left()
	{
        karacter.setAnimation(leftAnimation);
		karacter.setX(karacter.getX() + 4);
	}

	public void right()
	{
        karacter.setAnimation(rightAnimation);
		karacter.setX(karacter.getX() - 4);
	}

	public void up()
	{
        karacter.setAnimation(upAnimation);
        karacter.setY(karacter.getY() + 4);
	}

	public void down()
	{
        karacter.setAnimation(downAnimation);
		karacter.setY(karacter.getY() - 4);
	}

    @Override
	public void handleAnimation()
	{
		int animationCounter = karacter.getAnimationCounter();

        if (animationCounter == karacter.getAnimation().length)
		{
            karacter.setAnimationInterval(90);
            karacter.setState(new WalkState(karacter));
        }

        switch (direction)
        {
            case UP:
                down();
                break;

            case DOWN:
                up();
                break;

            case LEFT:
                right();
                break;

            case RIGHT:
                left();
                break;
        }
    }
}

package zelda.enemy.armos;

import zelda.karacter.Direction;
import zelda.karacter.Karacter;
import zelda.karacter.KaracterState;

/**
 *
 * @author vincentklarholz
 */
public class TransState extends KaracterState
{
     private final String[] animation = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private Direction direction;

    public TransState(Karacter armosKnight, Direction direction)
    {
        super(armosKnight);
		name = "TransState";
        karacter.setAnimationInterval(10);

        this.direction = direction;
    }

    public void left()
	{
        karacter.setAnimation(animation);
		karacter.setX(karacter.getX() + 4);
	}

	public void right()
	{
        karacter.setAnimation(animation);
		karacter.setX(karacter.getX() - 4);
	}

	public void up()
	{
        karacter.setAnimation(animation);
        karacter.setY(karacter.getY() + 4);
	}

	public void down()
	{
        karacter.setAnimation(animation);
		karacter.setY(karacter.getY() - 4);
	}

    @Override
	public void handleAnimation()
	{
		int animationCounter = karacter.getAnimationCounter();

        if (animationCounter == karacter.getAnimation().length)
		{
            karacter.setAnimationInterval(90);
            karacter.setState(new AttackState(karacter));
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

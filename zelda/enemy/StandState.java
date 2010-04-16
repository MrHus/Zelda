package zelda.enemy;

import zelda.karacter.Direction;
import zelda.karacter.Karacter;
import zelda.karacter.KaracterState;

/**
 *
 * @author maartenhus
 */
public class StandState extends KaracterState
{
	private final static String[] downAnimation	= {"Stand down"};
	private final static String[] upAnimation	= {"Stand up"};
	private final static String[] leftAnimation	= {"Stand left"};
	private final static String[] rightAnimation= {"Stand right"};

	private Direction oldDirection;;

	public StandState(Karacter soldier)
	{
		super(soldier);
		name = "StandState";

		oldDirection = soldier.getDirection();

		switch (oldDirection)
		{
			case UP:
				soldier.setAnimation(upAnimation);
				break;

			case DOWN:
				soldier.setAnimation(downAnimation);
				break;

			case LEFT:
				soldier.setAnimation(leftAnimation);
				break;

			case RIGHT:
				soldier.setAnimation(rightAnimation);
				break;
		}
	}

	@Override
	public void handleInput()
	{
		//System.out.println("oldDirection " + oldDirection + " new " + karacter.getDirection());
		if (oldDirection != karacter.getDirection())
        {
            karacter.setState(new WalkState(karacter));
        }
	}
}

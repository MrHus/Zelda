package zelda.enemy;

import zelda.karacter.Direction;

/**
 *
 * @author maartenhus
 */
public class PatrolBehavior extends Behavior
{

	private BlueSoldier soldier;
	private int ticks = 0;
	private int max;
	private int step = 1;

	public PatrolBehavior(BlueSoldier soldier, int ticks)
	{
		this.soldier = soldier;

		
		this.max = ticks;

		move();
	}

	public void behave()
	{
		System.out.println(ticks);

		if (soldier.getStateString().equals("WalkState"))
		{
			ticks += step;

			if (ticks > max)
			{
				move();
				ticks = -1;
			}
		}
	}

	private void move()
	{
		switch (soldier.getDirection())
		{
			case UP:
				soldier.setDirection(Direction.DOWN);
				break;

			case DOWN:
				soldier.setDirection(Direction.UP);
				break;

			case LEFT:
				soldier.setDirection(Direction.RIGHT);
				
				break;

			case RIGHT:
				soldier.setDirection(Direction.LEFT);
				break;
		}
	}
}

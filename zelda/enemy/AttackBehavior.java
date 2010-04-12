package zelda.enemy;

import zelda.karacter.Direction;

/**
 *
 * @author vincentklarholz
 */
public class AttackBehavior extends Behavior {

    private BlueSoldier soldier;
	private int ticks = 0;
	private int max;
	private int step = 1;

	public AttackBehavior(BlueSoldier soldier, int ticks)
	{
		this.soldier = soldier;
		this.max = ticks;
		move();
	}

	public void behave()
	{

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

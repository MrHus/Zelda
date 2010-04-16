package zelda.enemy;

import java.awt.Polygon;
import java.awt.geom.Area;
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

    private Polygon eyeView;
    protected Behavior behavior;

	public PatrolBehavior(BlueSoldier soldier, int ticks)
	{
		this.soldier = soldier;
		this.max = ticks;
		move();
	}

	public void behave()
	{
        soldier.getGame().getScene().removeEyeView(eyeView);

        switch (soldier.getDirection())
		{
			case UP:
                int[] evxposup = {soldier.getX(), soldier.getX() - 30, soldier.getX() - 20, soldier.getX() + 35, soldier.getX() + 45, soldier.getX() + 15};
                int[] evyposup = {soldier.getY(), soldier.getY() - 40, soldier.getY() - 50, soldier.getY() - 50, soldier.getY() - 40, soldier.getY()};
                eyeView = new Polygon(evxposup, evyposup, evxposup.length);
                soldier.getGame().getScene().addEyeView(eyeView);
				break;

			case DOWN:
                int[] evxposdown = {soldier.getX(), soldier.getX() - 30, soldier.getX() - 20, soldier.getX() + 35, soldier.getX() + 45, soldier.getX() + 15};
                int[] evyposdown = {soldier.getY() + soldier.getHeight(), soldier.getY() + soldier.getHeight() + 40, soldier.getY() + soldier.getHeight() + 50, soldier.getY() + soldier.getHeight() + 50, soldier.getY() + soldier.getHeight() + 40, soldier.getY() + soldier.getHeight()};
                eyeView = new Polygon(evxposdown, evyposdown, evxposdown.length);
                soldier.getGame().getScene().addEyeView(eyeView);
                break;

			case LEFT:
                int[] evxposleft = {soldier.getX(), soldier.getX() - 40, soldier.getX() - 50, soldier.getX() - 50, soldier.getX() - 40, soldier.getX()};
                int[] evyposleft = {soldier.getY() + 20 , soldier.getY() + 50, soldier.getY() + 40, soldier.getY() - 15, soldier.getY() - 25, soldier.getY() + 5};
                eyeView = new Polygon(evxposleft, evyposleft, evxposleft.length);
                soldier.getGame().getScene().addEyeView(eyeView);
                break;

			case RIGHT:
                int[] evxposright = {soldier.getX() + soldier.getWidth(), soldier.getX() + soldier.getWidth() + 40, soldier.getX() + soldier.getWidth() + 50, soldier.getX() + soldier.getWidth() + 50, soldier.getX() + soldier.getWidth() + 40, soldier.getX() + soldier.getWidth()};
                int[] evyposright = {soldier.getY() + 20, soldier.getY() + 50, soldier.getY() + 40, soldier.getY() - 15, soldier.getY() - 25, soldier.getY() + 5};
                eyeView = new Polygon(evxposright, evyposright, evxposright.length);
                soldier.getGame().getScene().addEyeView(eyeView);
                break;
		}

        final Area area = new Area();
        area.add(new Area(eyeView));
        area.intersect(new Area(soldier.getGame().getLink().getRectangle()));

        if(!area.isEmpty())
        {
            soldier.setBehavior(new AttackBehavior(soldier));
        }

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

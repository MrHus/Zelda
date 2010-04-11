package zelda.enemy;

import java.awt.Polygon;
import java.awt.geom.Area;
import zelda.engine.GObject;
import zelda.karacter.Direction;
import zelda.karacter.KaracterState;
import zelda.link.Link;

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

	private Direction oldDirection;
	private BlueSoldier soldier;

    private Polygon eyeView;
    private int oldX, oldY;

	public StandState(BlueSoldier soldier)
	{
		super(soldier);
		this.soldier = soldier;
		name = "StandState";

		oldDirection = soldier.getDirection();

        oldX = karacter.getX();
        oldY = karacter.getY();

		switch (oldDirection)
		{
			case UP:
				soldier.setAnimation(upAnimation);
                int[] evxposup = {oldX, oldX - 30, oldX - 20, oldX + 35, oldX + 45, oldX + 15};
                int[] evyposup = {oldY, oldY - 40, oldY - 50, oldY - 50, oldY - 40, oldY};
                eyeView = new Polygon(evxposup, evyposup, evxposup.length);
				break;

			case DOWN:
				soldier.setAnimation(downAnimation);
                int[] evxposdown = {oldX, oldX - 30, oldX - 20, oldX + 35, oldX + 45, oldX + 15};
                int[] evyposdown = {oldY + karacter.getHeight(), oldY + karacter.getHeight() + 40, oldY + karacter.getHeight() + 50, oldY + karacter.getHeight() + 50, oldY + karacter.getHeight() + 40, oldY + karacter.getHeight()};
                eyeView = new Polygon(evxposdown, evyposdown, evxposdown.length);
				break;

			case LEFT:
				soldier.setAnimation(leftAnimation);
                int[] evxposleft = {oldX, oldX - 40, oldX - 50, oldX - 50, oldX - 40, oldX};
                int[] evyposleft = {oldY + 20 , oldY + 50, oldY + 40, oldY - 15, oldY - 25, oldY + 5};
                eyeView = new Polygon(evxposleft, evyposleft, evxposleft.length);
				break;

			case RIGHT:
				soldier.setAnimation(rightAnimation);
                int[] evxposright = {oldX + karacter.getWidth(), oldX + karacter.getWidth() + 40, oldX + karacter.getWidth() + 50, oldX + karacter.getWidth() + 50, oldX + karacter.getWidth() + 40, oldX + karacter.getWidth()};
                int[] evyposright = {oldY + 20, oldY + 50, oldY + 40, oldY - 15, oldY - 25, oldY + 5};
                eyeView = new Polygon(evxposright, evyposright, evxposright.length);
				break;
		}


	}

	@Override
	public void handleInput()
	{
        for (GObject obj : soldier.getGame().getScene().getGObjects())
		{
            final Area area = new Area();
            area.add(new Area(eyeView));
            area.intersect(new Area(obj.getRectangle()));

            if((obj instanceof Link) && !area.isEmpty())
            {
                System.out.println("Link was seen");
            }
		}

		//System.out.println("oldDirection " + oldDirection + " new " + karacter.getDirection());
		if (oldDirection != karacter.getDirection())
        {
            karacter.setState(new WalkState(soldier));
        }
	}
}

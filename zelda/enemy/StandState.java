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
                int[] evxposup = {karacter.getX(), karacter.getX() - 30, karacter.getX() - 20, karacter.getX() + 35, karacter.getX() + 45, karacter.getX() + 15};
                int[] evyposup = {karacter.getY(), karacter.getY() - 40, karacter.getY() - 50, karacter.getY() - 50, karacter.getY() - 40, karacter.getY()};
                eyeView = new Polygon(evxposup, evyposup, evxposup.length);
				break;

			case DOWN:
				soldier.setAnimation(downAnimation);
                int[] evxposdown = {karacter.getX(), karacter.getX() - 30, karacter.getX() - 20, karacter.getX() + 35, karacter.getX() + 45, karacter.getX() + 15};
                int[] evyposdown = {karacter.getY() + karacter.getHeight(), karacter.getY() + karacter.getHeight() + 40, karacter.getY() + karacter.getHeight() + 50, karacter.getY() + karacter.getHeight() + 50, karacter.getY() + karacter.getHeight() + 40, karacter.getY() + karacter.getHeight()};
                eyeView = new Polygon(evxposdown, evyposdown, evxposdown.length);
				break;

			case LEFT:
				soldier.setAnimation(leftAnimation);
                int[] evxposleft = {karacter.getX(), karacter.getX() - 40, karacter.getX() - 50, karacter.getX() - 50, karacter.getX() - 40, karacter.getX()};
                int[] evyposleft = {karacter.getY() + 20 , karacter.getY() + 50, karacter.getY() + 40, karacter.getY() - 15, karacter.getY() - 25, karacter.getY() + 5};
                eyeView = new Polygon(evxposleft, evyposleft, evxposleft.length);
				break;

			case RIGHT:
				soldier.setAnimation(rightAnimation);
                int[] evxposright = {karacter.getX() + karacter.getWidth(), karacter.getX() + karacter.getWidth() + 40, karacter.getX() + karacter.getWidth() + 50, karacter.getX() + karacter.getWidth() + 50, karacter.getX() + karacter.getWidth() + 40, karacter.getX() + karacter.getWidth()};
                int[] evyposright = {karacter.getY() + 20, karacter.getY() + 50, karacter.getY() + 40, karacter.getY() - 15, karacter.getY() - 25, karacter.getY() + 5};
                eyeView = new Polygon(evxposright, evyposright, evxposright.length);
				break;
		}
	}

	@Override
	public void handleInput()
	{
        //Add Eye View
        soldier.getGame().getScene().addEyeView(eyeView);
        
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
            soldier.getGame().getScene().removeEyeView(eyeView);
        }
	}
}

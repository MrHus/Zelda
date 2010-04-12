package zelda.enemy;

import java.awt.Polygon;
import java.awt.geom.Area;
import zelda.collision.Weapon;
import zelda.engine.GObject;
import zelda.karacter.Direction;
import zelda.karacter.KaracterState;
import zelda.link.Link;

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

    private BlueSoldier soldier;
    
    private int oldX, oldY;
    private long oldAnimationInterval;

    private Polygon eyeView;

    public WalkState(BlueSoldier soldier)
	{
		super(soldier);
		name = "WalkState";

        oldX = karacter.getX();
		oldY = karacter.getY();
        oldAnimationInterval = karacter.getAnimationInterval();    
	}

	@Override
	public void handleInput()
	{
        karacter.getGame().getScene().removeEyeView(eyeView);

		switch (karacter.getDirection())
		{
			case UP:
                int[] evxposup = {karacter.getX(), karacter.getX() - 30, karacter.getX() - 20, karacter.getX() + 35, karacter.getX() + 45, karacter.getX() + 15};
                int[] evyposup = {karacter.getY(), karacter.getY() - 40, karacter.getY() - 50, karacter.getY() - 50, karacter.getY() - 40, karacter.getY()};
                eyeView = new Polygon(evxposup, evyposup, evxposup.length);
                up();
				break;

			case DOWN:
                int[] evxposdown = {karacter.getX(), karacter.getX() - 30, karacter.getX() - 20, karacter.getX() + 35, karacter.getX() + 45, karacter.getX() + 15};
                int[] evyposdown = {karacter.getY() + karacter.getHeight(), karacter.getY() + karacter.getHeight() + 40, karacter.getY() + karacter.getHeight() + 50, karacter.getY() + karacter.getHeight() + 50, karacter.getY() + karacter.getHeight() + 40, karacter.getY() + karacter.getHeight()};
                eyeView = new Polygon(evxposdown, evyposdown, evxposdown.length);
                down();
                break;

			case LEFT:
                int[] evxposleft = {karacter.getX(), karacter.getX() - 40, karacter.getX() - 50, karacter.getX() - 50, karacter.getX() - 40, karacter.getX()};
                int[] evyposleft = {karacter.getY() + 20 , karacter.getY() + 50, karacter.getY() + 40, karacter.getY() - 15, karacter.getY() - 25, karacter.getY() + 5};
                eyeView = new Polygon(evxposleft, evyposleft, evxposleft.length);
				left();
                break;

			case RIGHT:
                int[] evxposright = {karacter.getX() + karacter.getWidth(), karacter.getX() + karacter.getWidth() + 40, karacter.getX() + karacter.getWidth() + 50, karacter.getX() + karacter.getWidth() + 50, karacter.getX() + karacter.getWidth() + 40, karacter.getX() + karacter.getWidth()};
                int[] evyposright = {karacter.getY() + 20, karacter.getY() + 50, karacter.getY() + 40, karacter.getY() - 15, karacter.getY() - 25, karacter.getY() + 5};
                eyeView = new Polygon(evxposright, evyposright, evxposright.length);
				right();
                break;
		}

        for (GObject obj : karacter.getGame().getScene().getGObjects())
		{
            final Area area = new Area();
            area.add(new Area(eyeView));
            area.intersect(new Area(obj.getRectangle()));

            if((obj instanceof Link) && !area.isEmpty())
            {
                System.out.println("Link was seen");
            }
		}
	}

	public void left()
	{
		if(karacter.getAnimation() != leftAnimation)
			karacter.setAnimation(leftAnimation);

		if(karacter.getDirection() != Direction.LEFT)
			karacter.setDirection(Direction.LEFT);

		karacter.setX(karacter.getX() - WALK_SPEED);
        karacter.getGame().getScene().addEyeView(eyeView);
	}

	public void right()
	{
		if(karacter.getAnimation() != rightAnimation)
			karacter.setAnimation(rightAnimation);

		if(karacter.getDirection() != Direction.RIGHT)
			karacter.setDirection(Direction.RIGHT);

		karacter.setX(karacter.getX() + WALK_SPEED);
        karacter.getGame().getScene().addEyeView(eyeView);
	}

	public void up()
	{
		if(karacter.getAnimation() != upAnimation)
			karacter.setAnimation(upAnimation);

		if(karacter.getDirection() != Direction.UP)
			karacter.setDirection(Direction.UP);

		karacter.setY(karacter.getY() - WALK_SPEED);
        karacter.getGame().getScene().addEyeView(eyeView);
	}

	public void down()
	{
		if(karacter.getAnimation() != downAnimation)
			karacter.setAnimation(downAnimation);

		if(karacter.getDirection() != Direction.DOWN)
			karacter.setDirection(Direction.DOWN);

		karacter.setY(karacter.getY() + WALK_SPEED);
        karacter.getGame().getScene().addEyeView(eyeView);
	}

    @Override
	public void handleAnimation()
	{
		int animationCounter = karacter.getAnimationCounter();

		//System.out.println("Animation Counter is " + animationCounter);

		//sword is done swinging revert back to former state
		if (animationCounter == karacter.getAnimation().length)
		{
			karacter.setY(oldY);
			karacter.setX(oldX);
			karacter.setAnimationInterval(oldAnimationInterval);
			karacter.setCheckcollision(true);
			//karacter.setState(new StandState(karacter));
		}
		else
        {
		// This section of the code corrects the position of karacter when he's striking.
			// If you don't do this karacter appears to be moving when he swings his sword.
			// Go ahead and remove the entire body of this else statement. You'll see what i mean.

			Direction dir = karacter.getDirection();

			if (dir == Direction.UP)
			{
				switch(animationCounter)
				{
					case 0:
						karacter.setY(karacter.getY() + 1);
						break;

					case 2:
						karacter.setY(karacter.getY() - 2);
						break;

					case 3:
						karacter.setY(karacter.getY() - 6);
						break;

					case 4:
						karacter.setY(karacter.getY() - 1);
						break;

					case 6:
						karacter.setY(karacter.getY() + 2);
						karacter.setX(karacter.getX() - 4);
						break;

					case 7:
						karacter.setY(karacter.getY() + 2);
						karacter.setX(karacter.getX() - 6);
						break;

					case 8:
						karacter.setY(karacter.getY() + 3);
						karacter.setX(karacter.getX() - 2);
						break;
				}
			}
			else if (dir == Direction.LEFT)
			{
				switch(animationCounter)
				{
					case 0:
						karacter.setY(karacter.getY() - 1);
						karacter.setX(karacter.getX() + 3);
						break;

					case 1:
						karacter.setX(karacter.getX() - 2);
						break;

					case 2:
						karacter.setY(karacter.getY() - 1);
						karacter.setX(karacter.getX() - 5);
						break;

					case 3:
						karacter.setX(karacter.getX() - 2);
						break;

					case 4:
						karacter.setY(karacter.getY() + 2);
						karacter.setX(karacter.getX() - 4);
						break;

					case 6:
						karacter.setX(karacter.getX() + 1);
						break;

					case 8:
						karacter.setX(karacter.getX() + 6);
						break;
				}
			}
			else if(dir == Direction.DOWN)
			{
				switch(animationCounter)
				{
					case 0:
						karacter.setX(karacter.getX() - 4);
						break;

					case 1:
						karacter.setX(karacter.getX() - 1);
						break;

					case 2:
						karacter.setX(karacter.getX() + 1);
						break;
				}
            }
        }
    }
}

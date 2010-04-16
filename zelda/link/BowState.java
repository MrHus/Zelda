package zelda.link;

import zelda.items.Arrow;
import zelda.karacter.Direction;


/**
 * State for when link is using the bow.
 *
 * @author frankie
 */
public class BowState extends LinkState
{
	private final static String[] downAnimation	= {"Link bow down 1", "Link bow down 2","Link bow down 3"};
	private final static String[] upAnimation	= {"Link bow up 1", "Link bow up 2","Link bow up 3"};
	private final static String[] leftAnimation	= {"Link bow left 1", "Link bow left 2","Link bow left 3"};
	private final static String[] rightAnimation= {"Link bow right 1", "Link bow right 2"};

    private int oldX, oldY;


	public BowState(Link link)
	{
		super(link);
		name = "BowState";

        oldX = link.getX();
        oldY = link.getY();

		link.setCheckcollision(false);

		switch (link.getDirection())
		{
			case UP:
				link.setAnimation(upAnimation);
                game.getScene().addNewGObject(new Arrow(game, link.getX() + 7, link.getY()));
				break;

			case DOWN:
				link.setAnimation(downAnimation);
                game.getScene().addNewGObject(new Arrow(game, link.getX() + 7, link.getY()));
				break;

			case LEFT:
				link.setAnimation(leftAnimation);
                game.getScene().addNewGObject(new Arrow(game, link.getX(), link.getY() + 9));
				break;

			case RIGHT:
				link.setAnimation(rightAnimation);
                game.getScene().addNewGObject(new Arrow(game, link.getX(), link.getY() + 9));
				break;
		}

	}

    @Override
	public void handleAnimation()
	{
		int animationCounter = link.getAnimationCounter();


		if (animationCounter == link.getAnimation().length)
		{
            link.setY(oldY);
			link.setX(oldX);
			link.setCheckcollision(true);
			link.setState(new StandState(link));;
		}
        else
        {
            Direction dir = link.getDirection();

			if (dir == Direction.UP)
			{
				switch(animationCounter)
				{
					case 0:
						link.setX(link.getX() - 2);
						break;

					case 1:
						link.setX(link.getX() - 3);
						break;
				}
			}
			else if (dir == Direction.LEFT)
			{
				switch(animationCounter)
				{
					case 0:
						link.setX(link.getX() + 2);
                        link.setY(link.getY() + 1);
						break;

					case 1:
						link.setX(link.getX() - 2);
						break;
				}
            }
        }
    }
}
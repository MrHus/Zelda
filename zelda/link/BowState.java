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


	public BowState(Link link)
	{
		super(link);
		name = "BowState";

		link.setCheckcollision(false);

		switch (link.getDirection())
		{
			case UP:
				link.setAnimation(upAnimation);
                game.getScene().addGObject(new Arrow(game, link.getX() + 7, link.getY()));
				break;

			case DOWN:
				link.setAnimation(downAnimation);
                game.getScene().addGObject(new Arrow(game, link.getX() + 7, link.getY()));
				break;

			case LEFT:
				link.setAnimation(leftAnimation);
                game.getScene().addGObject(new Arrow(game, link.getX(), link.getY() + 9));
				break;

			case RIGHT:
				link.setAnimation(rightAnimation);
                game.getScene().addGObject(new Arrow(game, link.getX(), link.getY() + 9));
				break;
		}

        

        //game.getScene().addGObject(new Arrow(game, link.getX(), link.getY()));
	}

    @Override
	public void handleAnimation()
	{
		int animationCounter = link.getAnimationCounter();

		//System.out.println("Animation Counter is " + animationCounter);

		//sword is done swinging revert back to former state
		if (animationCounter == link.getAnimation().length)
		{
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
						link.setX(link.getX() + 1);
						break;

					case 1:
						link.setX(link.getX() - 3);
						break;

					case 2:
						link.setX(link.getX() + 1);
						break;

				}
			}
			else if (dir == Direction.LEFT)
			{
				switch(animationCounter)
				{
					case 0:
						link.setX(link.getX() + 1);
						break;

					case 1:
						link.setX(link.getX() - 1);
						break;

					case 2:
						link.setX(link.getX() - 1);
						break;

				}
            }
        }
    }
}
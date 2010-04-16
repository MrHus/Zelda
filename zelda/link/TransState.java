package zelda.link;

import zelda.karacter.Direction;

/**
 *
 * @author vincentklarholz
 */
public class TransState extends LinkState
{
	private final static String[] downAnimation	= {"Link stand down", "Link stand down", "Link stand down", "Link stand down", "Link stand down", "Link stand down", "Link stand down", "Link stand down", "Link stand down", "Link stand down"};
	private final static String[] upAnimation	= {"Link stand up", "Link stand up", "Link stand up", "Link stand up", "Link stand up", "Link stand up", "Link stand up", "Link stand up", "Link stand up", "Link stand up"};
	private final static String[] leftAnimation	= {"Link stand left", "Link stand left", "Link stand left", "Link stand left", "Link stand left", "Link stand left", "Link stand left", "Link stand left", "Link stand left", "Link stand left"};
	private final static String[] rightAnimation= {"Link stand right", "Link stand right", "Link stand right", "Link stand right", "Link stand right", "Link stand right", "Link stand right", "Link stand right", "Link stand right", "Link stand right"};

    private Direction direction;

    public TransState(Link link, Direction direction)
    {
        super(link);
		name = "TransState";
		link.setAnimationInterval(10);
        this.direction = direction;
    }

    public void left()
	{
        link.setAnimation(leftAnimation);
		link.setX(link.getX() + 4);
	}

	public void right()
	{
        link.setAnimation(rightAnimation);
		link.setX(link.getX() - 4);
	}

	public void up()
	{
        link.setAnimation(upAnimation);
        link.setY(link.getY() + 4);
	}

	public void down()
	{
        link.setAnimation(downAnimation);
		link.setY(link.getY() - 4);
	}

    @Override
	public void handleAnimation()
	{
		int animationCounter = link.getAnimationCounter();

        if (animationCounter == link.getAnimation().length)
		{
			link.setAnimationInterval(90);
            link.setState(new WalkState(link));
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

package zelda.items;

import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.karacter.Direction;
import zelda.link.Link;

/**
 *
 * @author frankie
 */
public class Arrow extends GObject
{

    //Arrow animation at the moment only one animation
    private final static String[] arrowRight    = {"arrowRight"};
	private final static String[] arrowLeft     = {"arrowLeft"};
	private final static String[] arrowDown     = {"arrowDown"};
	private final static String[] arrowUp       = {"arrowUp"};
    private Direction direction;

    public Arrow(Game game, int x, int y)
    {
        super(game, x, y, 13, 16, "images/arrows.png");

        spriteLoc.put("arrowRight", new Rectangle(0, 0, 24, 5));
        spriteLoc.put("arrowLeft", new Rectangle(25, 0, 24, 5));
        spriteLoc.put("arrowDown", new Rectangle(50, 0, 5, 24));
        spriteLoc.put("arrowUp", new Rectangle(75, 0, 5, 24));

        sprite.setSprite(spriteLoc.get("arrowRight"));

		liquid = true;

        direction = game.getLink().getDirection();

        switch (direction)
		{
			case UP:
                this.setAnimation(arrowUp);
				break;

			case DOWN:
                this.setAnimation(arrowDown);
				break;

			case LEFT:
                this.setAnimation(arrowLeft);
				break;

			case RIGHT:
                this.setAnimation(arrowRight);
				break;
		}
    }

    public void doInLoop()
    {
        switch (direction)
		{
			case UP:
                setY(getY() - 1);
				break;

			case DOWN:
                setY(getY() + 1);
				break;

			case LEFT:
                setX(getX() - 1);
				break;

			case RIGHT:
                setX(getX() + 1);
				break;
		}
    }



	@Override
	public void collision(GObject obj)
	{
		System.out.println("Collision");

		if (obj instanceof Link)
		{
			alive = false;
		}
	}




}

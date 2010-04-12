package zelda.items;

import java.awt.Rectangle;
import zelda.collision.Hittable;
import zelda.collision.Weapon;
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

        spriteLoc.put("arrowRight", new Rectangle(75, 0, 17, 6));
        spriteLoc.put("arrowLeft", new Rectangle(50, 0, 17, 6));
        spriteLoc.put("arrowDown", new Rectangle(0, 0, 6, 17));
        spriteLoc.put("arrowUp", new Rectangle(25, 0, 6, 17));

        direction = game.getLink().getDirection();

        switch (direction)
		{
			case UP:
                sprite.setSprite(spriteLoc.get("arrowUp"));
                this.setAnimation(arrowUp);
				break;

			case DOWN:
                sprite.setSprite(spriteLoc.get("arrowDown"));
                this.setAnimation(arrowDown);
				break;

			case LEFT:
                sprite.setSprite(spriteLoc.get("arrowLeft"));
                this.setAnimation(arrowLeft);
				break;

			case RIGHT:
                sprite.setSprite(spriteLoc.get("arrowRight"));
                this.setAnimation(arrowRight);
				break;
		}
    }

    public void doInLoop()
    {
        switch (direction)
		{
			case UP:
                setY(getY() - 2);
				break;

			case DOWN:
                setY(getY() + 2);
				break;

			case LEFT:
                setX(getX() - 2);
				break;

			case RIGHT:
                setX(getX() + 2);
				break;
		}
    }

	@Override
	public void collision(GObject obj)
	{
		if (obj instanceof Hittable && !(obj instanceof Link))
		{
			Hittable hittable = (Hittable)obj;
			hittable.hitBy(Weapon.ARROW);
			alive = false;
		}
	}
}

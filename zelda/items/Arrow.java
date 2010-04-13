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

    private final static String[] arrowHitDown	= {"arrowDown1","arrowDown2","arrowDown3"};
    private final static String[] arrowHitUp	= {"arrowUp1","arrowUp2","arrowUp3"};
    private final static String[] arrowHitLeft	= {"arrowLeft1","arrowLeft2","arrowLeft3"};
    private final static String[] arrowHitRight	= {"arrowRight1","arrowRight2","arrowRight3"};

    private Direction direction;
	
    public Arrow(Game game, int x, int y)
    {
        super(game, x, y, 13, 4, "images/arrows.png");

        // Arrow Direction only
        spriteLoc.put("arrowRight", new Rectangle(75, 0, 17, 6));
        spriteLoc.put("arrowLeft", new Rectangle(50, 0, 17, 6));
        spriteLoc.put("arrowDown", new Rectangle(0, 0, 6, 17));
        spriteLoc.put("arrowUp", new Rectangle(25, 0, 6, 17));
        spriteLoc.put("arrowDown1", new Rectangle(0, 25, 7, 12));
        spriteLoc.put("arrowDown2", new Rectangle(25, 25, 7, 12));
        spriteLoc.put("arrowDown3", new Rectangle(50, 25, 7, 12));
        spriteLoc.put("arrowHitUp1", new Rectangle(0, 50, 7, 12));
        spriteLoc.put("arrowHitUp2", new Rectangle(25, 50, 7, 12));
        spriteLoc.put("arrowHitUp3", new Rectangle(50, 50, 7, 12));
        spriteLoc.put("arrowHitLeft1", new Rectangle(0, 75, 12, 7));
        spriteLoc.put("arrowHitLeft2", new Rectangle(25, 75, 12, 7));
        spriteLoc.put("arrowHitLeft3", new Rectangle(50, 75, 12, 7));
        spriteLoc.put("arrowHitRight1", new Rectangle(0, 100, 12, 7));
        spriteLoc.put("arrowHitRight2", new Rectangle(25, 100, 12, 7));
        spriteLoc.put("arrowHitRight3", new Rectangle(50, 100, 12, 7));

        direction = game.getLink().getDirection();

        switch (direction)
		{
			case UP:
                sprite.setSprite(spriteLoc.get("arrowUp"));
                this.setAnimation(arrowUp);
                this.setHeight(13);
                this.setWidth(4);
				break;

			case DOWN:
                sprite.setSprite(spriteLoc.get("arrowDown"));
                this.setAnimation(arrowDown);
                this.setHeight(13);
                this.setWidth(4);
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

	public void PostAnimation()
	{
		switch (direction)
		{
			case UP:
                sprite.setSprite(spriteLoc.get("arrowHitUp"));
                this.setAnimation(arrowHitUp);
				break;

			case DOWN:
                sprite.setSprite(spriteLoc.get("arrowHitDown"));
                this.setAnimation(arrowHitDown);
				break;

			case LEFT:
                sprite.setSprite(spriteLoc.get("arrowHitLeft"));
                this.setAnimation(arrowHitLeft);
				break;

			case RIGHT:
                sprite.setSprite(spriteLoc.get("arrowHitRight"));
                this.setAnimation(arrowHitRight);
				break;
		}
    }

    @Override
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

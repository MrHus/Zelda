package zelda.items;

import java.awt.Rectangle;
import java.awt.geom.Area;
import zelda.collision.Hittable;
import zelda.collision.Weapon;
import zelda.enemy.Behavior;
import zelda.engine.GObject;
import zelda.engine.Game;

/**
 *
 * @author vincentklarholz
 */
public class Bomb extends GObject
{

    //Bomb animation is 2.5 sec so 50 items in array.
    private final static String[] bombAnimation	= { "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb2", "bomb3", "bomb4",
                                                    "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb2", "bomb3", "bomb4", "bomb1",
                                                    "bomb1", "bomb1", "bomb1", "bomb1", "bomb2", "bomb3", "bomb4", "bomb1", "bomb1", "bomb1",
                                                    "bomb1", "bomb2", "bomb3", "bomb4", "bomb2", "bomb3", "bomb2", "bomb8", "bomb4", "bomb2",
                                                    "bomb3", "bomb2", "bomb8", "bomb4", "bomb8", "bomb4", "bomb9", "bomb9", "bomb10", "bomb10", "bomb10"};
    private Behavior behavior;

    private Rectangle bomb;

    public Bomb(Game game, int x, int y)
    {
        super(game, x, y, 13, 16, "images/bombs.png");
		
        spriteLoc.put("bomb1", new Rectangle(0, 0, 13, 16));
        spriteLoc.put("bomb2", new Rectangle(13, 0, 13, 16));
        spriteLoc.put("bomb3", new Rectangle(26, 0, 13, 16));
        spriteLoc.put("bomb4", new Rectangle(39, 0, 13, 16));
        spriteLoc.put("bomb5", new Rectangle(52, 0, 13, 16));
        spriteLoc.put("bomb6", new Rectangle(65, 0, 13, 16));
        spriteLoc.put("bomb7", new Rectangle(78, 0, 13, 16));
        spriteLoc.put("bomb8", new Rectangle(91, 0, 13, 16));
        spriteLoc.put("bomb9", new Rectangle(104, 0, 13, 16));
        spriteLoc.put("bomb10", new Rectangle(117, 0, 30, 30));

        sprite.setSprite(spriteLoc.get("bomb1"));
        setAnimation(bombAnimation);
        this.setAnimationInterval(50); //keep on 50 for 2.5 sec bomb countdown.

		liquid = true;
		checkcollision = false;
        
        behavior = new BombBehavior(this);
    }

    @Override
	public void preAnimation()
	{
        if (animationCounter == 1)
        {
            game.playFx("sounds/linkBounce.mp3");
        }
        if(animationCounter == 48)
        {
            game.playFx("sounds/bombExplode.mp3");
            
            x -= 8;
            y -= 6;

            bomb = new Rectangle(x , y, 30, 30);
            game.getScene().addHitter(bomb);
        }
    }

	@Override
    public void doInLoop()
    {
        behavior.behave();

        if(animationCounter > 48)
        {
            for (GObject obj : game.getScene().getGObjects())
            {
                final Area area = new Area();
                area.add(new Area(bomb));
                area.intersect(new Area(obj.getRectangle()));

                if((obj instanceof Hittable) && !area.isEmpty() && this != obj)
                {
                    Hittable hittable = (Hittable)obj;
                    hittable.hitBy(Weapon.BOMB);
                }
            }

            game.getScene().removeHitter(bomb);
        }
    }
}


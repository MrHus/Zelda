package zelda.items;

import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.enemy.Behavior;

/**
 *
 * @author Tom
 */

public class Heart extends GObject
{
    private final static String[] heartAnimation = {"heart"};
    private Behavior behavior;

    public Heart (ZeldaGame game, int x, int y)
    {
    super(game, x, y, 10, 10, "images/heart.png");
    spriteLoc.put("heart",new Rectangle(0, 0, 10, 10));
    
    sprite.setSprite(spriteLoc.get("heart"));
    setAnimation(heartAnimation);

    behavior = new HeartBehavior(this);

    }
    public void doInLoop()
    {
        behavior.behave();
    }

}
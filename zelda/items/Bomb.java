/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zelda.items;

import java.awt.Rectangle;
import zelda.enemy.Behavior;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.link.Link;

/**
 *
 * @author vincentklarholz
 */
public class Bomb extends GObject {

    //Bomb animation is 5 sec so 50 items in array.
    private final static String[] bombAnimation	= { "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb2", "bomb3", "bomb4",
                                                    "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb1", "bomb2", "bomb3", "bomb4", "bomb1",
                                                    "bomb1", "bomb1", "bomb1", "bomb1", "bomb2", "bomb3", "bomb4", "bomb1", "bomb1", "bomb1",
                                                    "bomb1", "bomb2", "bomb3", "bomb4", "bomb2", "bomb3", "bomb2", "bomb8", "bomb4", "bomb2",
                                                    "bomb3", "bomb2", "bomb8", "bomb4", "bomb8", "bomb4", "bomb9", "bomb9", "bomb10", "bomb10"};
    private Behavior behavior;

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
        this.setAnimationInterval(100); //keep on 100 for 5 sec bomb countdown.

        behavior = new BombBehavior(this);
    }

	@Override
    public void doInLoop()
    {
        behavior.behave();
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

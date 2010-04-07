/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zelda.items;

import java.awt.Rectangle;
import zelda.ZeldaGame;
import zelda.enemy.Behavior;
import zelda.engine.GObject;
import zelda.link.Link;

/**
 *
 * @author vincentklarholz
 */
public class Bomb extends GObject
{

    private final static String[] bombAnimation	= { "bomb" };
    private Behavior behavior;

    public Bomb(ZeldaGame game, int x, int y)
    {
        super(game, x, y, 18, 21, "images/bomb.png");
        spriteLoc.put("bomb", new Rectangle(0, 0, 18, 21));

        sprite.setSprite(spriteLoc.get("bomb"));
        setAnimation(bombAnimation);

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
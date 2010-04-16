/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda.items;

import java.awt.Rectangle;
import zelda.collision.Hittable;
import zelda.collision.Weapon;
import zelda.engine.GObject;
import zelda.engine.Game;

/**
 *
 * @author Christiaan
 */
public class Bush extends GObject implements Hittable
{

    public Bush(Game game, int x, int y) {
        super(game, x, y, 16, 14, "images/items.png");
        spriteLoc.put("bush", new Rectangle(0, 0, 16, 14));
        spriteLoc.put("stump", new Rectangle(17, 0, 15, 13));
        
        String[] bushani = {"bush"};
        setAnimation(bushani);
        sprite.setSprite(spriteLoc.get("bush"));
    }

    public void hitBy(Weapon weapon) 
    {
        if(weapon == Weapon.SWORD)
        {
            String[] bushani = {"stump"};
            setAnimation(bushani);

            if (liquid == false)
            {
                game.playMusic("sounds/bushCut.mp3", false);

                randomGoodie();
            }

            liquid = true;
        }
    }
}

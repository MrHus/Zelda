/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zelda.items;

import zelda.enemy.Behavior;

/**
 *
 * @author Tom
 */
public class HeartBehavior extends Behavior
{
private Heart heart;

private long animationInterval = 1000;
private long lastAnimation = System.currentTimeMillis();

private int ticks = 0;

public HeartBehavior (Heart heart)
{
    this.heart = heart;
}

public void behave()
{
    if (System.currentTimeMillis() > lastAnimation + animationInterval)
   {
        if(ticks == 1)
        {
         heart.setX(heart.getX() + 1);
         ticks = 0;
        }
        lastAnimation = System.currentTimeMillis();
        ticks++;
    }
}
}

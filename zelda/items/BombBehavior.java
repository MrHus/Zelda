/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zelda.items;

import zelda.enemy.Behavior;

/**
 *
 * @author vincentklarholz
 */
public class BombBehavior extends Behavior
{
    private Bomb bomb;

    private long animationInterval = 50;
    private long lastAnimation = System.currentTimeMillis();

    private int ticks = 0;

    public BombBehavior(Bomb bomb )
    {
        this.bomb = bomb;
    }


    public void behave()
    {
        if (System.currentTimeMillis() > lastAnimation + animationInterval) // if it time to reanimate
	{
            /*if(ticks == 3)
            {
            bomb.setAlive(false);
            }*/

          
            if(ticks >= 1 && ticks <= 3 )
            {
                bomb.setX(bomb.getX() + 5);
                bomb.setY(bomb.getY() - 4);
            }

            if(ticks == 4)
            {
                bomb.setX(bomb.getX() + 5);
                bomb.setY(bomb.getY() - 1);
            }

            if(ticks == 5)
            {
                bomb.setX(bomb.getX() + 5);
            }

            if(ticks == 6)
            {
                bomb.setX(bomb.getX() + 5);
                bomb.setY(bomb.getY() + 1);
            }

            if(ticks >= 7 && ticks <= 9 )
            {
                bomb.setX(bomb.getX() + 5);
                bomb.setY(bomb.getY() + 4);
            }

            if(ticks == 87)
            {
                ticks = 0;
            }

            lastAnimation = System.currentTimeMillis();
            ticks++;
          
        }
    }

}

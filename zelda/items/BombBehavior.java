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
            if(ticks == 49)
            {
                bomb.setAlive(false);
            }

            lastAnimation = System.currentTimeMillis();
            ticks++;
        }
    }

}

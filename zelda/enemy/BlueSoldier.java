package zelda.enemy;

import zelda.collision.Hittable;
import zelda.collision.Weapon;
import java.awt.Rectangle;
import zelda.engine.Game;
import zelda.karacter.Direction;
import zelda.karacter.Karacter;

/**
 * A Blue soldier.
 *
 * @author maartenhus
 */
public class BlueSoldier extends Soldier implements Hittable
{
	public BlueSoldier(Game game, int x, int y, Direction direction, int ticks)
	{
		super(game, x, y, direction, "images/blue-soldier.png");
		behavior = new PatrolBehavior(this, ticks);
	}

	public void hitBy(Weapon weapon)
	{
        if (health >= 1)
        {
            game.playFx("sounds/enemyHit.mp3");
        }

        switch(weapon)
		{
			case SWORD:
                if (health > 0 && System.currentTimeMillis() > lastHit + 800)
                {
                    lastHit = System.currentTimeMillis();
                    health -= 3;
                    this.setState(new TransState(this, game.getLink().getDirection()));
                }
				break;

            case BOMB:
                //alive = false;
                health = 0;
                break;

            case ARROW:
                health -= 3;
                this.setBehavior(new AttackBehavior(this));
                break;
		}
        
        if(health <= 0)
        {
            alive = false;
            game.playFx("sounds/enemyDie.mp3");
            randomGoodie();
        }
	}
}

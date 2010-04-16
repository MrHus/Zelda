package zelda.enemy;

import zelda.collision.Hittable;
import zelda.collision.Weapon;
import java.awt.Rectangle;
import zelda.engine.Game;
import zelda.karacter.Direction;
import zelda.karacter.Karacter;

/**
 * A White soldier.
 *
 * @author maartenhus
 */
public class WhiteSoldier extends Soldier implements Hittable
{
	public WhiteSoldier(Game game, int x, int y, Direction direction)
	{
		super(game, x, y, direction, "images/white-soldier.png");
		behavior = new RandomBehavior(this);
	}

	public void hitBy(Weapon weapon)
	{
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
                alive = false;
                break;

            case ARROW:
                game.playFx("sounds/enemyHit.mp3");
                health -= 3;               
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

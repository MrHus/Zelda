package zelda.enemy;

import zelda.collision.Hittable;
import zelda.collision.Weapon;
import zelda.engine.Game;
import zelda.karacter.Direction;

/**
 * A White soldier.
 *
 * @author maartenhus
 */
public class BossSoldier extends Soldier implements Hittable {

    public BossSoldier(Game game, int x, int y, Direction direction) {
        super(game, x, y, direction, "images/boss.png");
        behavior = new AttackBehavior(this);
        health = 30;
    }

    public void hitBy(Weapon weapon) {
        if (health >= 1) {
            game.playFx("sounds/enemyHit.mp3");
        }

        switch (weapon) {
            case SWORD:
                if (health > 0 && System.currentTimeMillis() > lastHit + 800) {
                    lastHit = System.currentTimeMillis();
                    health -= 3;
                    setState(new TransState(this, game.getLink().getDirection()));
                }
                break;

            case BOMB:
                if (health > 0 && System.currentTimeMillis() > lastHit + 800) {
                    lastHit = System.currentTimeMillis();
                    health -= 10;
                    setState(new TransState(this, game.getLink().getDirection()));
                }
                break;

            case ARROW:
                if (health > 0 && System.currentTimeMillis() > lastHit + 800) {
                    lastHit = System.currentTimeMillis();
                    health -= 2;
                }
                break;
        }

        if (health <= 0) {
            alive = false;
            game.playFx("sounds/enemyDie.mp3");
            randomGoodie();
        }
    }
}

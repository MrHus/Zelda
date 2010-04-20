package zelda.enemy.armos;

import java.awt.Rectangle;
import zelda.collision.Hittable;
import zelda.collision.Weapon;
import zelda.enemy.AttackBehavior;
import zelda.enemy.Behavior;
import zelda.engine.Game;
import zelda.karacter.Direction;
import zelda.karacter.Karacter;

/**
 *
 * @author Christiaan
 */
public class ArmosKnight extends Karacter implements Hittable
{
    protected Behavior behavior;
    protected long inputInterval = 40;
    protected long lastInput = System.currentTimeMillis();
    protected long lastHit = System.currentTimeMillis();

    public ArmosKnight(Game game, int x, int y, Direction direction)
    {
        super(game, x, y, 32, 52, direction, "images/armos.png");

        spriteLoc.put("1", new Rectangle(0, 0, 32, 52));
        spriteLoc.put("2", new Rectangle(32, 0, 32, 52));
        spriteLoc.put("3", new Rectangle(64, 0, 32, 52));
        spriteLoc.put("4", new Rectangle(96, 0, 32, 52));
        spriteLoc.put("5", new Rectangle(128, 0, 32, 52));
        spriteLoc.put("6", new Rectangle(160, 0, 32, 52));
        spriteLoc.put("7", new Rectangle(192, 0, 32, 52));
        spriteLoc.put("8", new Rectangle(224, 0, 32, 52));
        spriteLoc.put("9", new Rectangle(256, 0, 32, 52));
        spriteLoc.put("10", new Rectangle(288, 0, 32, 52));

        spriteLoc.put("hit 1", new Rectangle(0, 64, 32, 52));
        spriteLoc.put("hit 2", new Rectangle(32, 64, 32, 52));
        spriteLoc.put("hit 3", new Rectangle(64, 64, 32, 52));
        spriteLoc.put("hit 4", new Rectangle(96, 64, 32, 52));
        spriteLoc.put("hit 5", new Rectangle(128, 64, 32, 52));
        spriteLoc.put("hit 6", new Rectangle(160, 64, 32, 52));
        spriteLoc.put("hit 7", new Rectangle(192, 64, 32, 52));
        spriteLoc.put("hit 8", new Rectangle(224, 64, 32, 52));
        spriteLoc.put("hit 9", new Rectangle(256, 64, 32, 52));
        spriteLoc.put("hit 10", new Rectangle(288, 64, 32, 52));

        sprite.setSprite(spriteLoc.get("1"));

        health = 25;

        state = new AttackState(this);

        behavior = new AttackBehavior(this);

    }

    public void hitBy(Weapon weapon)
    {
        if (health >= 25)
        {
            game.playFx("sounds/enemyHit.mp3");
        }

        switch (weapon)
        {
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
                    health -= 1;
                    setState(new TransState(this, game.getLink().getDirection()));
                }
                break;
        }

        if (health <= 0)
        {
            alive = false;
            game.playFx("sounds/enemyDie.mp3");
            randomGoodie();
        }
    }

    @Override
    public void preAnimation()
    {
        state.handleAnimation();
    }

    @Override
    public void doInLoop()
    {
        if (System.currentTimeMillis() > lastInput + inputInterval)
        {
            state.handleInput();
            behavior.behave();
            lastInput = System.currentTimeMillis();
        }
    }

    public Behavior getBehavior()
    {
        return behavior;
    }

    public void setBehavior(Behavior behavior)
    {
        this.behavior = behavior;
    }
}

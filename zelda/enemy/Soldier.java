package zelda.enemy;

import java.awt.Rectangle;
import zelda.engine.Game;
import zelda.karacter.Direction;
import zelda.karacter.Karacter;

/**
 *
 * @author maartenhus
 */
public abstract class Soldier extends Karacter
{
	protected Behavior behavior;

	protected long inputInterval = 50;
	protected long lastInput = System.currentTimeMillis();
    protected long lastHit = System.currentTimeMillis();

	public Soldier(Game game, int x, int y, Direction direction, String image)
	{
		super(game, x, y, 10, 20, direction, image);

		spriteLoc.put("Stand right",	new Rectangle(0, 0, 27, 27));
		spriteLoc.put("Walk right 1",	new Rectangle(30, 0, 32, 27));
		spriteLoc.put("Walk right 2",	new Rectangle(64, 0, 29, 27));

		spriteLoc.put("Stand left",		new Rectangle(0, 30, 27, 27));
		spriteLoc.put("Walk left 1",	new Rectangle(30, 30, 32, 27));
		spriteLoc.put("Walk left 2",	new Rectangle(64, 30, 29, 27));

		spriteLoc.put("Stand up",		new Rectangle(0, 60, 22, 24));
		spriteLoc.put("Walk up 1",		new Rectangle(30, 60, 22, 24));
		spriteLoc.put("Walk up 2",		new Rectangle(60, 60, 22, 25));

		spriteLoc.put("Stand down",		new Rectangle(0, 90, 22, 33));
		spriteLoc.put("Walk down 1",	new Rectangle(30, 90, 22, 34));
		spriteLoc.put("Walk down 2",	new Rectangle(60, 90, 22, 38));
		spriteLoc.put("Walk down 3",	new Rectangle(0, 125, 22, 35));

        spriteLoc.put("hit right",	new Rectangle(0, 160, 27, 27));
        spriteLoc.put("hit left",		new Rectangle(0, 192, 27, 27));
        spriteLoc.put("hit down",		new Rectangle(0, 256, 22, 33));
        spriteLoc.put("hit up",		new Rectangle(0, 224, 22, 24));

		sprite.setSprite(spriteLoc.get("Stand right"));

		health = 6;

		state = new WalkState(this);
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

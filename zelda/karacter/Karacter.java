package zelda.karacter;

import zelda.engine.GObject;
import zelda.engine.Game;

/**
 * A GObject that has a state and a direction.
 *
 * @author maartenhus
 */
public abstract class Karacter extends GObject
{
	protected Direction direction;
	protected KaracterState state;
    protected int health = 1;

	public Karacter(Game game, int x, int y, int width, int height, Direction direction, String image)
	{
		super(game, x, y, width, height, image);
		this.direction = direction;
	}

	public Direction getDirection()
	{
		return direction;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}

	public KaracterState getState()
	{
		return state;
	}

	public String getStateString()
	{
		return state.toString();
	}

	public void setState(KaracterState state)
	{
		this.state = state;
	}

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }
}
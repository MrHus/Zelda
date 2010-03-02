package zelda.karacter;

import zelda.ZeldaGame;
import zelda.engine.GObject;

/**
 *
 * @author maartenhus
 */
public class Karacter extends GObject
{
	protected Direction direction;

	public Karacter(ZeldaGame game, int x, int y, Direction dir, String image)
	{
		super(game, x, y, image);
		direction = dir;
	}

	public Direction getDirection()
	{
		return direction;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
}

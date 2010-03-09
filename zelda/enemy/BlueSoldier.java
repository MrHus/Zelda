package zelda.enemy;

import zelda.ZeldaGame;
import zelda.karacter.Direction;
import zelda.karacter.Karacter;

/**
 *
 * @author maartenhus
 */
public class BlueSoldier extends Karacter
{
	public BlueSoldier(ZeldaGame game, int x, int y)
	{
		super(game, x, y, 10, 20, Direction.DOWN, "images/blue-soldier.png");
	}
}

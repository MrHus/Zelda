package zelda.scene;

import java.awt.Rectangle;
import zelda.engine.Game;

/**
 *
 * @author Bas Harteveld
 */
public class CastleBasement extends ZeldaScene
{
    public CastleBasement(Game game, String entrance)
	{
        super(game, "images/castlebasement.png", "HouseScene");

        gameObjects.add(game.getLink());

        
    }

	@Override
	public void handleSwitchScene(Rectangle exit)
	{

	}

	@Override
	public void handleSwitchScene(String entrance)
	{
        if(entrance.equals("HyruleScene"))
		{
			moveScene(482, 1);

			game.getLink().setXHardCore(278);
			game.getLink().setYHardCore(84);
		}
	}
}

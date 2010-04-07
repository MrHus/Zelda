/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zelda.link;

import zelda.ZeldaGame;
import zelda.engine.Game;
import zelda.items.Bomb;

/**
 *
 * @author vincentklarholz
 */
public class BombState extends LinkState
{
	private int oldX, oldY;
    protected Game game; // variable moet nog worden gevuld.
    protected ZeldaGame game2;  // variable moet nog worden gevuld.

    public BombState(Link link)
    {
        super(link);
		name = "BombState";

        oldX = link.getX();
		oldY = link.getY();
        
		switch (link.getDirection())
		{
			case UP:
                //gameObjects.add(new Bomb(game, oldX, oldY - 16));
                game.getScene().addGObject(new Bomb(game2, oldX, oldY - 16));
                System.out.println("L pressed, up");
				break;

			case DOWN:
				//gameObjects.add(new Bomb(game, oldX, oldY + link.getHeight()));
                System.out.println("L pressed, down");
				break;

			case LEFT:
				//gameObjects.add(new Bomb(game, oldX - 13, oldY));
                System.out.println("L pressed, left");
				break;

			case RIGHT:
				//gameObjects.add(new Bomb(game, oldX + link.getWidth(), oldY));
                System.out.println("L pressed, right");
				break;
		}
    }

    @Override
	public void handleInput()
	{
        link.setState(new StandState(link));
    }
}

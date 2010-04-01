/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zelda.link;

import zelda.items.Bomb;
/**
 *
 * @author vincentklarholz
 */
public class BombState extends LinkState
{
	private int oldX, oldY;

    public BombState(Link link)
    {
        super(link);
		name = "BombState";

        oldX = link.getX();
		oldY = link.getY();
        
		switch (link.getDirection())
		{
			case UP:
                gameObjects.add(new Bomb(game, oldX, oldY - 16));
                link.setState(new StandState(link));
				break;

			case DOWN:
				gameObjects.add(new Bomb(game, oldX, oldY + link.getHeight()));
                link.setState(new StandState(link));
				break;

			case LEFT:
				gameObjects.add(new Bomb(game, oldX - 13, oldY));
                link.setState(new StandState(link));
				break;

			case RIGHT:
				gameObjects.add(new Bomb(game, oldX + link.getWidth(), oldY));
                link.setState(new StandState(link));
				break;
		}
    }


	
}

package zelda.enemy;

import zelda.karacter.Direction;
import zelda.karacter.Karacter;
import zelda.link.Link;

/**
 *
 * @author vincentklarholz
 */
public class AttackBehavior extends Behavior
{

    private Karacter soldier;
    private Link link;

    private int valueX;
    private int valueY;

	public AttackBehavior(Karacter soldier)
	{
        //System.out.println("here");
		this.soldier = soldier;
        link = soldier.getGame().getLink();
	}

	public void behave()
    {
        valueX = Math.abs(link.getX() - soldier.getX());
        valueY = Math.abs(link.getY() - soldier.getY());

        //check which direct between link and soldier is longer, X or Y
        if(valueX < valueY)
        {
            //Set new direction for soldier
            //Soldier up
            if(link.getY() < soldier.getY())
            {
                soldier.setY(soldier.getY() - 1);
                if(soldier.getDirection() != Direction.UP)
                {
                    soldier.setDirection(Direction.UP);
                }

            }
            //Soldier downw
            else if(link.getY() > soldier.getY())
            {
                soldier.setY(soldier.getY() + 1);
                if(soldier.getDirection() != Direction.DOWN)
                {
                    soldier.setDirection(Direction.DOWN);
                }
            }
        }
        else
        {
            //Set new direction for soldier
            //Soldier left
            if(link.getX() < soldier.getX())
            {
                soldier.setX(soldier.getX() - 1);
                if(soldier.getDirection() != Direction.LEFT)
                {
                  soldier.setDirection(Direction.LEFT);
                }
            }
            //Soldier right
            else if(link.getX() > soldier.getX())
            {
                soldier.setX(soldier.getX() + 1);
                if(soldier.getDirection() != Direction.RIGHT)
                {
                    soldier.setDirection(Direction.RIGHT);
                }
            }
        }

        //Set new X for soldier
        //Soldier left
        if(link.getX() < soldier.getX())
        {
            soldier.setX(soldier.getX() - 1);
        }
        //Soldier right
        else if(link.getX() > soldier.getX())
        {
            soldier.setX(soldier.getX() + 1);
        }

        //Set new Y for soldier
        //Soldier up
        if(link.getY() < soldier.getY())
        {
            soldier.setY(soldier.getY() - 1);
        }
        //Soldier downw
        else if(link.getY() > soldier.getY())
        {
            soldier.setY(soldier.getY() + 1);
        }
    }
}

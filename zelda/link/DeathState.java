package zelda.link;

import zelda.karacter.Direction;

/**
 * @author Bas Harteveld
 */
public class DeathState extends LinkState
{
    private final String[] deathRightAnimation	= {"Link hit right", "Link death right", "Link death right 2"};
    private final String[] deathLeftAnimation	= {"Link hit left", "Link death left", "Link death left 2"};

    private Direction direction;

    public DeathState(Link link, Direction direction)
    {
        super(link);
        name = "DeathState";

        this.direction = direction;

        switch(direction)
        {
            case UP:
                link.setAnimation(deathLeftAnimation);
                link.setAnimationInterval(1000);
                game.playMusic("sounds/killed.mp3", false);
                break;

            case DOWN:
                link.setAnimation(deathRightAnimation);
                link.setAnimationInterval(1000);
                game.playMusic("sounds/killed.mp3", false);
                break;

            case LEFT:
                link.setAnimation(deathLeftAnimation);
                link.setAnimationInterval(1000);
                game.playMusic("sounds/killed.mp3", false);
                break;

            case RIGHT:
                link.setAnimation(deathRightAnimation);
                link.setAnimationInterval(1000);
                game.playMusic("sounds/killed.mp3", false);
                break;
        }
    }

    @Override
	public void handleInput()
	{
        
    }    
}

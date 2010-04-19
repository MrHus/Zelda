package zelda.link;

import zelda.karacter.Direction;
import zelda.scene.HouseScene;

/**
 * @author Bas Harteveld
 */
public class DeathState extends LinkState
{
    private final String[] deathRightAnimation	= {"Link hit right", "Link death right", "Link death right 2"};
    private final String[] deathLeftAnimation	= {"Link hit left", "Link death left", "Link death left 2"};

    private long oldAnimationInterval;

    public DeathState(Link link, Direction direction)
    {
        super(link);
        name = "DeathState";

        switch(direction)
        {
            case UP:
                link.setAnimation(deathLeftAnimation);
                link.setAnimationInterval(700);
                game.playFx("sounds/killed.mp3");
                break;

            case DOWN:
                link.setAnimation(deathRightAnimation);
                link.setAnimationInterval(700);
                game.playFx("sounds/killed.mp3");
                break;

            case LEFT:
                link.setAnimation(deathLeftAnimation);
                link.setAnimationInterval(700);
                game.playFx("sounds/killed.mp3");
                break;

            case RIGHT:
                link.setAnimation(deathRightAnimation);
                link.setAnimationInterval(700);
                game.playFx("sounds/killed.mp3");
                break;
        }
    }

    @Override
	public void handleAnimation()
	{
		int animationCounter = link.getAnimationCounter();
		
		if (animationCounter == link.getAnimation().length)
		{
			link.setAnimationInterval(oldAnimationInterval);			
			link.setState(new StandState(link));
			link.setHealth(2);
			game.setScene(new HouseScene(game, "GameStart"));
		}
    }
}

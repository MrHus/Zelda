package zelda.menu;

import java.awt.Rectangle;
import zelda.engine.Game;
import zelda.engine.Scene;

/**
 * 
 * @author maartenhus
 */
public class HelpMenu extends Scene
{
	private long inputInterval = 100;
	private long lastInput = System.currentTimeMillis();

	public HelpMenu(Game game)
	{
		super(game, "images/help-menu.png", "HelpMenu");

		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));

		try
		{
			game.stopMusic();
		}catch(Exception e){}

		game.playMusic("sounds/help-menu.mp3", false);
	}

	@Override
	public void handleInput()
	{
		if (System.currentTimeMillis() > lastInput + inputInterval)
		{
			if (game.isEnterPressed())
			{
				game.setScene(new MainMenu(game));
			}
			
			lastInput = System.currentTimeMillis();
		}
	}
}

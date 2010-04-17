package zelda.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import zelda.engine.Game;
import zelda.engine.Scene;
import zelda.scene.HouseScene;

/**
 *
 * @author maartenhus
 */
public class MainMenu extends Scene
{
	private Fairy fairy = new Fairy(game, 230, 205);

	private static int		 CURRENT	= 0;
	private static final int NEW_GAME	= 0;
	private static final int LOAD_GAME	= 1;
	private static final int HELP		= 2;

	private long inputInterval = 100;
	private long lastInput = System.currentTimeMillis();

	public MainMenu(Game game)
	{
		super(game, "images/main-menu.png");

		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));

		gameObjects.add(fairy);

		game.playMusic("sounds/main-menu.mp3", false);
	}

	@Override
	public void handleInput()
	{
		if (System.currentTimeMillis() > lastInput + inputInterval)
		{
			checkEnter();
			checkInput();
			setFairy();
			lastInput = System.currentTimeMillis();
		}
	}

	private void checkEnter()
	{
		if (game.isEnterPressed())
		{
			switch(CURRENT)
			{
				case NEW_GAME:
					game.setScene(new HouseScene(game, "GameStart"));
					break;

				case LOAD_GAME:
					break;

				case HELP:
					break;
			}
		}
	}

	private void checkInput()
	{
		if (game.issPressed())
		{
			if (CURRENT == HELP)
			{
				CURRENT = NEW_GAME;
			}
			else
			{
				CURRENT += 1;
			}
		}

		if (game.iswPressed())
		{
			if (CURRENT == NEW_GAME)
			{
				CURRENT = HELP;
			}
			else
			{
				CURRENT -= 1;
			}
		}
	}

	private void setFairy()
	{
		switch(CURRENT)
		{
			case NEW_GAME:
				fairy.setY(205);
				break;

			case LOAD_GAME:
				fairy.setY(235);
				break;

			case HELP:
				fairy.setY(265);
				break;
		}
	}

	@Override
    public void draw(Graphics2D g2)
	{
		g2.drawImage(sprite.getImage(), 0, 0, game.getWidth(), game.getHeight(), null);

		g2.setColor(Color.white);
        Font f = new Font ("Serif", Font.BOLD, 16);
        g2.setFont (f);

		g2.drawString("New Game", 250, 220);
		g2.drawString("Load Game", 250, 250);
		g2.drawString("Help", 250, 280);
	}

	@Override
	public void handleSwitchScene(Rectangle exit){}

	@Override
	public void handleSwitchScene(String entrance){}
}

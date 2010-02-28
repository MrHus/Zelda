package zelda.engine;

import java.awt.Graphics2D;
import java.awt.Image;
import zelda.Game;

/**
 *
 * @author maartenhus
 */
public class Scene implements DrawAble
{
	protected Sprite sprite;
	protected Game game;

	public Scene(Game game, String img)
	{
		this.game = game;
		sprite = Sprite.getSprite(img);
	}

	public void draw(Graphics2D g)
	{
		Image img = sprite.getImage();
		g.drawImage(img, 0, 0, game.getWidth(), game.getHeight(), null);
	}
}

package zelda;

import zelda.Game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import zelda.engine.GObject;

/**
 *
 * @author maartenhus
 */
public class View extends JPanel
{
	private Game game;
	
	public View(Game game)
	{
		this.game = game;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);

		g2.fillRect(0, 0, getWidth(), getHeight());

		for (GObject obj : game.getGObjects())
		{
			obj.draw(g2);
		}
	}
}

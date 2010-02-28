package zelda;

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
		setDoubleBuffered(true);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.fillRect(0, 0, getWidth(), getHeight());

		game.getScene().draw(g2);

		for (GObject obj : game.getGObjects())
		{
			obj.animate();
			obj.draw(g2);
		}

		g2.dispose();
	}
}

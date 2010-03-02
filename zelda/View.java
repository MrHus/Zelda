package zelda;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.swing.JPanel;
import zelda.engine.GObject;

/**
 *
 * @author maartenhus
 */
public class View extends JPanel
{
	private ZeldaGame game;

	public View(ZeldaGame game)
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

		for (GObject obj : game.getScene().getGObjects())
		{
			//g2.draw(obj.getRectangle());
			obj.animate();
			obj.draw(g2);
		}

		//for (Shape s : game.getScene().getSolids())
		//{
			//g2.draw(s);
		//}
		
		g2.dispose();
	}
}

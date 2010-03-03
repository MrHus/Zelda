package zelda;

import java.awt.Graphics2D;
import java.awt.Shape;
import zelda.engine.GObject;

/**
 *
 * @author maartenhus
 */
public class View
{
	private ZeldaGame game;
	private boolean background = true;

	public View(ZeldaGame game)
	{
		this.game = game;
	}	

	public void draw(Graphics2D g2)
	{
		//System.out.println("draw");
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
	}
}

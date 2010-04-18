package zelda;

import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import zelda.engine.Game;

/**
 * This class is a 'development' only class. It lets you get coordinates on the 'screen'
 * these can be used to populate the solid objects in the Scene's.
 *
 * @author maartenhus
 */
public class PolyCreator extends MouseAdapter
{
	private Game game;
	private Polygon poly = new Polygon();

	public PolyCreator(Game game)
	{
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(e.isControlDown()) // print the coordinates in the console in int[] form.
		{
			System.out.print("int[] xpos = {");
			for (int i = 0; i < poly.xpoints.length; i++)
			{
				System.out.print(poly.xpoints[i] + ", ");
			}
			System.out.println("};");

			System.out.print("int[] ypos = {");
			for (int i = 0; i < poly.ypoints.length; i++)
			{
				System.out.print(poly.ypoints[i] + ", ");
			}
			System.out.println("};");
		}
		else // add point in the array.
		{
			int x = game.getScene().getSprite().getX() + e.getX();
			int y = game.getScene().getSprite().getY() + e.getY();

			if(x != 0 && y != 0)
			{
				poly.addPoint(x, y);
				System.out.println("Relative:" + x + " " + y);
				System.out.println("Real:" + e.getX() + " " + e.getY());
			}
		}
	}
}

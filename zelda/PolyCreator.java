package zelda;

import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import zelda.engine.Scene;

/**
 * This class is a 'development' only class. It lets you get coordinates on the 'screen'
 * these can be used to populate the solid objects in the Scene's.
 *
 * @author maartenhus
 */
public class PolyCreator extends MouseAdapter
{
	private Scene scene;
	private Polygon poly = new Polygon();

	public PolyCreator(Scene scene)
	{
		this.scene = scene;
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
			int x = scene.getSprite().getX() + e.getX();
			int y = scene.getSprite().getY() + e.getY() - 23;

			poly.addPoint(x, y);

			System.out.println(x + " " + y);
		}
	}
}

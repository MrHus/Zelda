package zelda.scene;

import java.awt.Polygon;
import zelda.ZeldaGame;

/**
 *
 * @author maartenhus
 */
public class HouseScene extends ZeldaScene
{
	private Polygon poly = new Polygon();

	public HouseScene(ZeldaGame game)
	{
		super(game, "images/link-house.png");

		poly.addPoint(145, 175);
		poly.addPoint(145, 273);
		poly.addPoint(240, 273);
		poly.addPoint(240, 175);

		solids.add(poly);
	}
}

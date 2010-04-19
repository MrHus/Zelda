package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.enemy.BlueSoldier;
import zelda.enemy.WhiteSoldier;
import zelda.engine.Game;
import zelda.karacter.Direction;


/**
 *
 * @author frankie
 */
public class ForrestScene extends ZeldaScene
{
    private Polygon fenchLeft, lake, fenchRight, upperTreeline1, upperTreeline2, upperTreeline3, lowerTreeline;

	private Rectangle exitRight = new Rectangle(506, 193, 20, 50);


    public ForrestScene(Game game, String entrance)
	{
        super(game, "images/forrest-scene.png");

        exits.add(exitRight);



        // Draw both fenches
        int[] axpos = {9, 10, 2, 1, 8};
        int[] aypos = {170, 299, 299, 172, 172};

        for (int i = 0; i < aypos.length; i++) {
            aypos[i] += 20;
        }

        fenchLeft = new Polygon(axpos, aypos, aypos.length);


        int[] cxpos = {510, 511, 505, 504};
        int[] cypos = {220, 295, 296, 220};

        for (int i = 0; i < cypos.length; i++) {
            cypos[i] += 20;
        }

        fenchRight = new Polygon(cxpos, cypos, cypos.length);


        // Upper treeline
        int[] dxpos = {2, 497, 499, 2, 2};
        int[] dypos = {2, 4, 71, 62, 2};

        for (int i = 0; i < dypos.length; i++) {
            dypos[i] += 20;
        }

        upperTreeline1 = new Polygon(dxpos, dypos, dypos.length);

        int[] expos = {69, 58, 44, 33, 20, 11, 2, 2};
        int[] eypos = {63, 91, 118, 143, 162, 170, 171, 48};

        for (int i = 0; i < eypos.length; i++) {
            eypos[i] += 20;
        }

        upperTreeline2 = new Polygon(expos, eypos, eypos.length);


        int[] fxpos = {510, 511, 486, 476, 457, 452, 442, 508};
        int[] fypos = {6, 170, 163, 146, 112, 99, 70, 6};

        for (int i = 0; i < fypos.length; i++) {
            fypos[i] += 20;
        }

        upperTreeline3 = new Polygon(fxpos, fypos, fypos.length);



        // lower treeline
        int[] gxpos = {511, 509, 17, 14, 31, 37, 56, 63, 69, 100, 150, 394, 447, 457, 482, 507};
        int[] gypos = {295, 487, 485, 306, 310, 324, 358, 373, 398, 399, 397, 396, 391, 358, 309, 298};

        for (int i = 0; i < gypos.length; i++) {
            gypos[i] += 20;
        }

        lowerTreeline = new Polygon(gxpos, gypos, gypos.length);


        // Draw Lake
        int[] bxpos = {220, 143, 142, 223, 297, 376, 378, 298, 222};
        int[] bypos = {144, 221, 257, 334, 335, 258, 222, 145, 144};

        for (int i = 0; i < bypos.length; i++) {
            bypos[i] += 20;
        }

        lake = new Polygon(bxpos, bypos, bypos.length);



        // Add polygon objects
        solids.add(fenchLeft);
        solids.add(lake);
        solids.add(fenchRight);
        solids.add(upperTreeline1);
        solids.add(upperTreeline2);
        solids.add(upperTreeline3);
        solids.add(lowerTreeline);


        // add Link
        gameObjects.add(game.getLink());

        // add WhiteSoldiers
        //gameObjects.add(new BlueSoldier(game, 70, 223, Direction.UP, 20));
        //gameObjects.add(new BlueSoldier(game, 116, 340, Direction.DOWN, 20));
        //gameObjects.add(new WhiteSoldier(game, 256, 118, Direction.LEFT, 20));
        //gameObjects.add(new WhiteSoldier(game, 375, 358, Direction.DOWN, 20));


        handleSwitchScene(entrance);


    }

	@Override
	public void handleSwitchScene(Rectangle exit)
	{
		if (exit == exitRight)
		{
			game.setScene(new HouseScene(game, "ForrestScene"));
		}
	}

	@Override
	public void handleSwitchScene(String entrance)
	{
		if(entrance.equals("HouseScene"))
		{
			moveScene(31, 204);

			game.getLink().setXHardCore(31);
			game.getLink().setYHardCore(204);
		}
	}
}

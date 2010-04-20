package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.enemy.BlueSoldier;
import zelda.engine.Game;
import zelda.items.Rupee;
import zelda.items.Warp;
import zelda.karacter.Direction;


/**
 *
 * @author frankie
 */
public class ForrestScene extends ZeldaScene
{
    private Polygon upperTreeline, leftTreeline, upperTreeline2, leftTreeline2, middleTreeline;
    private Polygon entreeWall1, entreeWall2, lowerWall, deadtree1, deadtree2, deadtree3;

	private Rectangle exitRight1 = new Rectangle(506, 185, 20, 50);
    private Rectangle exitRight2 = new Rectangle(506, 250, 20, 90);
    private Rectangle exitUp = new Rectangle(100, 0, 90, 20);
	private Rectangle warpExit = new Rectangle(393, 108, 16, 16);

    public ForrestScene(Game game, String entrance)
	{
        super(game, "images/forrest-scene.png", "ForrestScene");

        exits.add(exitRight1);
        exits.add(exitRight2);
        exits.add(exitUp);
		exits.add(warpExit);

        // Draw upperTreeline
        int[] axpos = {507, 485, 472, 451, 445, 426, 412, 388, 375, 354, 331, 317, 291, 271, 245, 219, 210, 197, 508, 508};
        int[] aypos = {182, 186, 192, 183, 167, 136, 89, 90, 135, 143, 103, 81, 80, 81, 81, 81, 81, 42, 44, 181};

        upperTreeline = new Polygon(axpos, aypos, aypos.length);

        int[] cxpos = {203, 187, 180, 177, 328, 454, 506, 507, 361, 202};
        int[] cypos = {37, 16, 20, 4, 4, 4, 6, 39, 38, 37};

        upperTreeline2 = new Polygon(cxpos, cypos, cypos.length);


        // Draw leftTreeline
        int[] bxpos = {115, 110, 93, 88, 72, 96, 96, 98, 117, 119, 115, 110, 99, 88, 73, 74, 88, 96, 93, 92, 87, 77, 67, 5, 6, 115};
        int[] bypos = {4, 23, 52, 73, 93, 114, 127, 145, 162, 185, 199, 213, 219, 261, 271, 286, 297, 310, 332, 343, 360, 361, 396, 398, 5, 5};

        leftTreeline = new Polygon(bxpos, bypos, bypos.length);

        int[] dxpos = {67, 60, 45, 71, 103, 120, 126, 142, 144, 5, 6, 66};
        int[] dypos = {398, 408, 429, 436, 435, 451, 482, 497, 509, 506, 398, 399};

        leftTreeline2 = new Polygon(dxpos, dypos, dypos.length);


        int[] expos = {378, 346, 336, 321, 308, 311, 311, 292, 269, 245, 223, 211, 189, 163, 152, 157, 161, 175, 180, 163, 152, 157, 145, 130, 128, 133, 125, 117, 118, 136, 156, 180, 231, 255, 261, 263, 251, 236, 243, 276, 300, 307, 313, 322, 341, 347, 368, 390, 397, 400, 394, 379, 367};
        int[] eypos = {179, 184, 183, 164, 161, 149, 132, 116, 115, 114, 114, 119, 114, 118, 138, 162, 183, 189, 207, 214, 230, 254, 260, 273, 293, 302, 308, 357, 372, 382, 376, 379, 380, 372, 357, 320, 308, 302, 279, 286, 279, 263, 238, 230, 232, 245, 254, 245, 231, 203, 188, 179, 179};

        middleTreeline = new Polygon(expos, eypos, eypos.length);


        int[] fxpos = {502, 452, 408, 393, 355, 354, 396, 413, 431, 436, 423, 400, 374, 401, 414, 463, 505, 504};
        int[] fypos = {236, 235, 280, 280, 317, 340, 383, 384, 362, 325, 340, 346, 320, 293, 293, 244, 246, 234};

        entreeWall1 = new Polygon(fxpos, fypos, fypos.length);

        int[] gxpos = {508, 483, 464, 462, 466, 477, 508, 508};
        int[] gypos = {345, 344, 329, 342, 363, 382, 385, 345};

        entreeWall2 = new Polygon(gxpos, gypos, gypos.length);

        int[] hxpos = {508, 483, 464, 462, 466, 477, 508, 508, 509, 394, 365, 327, 295, 231, 197, 193, 508, 508};
        int[] hypos = {345, 344, 329, 342, 363, 382, 385, 345, 442, 443, 411, 408, 440, 443, 474, 510, 508, 441};

        lowerWall = new Polygon(hxpos, hypos, hypos.length);

        int[] ixpos = {507, 477, 474, 505, 507};
        int[] iypos = {390, 389, 424, 425, 391};

        deadtree1 = new Polygon(ixpos, iypos, iypos.length);

        int[] jxpos = {272, 306, 306, 273, 272};
        int[] jypos = {322, 322, 352, 353, 322};

        deadtree2 = new Polygon(jxpos, jypos, jypos.length);

        int[] kxpos = {153, 186, 186, 153, 153};
        int[] kypos = {478, 478, 508, 509, 481};

        deadtree3 = new Polygon(kxpos, kypos, kypos.length);

        solids.add(upperTreeline);
        solids.add(leftTreeline);
        solids.add(upperTreeline2);
        solids.add(leftTreeline2);
        solids.add(middleTreeline);
        solids.add(entreeWall1);
        solids.add(entreeWall2);
        solids.add(lowerWall);
        solids.add(deadtree1);
        solids.add(deadtree2);
        solids.add(deadtree3);

        // add Link
        gameObjects.add(game.getLink());


        gameObjects.add(game.getLink());
        gameObjects.add(new BlueSoldier(game, 440, 375, Direction.UP, 20));
        gameObjects.add(new BlueSoldier(game, 259, 403, Direction.RIGHT, 50));
        gameObjects.add(new BlueSoldier(game, 137, 411, Direction.DOWN, 15));
        gameObjects.add(new BlueSoldier(game, 128, 110, Direction.UP, 55));

		gameObjects.add(new Rupee(game, 380, 110));
		gameObjects.add(new Rupee(game, 390, 110));
		gameObjects.add(new Rupee(game, 400, 110));
		gameObjects.add(new Rupee(game, 410, 110));
		gameObjects.add(new Rupee(game, 380, 128));
		gameObjects.add(new Rupee(game, 390, 128));
		gameObjects.add(new Rupee(game, 400, 128));
		gameObjects.add(new Rupee(game, 410, 128));
		gameObjects.add(new Warp(game, 393, 108));

		if (!game.getSong().equals("sounds/overworld.mp3"))
		{
			game.stopMusic();
            game.playMusic("sounds/overworld.mp3", true);
        }

        handleSwitchScene(entrance);
    }

	@Override
	public void handleSwitchScene(Rectangle exit)
	{
		if (exit == exitRight1)
		{
			game.setScene(new HouseScene(game, "ForrestScene1"));
		}

        if (exit == exitRight2)
		{
			game.setScene(new HouseScene(game, "ForrestScene2"));
		}

        if (exit == exitUp)
		{
			game.setScene(new HyruleScene(game, "ForrestScene3"));
		}

        if (exit == warpExit)
		{
			game.setScene(new BattleScene(game, "warp"));
		}
	}

	@Override
	public void handleSwitchScene(String entrance)
	{
		if(entrance.equals("HouseSceneLeft1"))
		{
			moveScene(10, 1);

			game.getLink().setXHardCore(462);
			game.getLink().setYHardCore(195);
		}

        if(entrance.equals("HouseSceneLeft2"))
		{
			moveScene(10, 80);

			game.getLink().setXHardCore(459);
			game.getLink().setYHardCore(200);
		}

        if(entrance.equals("HyruleScene"))
		{
			moveScene(1, 1);
			game.getLink().setXHardCore(135);
			game.getLink().setYHardCore(31);
		}

        if(entrance.equals("BattleScene"))
		{
			moveScene(10, 1);
			game.getLink().setXHardCore(382);
			game.getLink().setYHardCore(131);
		}
	}
}
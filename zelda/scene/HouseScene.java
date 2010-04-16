package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.enemy.BlueSoldier;
import zelda.items.Bush;
import zelda.engine.Game;
import zelda.items.Guard;
import zelda.karacter.Direction;

/**
 * Links house.
 *
 * @author maartenhus
 */
public class HouseScene extends ZeldaScene
{
    private Polygon house;
    private Polygon right;
    private Polygon housecliff;
    private Polygon smallcliff;
    private Polygon down;
    private Polygon trees;

	private Rectangle exitUp   = new Rectangle(155, 20, 300, 20);
	private Rectangle exitLeft = new Rectangle(0, 180, 20, 50);

    public HouseScene(Game game, String entrance)
	{
        super(game, "images/link-house.png", entrance);

		exits.add(exitUp);
		exits.add(exitLeft);

        int[] hxpos = {149, 146, 145, 151, 177, 178, 182, 182, 202, 202, 208, 208, 232, 238, 240, 237, 150};
        int[] hypos = {177, 180, 265, 271, 273, 275, 275, 272, 271, 275, 275, 272, 272, 268, 183, 177, 177};

        house = new Polygon(hxpos, hypos, hypos.length);

        int[] rxpos = {449, 450, 385, 384, 418, 416, 492, 511, 510};
        int[] rypos = {0, 27, 90, 180, 215, 292, 370, 373, 1};

        right = new Polygon(rxpos, rypos, rypos.length);

        int[] hcxpos = {1, 55, 81, 84, 119, 251, 303, 304, 275, 125, 112, 110, 126, 276, 278, 240, 127, 108, 108, 120, 122, 73, 49, 49, 1, 1};
        int[] hcypos = {232, 232, 206, 157, 122, 122, 173, 352, 383, 382, 359, 328, 340, 340, 175, 139, 139, 158, 176, 177, 219, 271, 271, 251, 249, 233};

        housecliff = new Polygon(hcxpos, hcypos, hcypos.length);

        int[] scxpos = {0, 47, 56, 56, 63, 64, 68, 69, 66, 49, 0, 0};
        int[] scypos = {383, 382, 378, 369, 362, 353, 348, 330, 328, 342, 342, 382};

        smallcliff = new Polygon(scxpos, scypos, scypos.length);

        int[] dxpos = {1, 71, 87, 124, 137, 171, 206, 207, 256, 303, 512, 512, 1, 1};
        int[] dypos = {441, 440, 424, 424, 442, 440, 476, 486, 488, 436, 433, 487, 488, 442};

        down = new Polygon(dxpos, dypos, dypos.length);

        int[] txpos = {2, 12, 18, 25, 31, 32, 29, 28, 36, 37, 33, 40, 40, 45, 51, 56, 55, 54, 54, 55, 62, 58, 64, 64, 74, 85, 96, 102, 104, 107, 112, 125, 129, 128, 125, 125, 129, 134, 134, 130, 136, 137, 143, 146, 152, 152, 149, 149, 157, 157, 153, 158, 161, 0};
        int[] typos = {190, 190, 180, 183, 183, 178, 176, 171, 168, 166, 160, 150, 132, 132, 136, 136, 131, 128, 124, 121, 118, 113, 100, 86, 87, 86, 83, 94, 96, 96, 84, 88, 88, 83, 79, 75, 73, 72, 68, 65, 54, 36, 38, 41, 40, 33, 30, 25, 25, 22, 16, 11, 0, 0};

        trees = new Polygon(txpos, typos, typos.length);

        solids.add(trees);
        solids.add(housecliff);
        solids.add(smallcliff);
        solids.add(right);
        solids.add(down);
        solids.add(house);

        Bush bush = new Bush(game, 160, 50);
        gameObjects.add(bush);

        gameObjects.add(new Bush(game, 160, 50));
        gameObjects.add(new Bush(game, 272, 51));
        gameObjects.add(new Bush(game, 305, 71));
        gameObjects.add(new Bush(game, 144, 270));
        gameObjects.add(new Bush(game, 128, 270));
        gameObjects.add(new Bush(game, 112, 270));
        gameObjects.add(new Bush(game, 144, 284));
        gameObjects.add(new Bush(game, 128, 284));
        gameObjects.add(new Bush(game, 112, 284));
        gameObjects.add(new Bush(game, 229, 271));
        gameObjects.add(new Bush(game, 229, 287));
        gameObjects.add(new Bush(game, 245, 271));
        gameObjects.add(new Bush(game, 245, 287));
        gameObjects.add(new Bush(game, 34, 272));
        gameObjects.add(new Bush(game, 50, 288));
        gameObjects.add(new Bush(game, 34, 302));
        gameObjects.add(new Bush(game, 50, 272));
        gameObjects.add(new Bush(game, 34, 288));
        gameObjects.add(new Bush(game, 50, 302));
        gameObjects.add(new Bush(game, 419, 333));
        gameObjects.add(new Bush(game, 419, 349));
        gameObjects.add(new Bush(game, 435, 349));
        gameObjects.add(new Bush(game, 435, 365));
        gameObjects.add(new Bush(game, 451, 365));

        gameObjects.add(game.getLink());
        
        gameObjects.add(new BlueSoldier(game, 300, 90, Direction.LEFT, 20));
        gameObjects.add(new BlueSoldier(game, 325, 300, Direction.DOWN, 40));

        gameObjects.add(new Guard(game, 483, 408, Direction.RIGHT));
        gameObjects.add(new Guard(game, 483, 376, Direction.RIGHT));
        gameObjects.add(new Guard(game, 9, 415, Direction.LEFT));
        gameObjects.add(new Guard(game, 9, 385, Direction.LEFT));
        gameObjects.add(new Guard(game, 233, 480, Direction.UP));
        gameObjects.add(new Guard(game, 206, 480, Direction.UP));

		game.playMusic("sounds/overworld.mp3", true);
    }

	@Override
	public void handleSwitchScene(Rectangle exit)
	{
		if (exit == exitUp)
		{
			game.setScene(new HyruleScene(game, "HouseScene"));
		}
	}

	@Override
	public void handleSwitchScene(String entrance)
	{
		if(entrance.equals("GameStart"))
		{
			game.getLink().setXHardCore(100);
			game.getLink().setYHardCore(100);
		}
	}
}
package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.engine.Game;

/**
 *
 * @author Christiaan
 */
public class DungeonScene extends ZeldaScene
{
    Polygon wall2, wall1, table, door;

    private Rectangle zeldaExit = new Rectangle(351, 158, 20, 10);


    public DungeonScene(Game game, String entrance)
	{
        super(game, "images/kerker.png", "DungeonScene");

        exits.add(zeldaExit);

        int[] dxpos = {67, 66, 437, 438, 401, 401, 379, 376, 401, 401, 323, 323, 340, 341, 291, 288, 448, 434, 474, 467, 38, 35, 71};
        int[] dypos = {123, 280, 281, 205, 204, 202, 202, 167, 162, 126, 126, 160, 162, 200, 201, 87, 85, 168, 170, 329, 319, 94, 96};

        wall2 = new Polygon(dxpos, dypos, dypos.length);

        int[] expos = {71, 106, 105, 111, 112, 179, 179, 202, 203, 176, 178, 256, 258, 235, 234, 288, 273, 106};
        int[] eypos = {96, 97, 122, 122, 204, 203, 202, 201, 164, 162, 125, 123, 163, 164, 201, 199, 89, 88};

        wall1 = new Polygon(expos, eypos, eypos.length);

        int[] fxpos = {129, 129, 159, 160, 130};
        int[] fypos = {228, 252, 252, 229, 227};

        table = new Polygon(fxpos, fypos, fypos.length);

//        int[] rxpos = {77, 99, 100, 80};
//        int[] rypos = {124, 125, 117, 116};
//
//        door = new Polygon(rxpos, rypos, rypos.length);

        solids.add(wall2);
        solids.add(wall1);
        solids.add(table);
//        solids.add(door);

        gameObjects.add(game.getLink());

		if (!game.getSong().equals("sounds/castle.mp3"))
        {
            game.stopMusic();
            game.playMusic("sounds/castle.mp3", true);
		}

        handleSwitchScene(entrance);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) 
	{
        if (exit == zeldaExit)
		{
			game.setScene(new CreditScene(game));
		}
    }

    @Override
    public void handleSwitchScene(String entrance)
	{
        if (entrance.equals("ArmosScene"))
		{
            game.getLink().setXHardCore(81);
            game.getLink().setYHardCore(120);
        }
    }
}

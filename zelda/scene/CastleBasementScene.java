package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.enemy.BlueSoldier;
import zelda.enemy.WhiteSoldier;
import zelda.engine.Game;
import zelda.items.Rupee;
import zelda.items.Warp;
import zelda.karacter.Direction;

/**
 *
 * @author Bas Harteveld
 */
public class CastleBasementScene extends ZeldaScene
{
    private Polygon wall1, wall2, wall3, wall4, wall5, wall6, wall7, block1, block2, block3;

	private Rectangle warpExit = new Rectangle(160, 91, 16, 16);
    private Rectangle exitUp   = new Rectangle(749, 56, 27, 20);

    public CastleBasementScene(Game game, String entrance)
	{
        super(game, "images/castlebasement.png", "CastleBasementScene");

        exits.add(warpExit);
        exits.add(exitUp);

        int[] wxpos1 = {752, 752, 709, 709, 748, 748, 554, 590};
        int[] wypos1 = {59, 77, 77, 217, 217, 312, 312, 69};

        wall1 = new Polygon(wxpos1, wypos1, wypos1.length);

        int[] wxpos2 = {554, 554, 584, 593, 708, 708, 578, 578,664, 671, 646, 646, 736, 736, 807, 807, 441, 439};
        int[] wypos2 = {313, 334, 334, 341, 341, 369, 369, 405,407, 574, 575, 702, 701, 827, 827, 902, 902, 600};

        wall2 = new Polygon(wxpos2, wypos2, wypos2.length);

        int[] wxpos3 = {854, 783, 783, 825, 825, 788, 787, 823, 823, 776, 775, 737, 736, 777, 776, 783, 783, 706, 706, 799, 799, 792, 791, 799, 799, 763, 764, 868, 868, 909};
        int[] wypos3 = {38, 57, 77, 78, 215, 218, 311, 312, 333, 334, 341,341, 372, 369, 399, 400, 468, 471, 573, 576, 622, 623, 655, 656, 701, 703, 778, 775, 930, 926};

        wall3 = new Polygon(wxpos3, wypos3, wypos3.length);

        int[] wxpos4 = {868, 399, 399, 179, 177, 98, 98};
        int[] wypos4 = {930, 934, 808, 801, 790, 790, 934};

        wall4 = new Polygon(wxpos4, wypos4, wypos4.length);

        int[] wxpos5 = {437, 264, 264, 248, 248, 153, };
        int[] wypos5 = {678, 678, 748, 748, 680, 678, };

        wall5 = new Polygon(wxpos5, wypos5, wypos5.length);

        int[] bxpos = {437, 264, 264, 248, 248, 153, 153, 184, 184, 327, 334, 338, 431, 434, 448};
        int[] bypos = {678, 678, 748, 748, 680, 678, 439, 439, 411, 411, 442, 438, 439, 424, 424};

        block1 = new Polygon(bxpos, bypos, bypos.length);

        int[] wxpos6 = {97, 97, 73, 73, 114, 111, 145, 33};
        int[] wypos6 = {789, 439, 439, 375, 375, 119, 113, 113};

        wall6 = new Polygon(wxpos6, wypos6, wypos6.length);

        int[] bxpos2 = {216, 201, 201, 216};
        int[] bypos2 = {757, 757, 687, 687};

        block2 = new Polygon(bxpos2, bypos2, bypos2.length);

        int[] bxpos3 = {166, 154, 154, 166};
        int[] bypos3 = {780, 780, 737, 737};

        block3 = new Polygon(bxpos3, bypos3, bypos3.length);

        int[] wxpos7 = {447, 447, 432, 432, 417, 417, 352, 352, 337, 337, 323, 323, 187, 192, 145, 145, 189, 189, 148, 148, 148, 189, 447};
        int[] wypos7 = {421, 368, 368, 359, 359, 336, 338, 358, 358, 365, 365, 377, 377, 366, 366, 155, 155, 80, 80, 112, 80, 80, 30};

        wall7 = new Polygon(wxpos7, wypos7, wypos7.length);

        solids.add(wall1);
        solids.add(wall2);
        solids.add(wall3);
        solids.add(wall4);
        solids.add(wall5);
        solids.add(wall6);
        solids.add(wall7);
        solids.add(block1);
        solids.add(block2);
        solids.add(block3);

        gameObjects.add(game.getLink());
		//game.getLink().setRupee(game.getLink().getRupee() - 240);

        gameObjects.add(new BlueSoldier(game, 755, 195, Direction.UP, 60));
        gameObjects.add(new BlueSoldier(game, 675, 399, Direction.UP, 110));
        gameObjects.add(new BlueSoldier(game, 740, 794, Direction.DOWN, 80));
        gameObjects.add(new BlueSoldier(game, 126, 703, Direction.DOWN, 120));
        gameObjects.add(new BlueSoldier(game, 331, 385, Direction.RIGHT, 70));

        gameObjects.add(new WhiteSoldier(game, 637, 905, Direction.LEFT));

        gameObjects.add(new Rupee(game, 355, 368));
        gameObjects.add(new Rupee(game, 363, 368));
        gameObjects.add(new Rupee(game, 371, 368));
        gameObjects.add(new Rupee(game, 379, 368));
        gameObjects.add(new Rupee(game, 387, 368));
        gameObjects.add(new Rupee(game, 395, 368));
        gameObjects.add(new Rupee(game, 403, 368));
        gameObjects.add(new Rupee(game, 355, 382));
        gameObjects.add(new Rupee(game, 363, 382));
        gameObjects.add(new Rupee(game, 371, 382));
        gameObjects.add(new Rupee(game, 379, 382));
        gameObjects.add(new Rupee(game, 387, 382));
        gameObjects.add(new Rupee(game, 395, 382));
        gameObjects.add(new Rupee(game, 403, 382));
        gameObjects.add(new Rupee(game, 355, 396));
        gameObjects.add(new Rupee(game, 363, 396));
        gameObjects.add(new Rupee(game, 371, 396));
        gameObjects.add(new Rupee(game, 379, 396));
        gameObjects.add(new Rupee(game, 387, 396));
        gameObjects.add(new Rupee(game, 395, 396));
        gameObjects.add(new Rupee(game, 403, 396));

        gameObjects.add(new Warp (game, 160, 91));

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
        if (exit == warpExit)
        {
			game.setScene(new ArmosScene(game, "CastleBasementScene"));
        }
        if (exit == exitUp)
		{
            game.setScene(new CastleScene(game, "CastleBasementScene"));
		}
	}

	@Override
	public void handleSwitchScene(String entrance)
	{
        if(entrance.equals("CastleScene"))
		{
			moveScene(482, 1);

			game.getLink().setXHardCore(275);
			game.getLink().setYHardCore(86);
		}
	}
}

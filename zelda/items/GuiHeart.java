package zelda.items;

import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.engine.Game;

/**
 *
 * @author Bas Harteveld
 */
public class GuiHeart extends GObject
{
    private final static String[] fullAnimation	 = {"full"};
    private final static String[] emptyAnimation = {"empty"};

    private static int i = 0;
    private static GuiHeart[] hearts = new GuiHeart[5];

    private boolean full = true;

    public GuiHeart(Game game, int x, int y)
    {
        super(game, x, y, 11, 10, "images/guihearts2.png");
        spriteLoc.put("full", new Rectangle(0, 0, 11, 10));
        spriteLoc.put("empty", new Rectangle(11, 0, 11, 10));

        sprite.setSprite(spriteLoc.get("full"));
        setAnimation(fullAnimation);

		z = 2;

		screenAdjust = false;
        checkcollision = false;
        liquid = true;

        if(i < 5)
        {
            hearts[i] = this;
            i++;
        }
    }

    @Override
    public void preAnimation()
    {
        int empty = 5 - game.getLink().getHealth();

        //System.out.println(empty);
        for (int j = 0; j < 5; j++)
        {
            if( j >= (5 - empty))
            {
                hearts[j].setFull(false);
            }
            else
            {
                hearts[j].setFull(true);
            }
        }

        if (full)
        {
            setAnimation(fullAnimation);
        }
        else
        {
            setAnimation(emptyAnimation);
        }
    }

    public void setFull(boolean full)
    {
        this.full = full;
    }

	public static void clear()
	{
		i = 0;
	}
}

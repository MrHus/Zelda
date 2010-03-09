package zelda.link;

import zelda.ZeldaGame;
import java.awt.Rectangle;
import java.util.HashMap;
import zelda.karacter.Direction;
import zelda.karacter.Karacter;

/**
 *
 * @author maartenhus
 */
public class Link extends Karacter
{
	private final HashMap<String, Rectangle> spriteLoc = new HashMap<String, Rectangle>();

	private boolean aPressed = false;
	private boolean	sPressed = false;
	private boolean dPressed = false;
	private boolean wPressed = false;
	private boolean jPressed = false;
	private boolean kPressed = false;
	private boolean lPressed = false;

	private long inputInterval = 50;
	private long lastInput = System.currentTimeMillis();

	public Link(ZeldaGame game, int x, int y)
	{
		super(game, x, y, 17, 20, Direction.DOWN, "images/link.png");
		spriteLoc.put("Link walk down 1",		new Rectangle(0, 0, 16, 23));
		spriteLoc.put("Link walk down 2",		new Rectangle(25, 0, 16, 23));
		spriteLoc.put("Link walk down 3",		new Rectangle(50, 0, 16, 23));
		spriteLoc.put("Link stand down",		new Rectangle(75, 0, 16, 23));
		spriteLoc.put("Link walk down 4",		new Rectangle(100, 0, 16, 23));
		spriteLoc.put("Link walk down 5",		new Rectangle(125, 0, 16, 23));
		spriteLoc.put("Link walk down 6",		new Rectangle(150, 0, 16, 23));

		spriteLoc.put("Link walk up 1",			new Rectangle(0, 25, 17, 23));
		spriteLoc.put("Link walk up 2",			new Rectangle(25, 25, 17, 23));
		spriteLoc.put("Link walk up 3",			new Rectangle(50, 25, 17, 23));
		spriteLoc.put("Link stand up",			new Rectangle(75, 25, 17, 23));
		spriteLoc.put("Link walk up 4",			new Rectangle(100, 25, 17, 23));
		spriteLoc.put("Link walk up 5",			new Rectangle(125, 25, 17, 23));
		spriteLoc.put("Link walk up 6",			new Rectangle(150, 25, 17, 23));

		spriteLoc.put("Link walk left 1",		new Rectangle(0, 50, 19, 24));
		spriteLoc.put("Link walk left 2",		new Rectangle(25, 50, 19, 24));
		spriteLoc.put("Link walk left 3",		new Rectangle(50, 50, 19, 24));
		spriteLoc.put("Link stand left",		new Rectangle(75, 50, 19, 24));
		spriteLoc.put("Link walk left 4",		new Rectangle(100, 50, 19, 24));
		spriteLoc.put("Link walk left 5",		new Rectangle(125, 50, 19, 24));
		spriteLoc.put("Link walk left 6",		new Rectangle(150, 50, 19, 24));

		spriteLoc.put("Link walk right 1",		new Rectangle(0, 75, 19, 24));
		spriteLoc.put("Link walk right 2",		new Rectangle(25, 75, 19, 24));
		spriteLoc.put("Link walk right 3",		new Rectangle(50, 75, 19, 24));
		spriteLoc.put("Link stand right",		new Rectangle(75, 75, 19, 24));
		spriteLoc.put("Link walk right 4",		new Rectangle(100, 75, 19, 24));
		spriteLoc.put("Link walk right 5",		new Rectangle(125, 75, 19, 24));
		spriteLoc.put("Link walk right 6",		new Rectangle(150, 75, 19, 24));

		spriteLoc.put("Link sword down 1",		new Rectangle(0, 100, 19, 24));
		spriteLoc.put("Link sword down 2",		new Rectangle(25, 100, 20, 30));
		spriteLoc.put("Link sword down 3",		new Rectangle(50, 100, 19, 32));
		spriteLoc.put("Link sword down 4",		new Rectangle(75, 100, 19, 32));
		spriteLoc.put("Link sword down 5",		new Rectangle(100, 100, 29, 30));
		spriteLoc.put("Link sword down 6",		new Rectangle(130, 100, 33, 28));

		spriteLoc.put("Link sword up 1",		new Rectangle(0, 150, 24, 23));
		spriteLoc.put("Link sword up 2",		new Rectangle(25, 150, 23, 23));
		spriteLoc.put("Link sword up 3",		new Rectangle(50, 150, 24, 25));
		spriteLoc.put("Link sword up 4",		new Rectangle(75, 150, 22, 31));
		spriteLoc.put("Link sword up 5",		new Rectangle(100, 150, 20, 33));
		spriteLoc.put("Link sword up 6",		new Rectangle(125, 150, 20, 35));
		spriteLoc.put("Link sword up 7",		new Rectangle(150, 150, 24, 30));
		spriteLoc.put("Link sword up 8",		new Rectangle(32, 174, 30, 26));
		spriteLoc.put("Link sword up 9",		new Rectangle(0, 175, 32, 23));

		spriteLoc.put("Link sword right 1",		new Rectangle(0, 200, 16, 23));
		spriteLoc.put("Link sword right 2",		new Rectangle(25, 200, 19, 23));
		spriteLoc.put("Link sword right 3",		new Rectangle(50, 200, 24, 24));
		spriteLoc.put("Link sword right 4",		new Rectangle(75, 200, 26, 24));
		spriteLoc.put("Link sword right 5",		new Rectangle(102, 200, 30, 22));
		spriteLoc.put("Link sword right 6",		new Rectangle(132, 200, 32, 25));
		spriteLoc.put("Link sword right 7",		new Rectangle(0, 225, 29, 23));
		spriteLoc.put("Link sword right 8",		new Rectangle(29, 225, 29, 29));
		spriteLoc.put("Link sword right 9",		new Rectangle(74, 225, 24, 30));

		spriteLoc.put("Link sword left 1",		new Rectangle(100, 225, 16, 23));
		spriteLoc.put("Link sword left 2",		new Rectangle(125, 225, 18, 23));
		spriteLoc.put("Link sword left 3",		new Rectangle(150, 225, 23, 24));
		spriteLoc.put("Link sword left 4",		new Rectangle(0, 250, 25, 25));
		spriteLoc.put("Link sword left 5",		new Rectangle(25, 254, 29, 21));
		spriteLoc.put("Link sword left 6",		new Rectangle(56, 254, 31, 21));
		spriteLoc.put("Link sword left 7",		new Rectangle(94, 254, 28, 21));
		spriteLoc.put("Link sword left 8",		new Rectangle(125, 253, 28, 28));
		spriteLoc.put("Link sword left 9",		new Rectangle(153, 250, 22, 31));
		
		sprite.setSprite(spriteLoc.get("Link stand down"));

		state = new StandState(this);
	}

	public void handleInput()
	{
		if (System.currentTimeMillis() > lastInput + inputInterval)
		{
			state.handleInput();
			lastInput = System.currentTimeMillis();
		}
	}

	@Override
	public void preAnimation()
	{
		state.handleAnimation();
	}

	public boolean moveinput()
	{
		return (aPressed || dPressed || wPressed || sPressed);
	}

	public boolean noMoveinput()
	{
		return (!aPressed && !dPressed && !wPressed && !sPressed);
	}

	public void setaPressed(boolean aPressed)
	{
		this.aPressed = aPressed;
	}

	public void setdPressed(boolean dPressed)
	{
		this.dPressed = dPressed;
	}

	public void setjPressed(boolean jPressed)
	{
		this.jPressed = jPressed;
	}

	public void setkPressed(boolean kPressed)
	{
		this.kPressed = kPressed;
	}

	public void setlPressed(boolean lPressed)
	{
		this.lPressed = lPressed;
	}

	public void setsPressed(boolean sPressed)
	{
		this.sPressed = sPressed;
	}

	public void setwPressed(boolean wPressed)
	{
		this.wPressed = wPressed;
	}

	public boolean isaPressed()
	{
		return aPressed;
	}

	public boolean isdPressed()
	{
		return dPressed;
	}

	public boolean isjPressed()
	{
		return jPressed;
	}

	public boolean iskPressed()
	{
		return kPressed;
	}

	public boolean islPressed()
	{
		return lPressed;
	}

	public boolean issPressed()
	{
		return sPressed;
	}

	public boolean iswPressed()
	{
		return wPressed;
	}

	public HashMap<String, Rectangle> getSpriteLoc()
	{
		return spriteLoc;
	}
}

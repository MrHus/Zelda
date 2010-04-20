package zelda.link;

import java.awt.Rectangle;
import zelda.enemy.Soldier;
import zelda.enemy.armos.ArmosKnight;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.items.Bomb;
import zelda.items.Heart;
import zelda.items.Rupee;
import zelda.karacter.Direction;
import zelda.karacter.Karacter;

/**
 * The players avatar in the game.
 *
 * @author maartenhus
 */
public class Link extends Karacter
{
	private long inputInterval = 50;
	private long lastInput = System.currentTimeMillis();
    private long lastHit = System.currentTimeMillis();

	private long bomInterval = 3000;
	private long lastBom = System.currentTimeMillis();

	private long arrowInterval = 1000;
	private long lastArrow = System.currentTimeMillis();

    private int rupee = 0;

	public Link(Game game, int x, int y)
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

        spriteLoc.put("Link bow down 1",		new Rectangle(0, 300, 17, 25));
		spriteLoc.put("Link bow down 2",		new Rectangle(25, 300, 18, 21));
		spriteLoc.put("Link bow down 3",		new Rectangle(50, 300, 18, 22));

        spriteLoc.put("Link bow left 1",		new Rectangle(0, 325, 17, 22));
		spriteLoc.put("Link bow left 2",		new Rectangle(25, 325, 19, 21));
		spriteLoc.put("Link bow left 3",		new Rectangle(50, 325, 20, 20));

        spriteLoc.put("Link bow right 1",		new Rectangle(0, 350, 17, 23));
		spriteLoc.put("Link bow right 2",		new Rectangle(25, 350, 22, 23));

        spriteLoc.put("Link bow up 1",          new Rectangle(0, 375, 18, 22));
		spriteLoc.put("Link bow up 2",          new Rectangle(25, 375, 21, 21));
		spriteLoc.put("Link bow up 3",          new Rectangle(50, 375, 21, 22));

        spriteLoc.put("Link hit right",         new Rectangle(0, 425, 17, 21));
        spriteLoc.put("Link death right",       new Rectangle(50, 425, 27, 15));
		spriteLoc.put("Link death right 2",     new Rectangle(25, 425, 27, 19));
		

        spriteLoc.put("Link hit left",          new Rectangle(0, 450, 17, 21));
        spriteLoc.put("Link death left",        new Rectangle(50, 450, 24, 15));
		spriteLoc.put("Link death left 2",      new Rectangle(25, 450, 23, 19));
		
        
		sprite.setSprite(spriteLoc.get("Link stand down"));

		z = 2;
        health = 5;

		screenAdjust = false;

		state = new StandState(this);
	}

    public void dropBomb()
    {
		if (System.currentTimeMillis() > lastBom + bomInterval)
		{
			switch (direction)
			{
				case UP:
					game.getScene().addNewGObject(new Bomb(game, x + 2, y - 16));
					break;

				case DOWN:
					game.getScene().addNewGObject(new Bomb(game, x + 2, y + getHeight()));
					break;

				case LEFT:
					game.getScene().addNewGObject(new Bomb(game, x - 13, y + 7));
					break;

				case RIGHT:
					game.getScene().addNewGObject(new Bomb(game, x + getWidth(), y + 7));
					break;
			}

			lastBom = System.currentTimeMillis();
		}
    }

	public void shootArrow()
	{
		if (System.currentTimeMillis() > lastArrow + arrowInterval)
		{
			setState(new BowState(this));
			lastArrow = System.currentTimeMillis();
		}
	}

	public void handleInput()
	{
		//System.out.println("Link is at:");
		//System.out.println(x + ", " + y);

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

	@Override
	protected void collision(GObject hitObject)
	{
        if (health == 0)
        {
            if(!getStateString().equals("DeathState"))
            {
				game.stopMusic();
                game.playFx("sounds/killed.mp3");
                setState(new DeathState(this, getDirection()));
                //alive = false;
            }            
        }

		if (hitObject instanceof Soldier)
		{
            if (health > 0 && System.currentTimeMillis() > lastHit + 800)
            {
               game.playFx("sounds/linkHurt.mp3");
               health --;
               lastHit = System.currentTimeMillis();

               //System.out.println("leven: " + health);
               Soldier soldier = (Soldier)hitObject;
               setState(new TransState(this, soldier.getDirection()));
            }
        }
        
        if (hitObject instanceof ArmosKnight)
        {
            if (health > 0 && System.currentTimeMillis() > lastHit + 800)
            {
               game.playFx("sounds/linkHurt.mp3");
               health --;
               lastHit = System.currentTimeMillis();

               //System.out.println("leven: " + health);
               ArmosKnight armosKnight = (ArmosKnight)hitObject;
               setState(new TransState(this, armosKnight.getDirection()));
            }
		}
        
        if (hitObject instanceof Heart)
        {
            if (health < 5)
            {
               game.playFx("sounds/getItem.mp3");
               health++;
            }
        }

        if (hitObject instanceof Rupee)
        {
            game.playFx("sounds/getItem.mp3");
            rupee += 5;
        }
   }

	//Handy dandy stuff that handles input
	public boolean moveinput()
	{
		return (game.isaPressed() || game.isdPressed() || game.iswPressed() || game.issPressed());
	}

	public boolean noMoveinput()
	{
        return (!game.isaPressed() && !game.isdPressed() && !game.iswPressed() && !game.issPressed());
	}

    public int getRupee()
    {
        return rupee;
    }

    public void setRupee(int rupee)
    {
        this.rupee = rupee;
    }
}
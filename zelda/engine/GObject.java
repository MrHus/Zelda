package zelda.engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.HashMap;
import zelda.items.Heart;
import zelda.items.Rupee;

/**
 * A GObject is something that gets drawn on the View, checks if it collides and animates itself.
 *
 * @author maartenhus
 */
public abstract class GObject implements DrawAble
{
	protected Game game;
	protected boolean alive = true;

	protected int x;
	protected int y;
	protected int z = 0;
	
	protected int width;
	protected int height;

	protected boolean checkcollision = true; // Should the objects check for collisions when x or y moves.
	protected boolean liquid = false;		 // Can other GObjects move through the object.
	protected boolean screenAdjust = true;    // Does this object adjust its position when the screen moves.

	protected Sprite sprite;
	protected static HashMap<String, Rectangle> spriteLoc = new HashMap<String, Rectangle>();
	protected String[] animation;
	protected int animationCounter = 0;
	protected long animationInterval;
	protected long lastAnimation = System.currentTimeMillis();

	public GObject(Game game, int x, int y, int width, int height, String image)
	{
		animationInterval = 90;
		this.game = game;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		sprite = new Sprite(image);
	}

	/**
	 * What the GObject is supposed to do in the loop.
	 */
	public void doInLoop(){}

	/**
	 * What the GObject needs to do pre animation.
	 */
	protected void preAnimation(){}

	/**
	 * What the GObject needs to do post animation.
	 */
	protected void postAnimation(){}

	/**
	 * What the GObject does when it has a collision.
	 * @param hitObject
	 */
	protected void collision(GObject hitObject){}
    protected void wallCollision(){}
    
	public void animate()
	{
		if (System.currentTimeMillis() > lastAnimation + animationInterval) // if it time to reanimate
		{
			preAnimation();

			//System.out.println("Animation " + animationCounter + " == " + animation.length);
			if (animationCounter == animation.length) // if all animations are done.
			{
				//reset the counter.
				animationCounter = 0;
			}

			try
			{
				// Set the next animation image of the GObject.
				sprite.setSprite(spriteLoc.get(animation[animationCounter]));
			}
			catch (Exception e)
			{
				//System.out.println("Animation " + animationCounter + " == " + animation.length);
				animationCounter = 0;
			}

			animationCounter += 1;
			lastAnimation = System.currentTimeMillis();

			postAnimation();
		}
	}

	public void draw(Graphics2D g)
	{
		Image img = sprite.getImage();
		g.drawImage(img, x, y, sprite.getWidth(), sprite.getHeight(), null);
	}

	private boolean isCollision(int newX, int newY)
	{
		Rectangle rect = new Rectangle(newX, newY, width, height);
		boolean collision = false;

		for (Polygon poly : game.getScene().getSolids()) //for each solid object
		{
			final Area area = new Area();
			area.add(new Area(rect));
			area.intersect(new Area(poly)); //check if there is a collision

			if (!area.isEmpty()) // if isEmpty is false there is a collision
			{
				collision = true;
                wallCollision();
			}
		}

		for (GObject obj : game.getScene().getGObjects())
		{
			if(obj.isCheckcollision())
			{
				final Area area = new Area();
				area.add(new Area(rect));
				area.intersect(new Area(obj.getRectangle()));

				if (!area.isEmpty() && this != obj) // if area is empty, and the obj is not isself. (Self-collision)
				{
					collision(obj); //report collision to self, with the object that hit it.
					obj.collision(this); //report collision to object that got hit with itself.

					if (!obj.isLiquid())
					{
						collision = true;
					}
				}
			}
		}

		return collision;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int newX)
	{
		if (!checkcollision || !isCollision(newX, y))
		{
			x = newX;
		}
	}

	public int getY()
	{
		return y;
	}

	public void setY(int newY)
	{
		if (!checkcollision || !isCollision(x, newY))
		{
			y = newY;
		}
	}

	public int getZ()
	{
		return z;
	}

    public void setYHardCore(int y)
	{
		this.y = y;
	}

    public void setXHardCore(int x)
	{
		this.x = x;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public Game getGame()
	{
		return game;
	}

	public boolean isAlive()
	{
		return alive;
	}

	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}

	public String[] getAnimation()
	{
		return animation;
	}

	public void setAnimation(String[] animation)
	{
		this.animation = animation;
	}

	public void resetAnimationCounter()
	{
		animationCounter = 0;
	}

	public int getAnimationCounter()
	{
		return animationCounter;
	}

	public long getAnimationInterval()
	{
		return animationInterval;
	}

	public void setAnimationInterval(long animationInterval)
	{
		this.animationInterval = animationInterval;
	}

	public boolean isCheckcollision()
	{
		return checkcollision;
	}

	public void setCheckcollision(boolean checkcollision)
	{
		this.checkcollision = checkcollision;
	}

	public boolean isLiquid()
	{
		return liquid;
	}

	public void setLiquid(boolean liquid)
	{
		this.liquid = liquid;
	}

	public boolean isScreenAdjust()
	{
		return screenAdjust;
	}

	public void setScreenAdjust(boolean screenAdjust)
	{
		this.screenAdjust = screenAdjust;
	}

    public void randomGoodie()
    {
        int r = (int)(Math.random()*200);
        //System.out.println(r);

        if (r < 50)
        {
            if (r < 25)
            {
                game.getScene().addNewGObject(new Heart (game, x, y));
            }
            else
            {
                game.getScene().addNewGObject(new Rupee (game, x, y));
            }
        }
    }
}

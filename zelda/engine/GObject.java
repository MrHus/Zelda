package zelda.engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.HashMap;

/**
 *
 * @author maartenhus
 */
public abstract class GObject implements DrawAble
{
	protected Game game;
	protected Scene scene;
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	protected Sprite sprite;
	protected HashMap<String, Rectangle> spriteLoc = new HashMap<String, Rectangle>();
	protected String[] animation;

	protected int animationCounter = 0;
	protected long animationInterval;
	protected long lastAnimation = System.currentTimeMillis();

	public GObject(Game game, int x, int y, int width, int height, String image)
	{
		animationInterval = 90;
		this.game = game;
		this.scene = game.getScene();

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		sprite = Sprite.getSprite(image);
	}

	public void animate()
	{
		if (System.currentTimeMillis() > lastAnimation + animationInterval)
		{
			preAnimation();

			//System.out.println("Animation " + animationCounter + " == " + animation.length);
			if (animationCounter == animation.length)
			{
				animationCounter = 0;
			}

			sprite.setSprite(spriteLoc.get(animation[animationCounter]));
			animationCounter += 1;
			lastAnimation = System.currentTimeMillis();

			postAnimation();
		}
	}

	public void preAnimation(){}
	public void postAnimation(){}

	public void draw(Graphics2D g)
	{
		Image img = sprite.getImage();		
		g.drawImage(img, x, y, sprite.getWidth(), sprite.getHeight(), null);
	}

	private boolean collision(int newX, int newY)
	{
		Rectangle rect = new Rectangle(newX, newY, width, height);

		for (Polygon poly : scene.getSolids())
		{
			final Area area = new Area();
			area.add(new Area(rect));
			area.intersect(new Area(poly));

			if(!area.isEmpty())
			{
				return true;
			}
		}

		return false;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int newX)
	{
		if (!collision(newX, y))
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
		if(!collision(x, newY))
		{
			y = newY;
		}
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

	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}

	public void setWidth(int width)
	{
		this.width = width;
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
}

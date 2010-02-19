package zelda.engine;

import zelda.Game;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.HashMap;

/**
 *
 * @author maartenhus
 */
public abstract class GObject implements DrawAble
{
	protected Game game;

	protected int x;
	protected int y;

	protected Sprite sprite;
	protected HashMap<String, Rectangle> spriteLoc = new HashMap<String, Rectangle>();
	protected String[] animation;

	protected int animationCounter = 0;
	protected long animationInterval;
	protected long lastAnimation = System.currentTimeMillis();

	public GObject(Game game, int x, int y, String image)
	{
		animationInterval = game.getGameSpeed() * 5;
		this.game = game;
		this.x = x;
		this.y = y;
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

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
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

	public void modAnimationInterval(int modifier)
	{
		this.animationInterval = game.getGameSpeed() * modifier;
	}
}

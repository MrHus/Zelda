package zelda.engine;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import zelda.Main;

/**
 * @author maartenhus
 */
public class Sprite
{
	private BufferedImage image;
	private int x, y, width, height;

	private boolean spriteChanged;

	public Sprite(String img)
	{
		URL imageUrl = Main.class.getResource(img);

		try
		{
			image = ImageIO.read(imageUrl);
		}
		catch(IOException e){}
	}

	public void setSprite(Rectangle rect)
	{
		this.x = (int)rect.getX();
		this.y = (int)rect.getY();
		this.width = (int)rect.getWidth();
		this.height = (int)rect.getHeight();
		spriteChanged = true;
	}

	public Image getImage()
	{
		return image.getSubimage(x, y, width, height);
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
		spriteChanged = true;
	}

	public void setY(int y)
	{
		this.y = y;
		spriteChanged = true;
	}

	public int getY()
	{
		return y;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public int getImageWidth()
	{
		return image.getWidth();
	}

	public int getImageHeight()
	{
		return image.getHeight();
	}

	public boolean isSpriteChanged()
	{
		return spriteChanged;
	}

	public void setSpriteChanged(boolean spriteChanged)
	{
		this.spriteChanged = spriteChanged;
	}
}

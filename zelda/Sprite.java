package zelda;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * @author maartenhus
 */
public class Sprite
{
	private BufferedImage image;
	private int x, y, width, height;

	public Sprite(String img)
	{
		URL imageUrl = Sprite.class.getResource(img);

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
	}

	public Image getImage()
	{
		return image.getSubimage(x, y, width, height);
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}
}

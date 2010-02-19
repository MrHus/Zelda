package zelda.engine;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 * @author maartenhus
 */
public class Sprite
{
	private static HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();
	private BufferedImage image;
	private int x, y, width, height;

	private Sprite(String img)
	{
		URL imageUrl = Sprite.class.getResource(img);

		try
		{
			image = ImageIO.read(imageUrl);
		}
		catch(IOException e){}
	}

	public static Sprite getSprite(String img)
	{
		if(sprites.containsKey(img))
		{
			return sprites.get(img);
		}
		else
		{
			Sprite sprite = new Sprite(img);
			sprites.put(img, sprite);
			return sprite;
		}
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

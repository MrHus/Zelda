package zelda;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Shape;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import zelda.engine.GObject;

/**
 *
 * @author maartenhus
 */
public class View
{
	private ZeldaGame game;

	private BufferStrategy buffer;
	private BufferedImage bi;
	private GraphicsDevice gd;

	private int displayWidth   = 640;
	private int displayHeight  = 480;

	private int x;
	private int y;

	public View(ZeldaGame game, JFrame frame)
	{
		this.game = game;

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();

		//gd.setFullScreenWindow(frame);

		if (gd.isDisplayChangeSupported())
		{
			//gd.setDisplayMode(new DisplayMode(displayWidth, displayHeight, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
		}

		frame.createBufferStrategy(2);
		frame.setBackground(Color.BLACK);
		buffer = frame.getBufferStrategy();
		bi = gc.createCompatibleImage(game.getWidth(), game.getHeight());

		x = (displayWidth - game.getWidth()) /2;
		y = (displayHeight - game.getHeight()) /2;
	}	

	public void draw()
	{
		Graphics graphics = buffer.getDrawGraphics();
		Graphics2D g2 = bi.createGraphics();

		g2.setColor(Color.black);

		//System.out.println("draw");
		game.getScene().draw(g2);

		g2.setColor(Color.red);

		for (GObject obj : game.getScene().getGObjects())
		{
			g2.draw(obj.getRectangle());
			obj.animate();
			obj.draw(g2);
		}

		for (Shape s : game.getScene().getSolids())
		{
			g2.draw(s);
		}

		//graphics.drawImage(bi, x, y, null);
		graphics.drawImage(bi, 0, 0, null);

		if (!buffer.contentsLost())
			buffer.show();

		graphics.dispose();
		g2.dispose();
	}

	public void exitFullScreen()
	{
		gd.setFullScreenWindow(null);
	}
}

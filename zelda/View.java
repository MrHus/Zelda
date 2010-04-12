package zelda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import zelda.engine.GObject;
import zelda.engine.Game;

/**
 * This class handles all the drawing.
 *
 * @author maartenhus
 */
public class View
{
	private Game game;

	private BufferStrategy buffer;
	private BufferedImage bi;
	private GraphicsDevice gd;

	private int displayWidth   = 640;
	private int displayHeight  = 480;

	private int x;
	private int y;

	public View(Game game, JFrame frame)
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

		//calculate the x and y for centering in fullscreen mode.
		//x = (displayWidth - game.getWidth()) /2;
		//y = (displayHeight - game.getHeight()) /2;
	}	

	public void draw()
	{
		Graphics graphics = buffer.getDrawGraphics();
		Graphics2D g2 = bi.createGraphics();

		//for background in fullscreen.
		g2.setColor(Color.black);

		//System.out.println("draw");
		game.getScene().draw(g2);

		g2.setColor(Color.red);

		//animate, and draw every GObject from Scene
		for (GObject obj : game.getScene().getGObjects())
		{
			g2.draw(obj.getRectangle());
			if (!game.isPaused())
			{
				obj.animate();
			}
			else
			{
				g2.setColor(Color.white);
				g2.drawString("-- Pauzed --", game.getWidth() / 2 - 30, game.getHeight() / 2);
				g2.setColor(Color.red);
			}

			obj.draw(g2);
		}

		//Draw solids on the map
		for (Shape s : game.getScene().getSolids())
		{
			g2.draw(s);
		}

		//draw blue box when link strikes debug
		for (Rectangle r : game.getScene().getHitters())
		{
			g2.setColor(Color.blue);
			g2.draw(r);
		}

        //draw green box for eye views
		for (Shape v : game.getScene().getEyeViews())
		{
			g2.setColor(Color.green);
			g2.draw(v);
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

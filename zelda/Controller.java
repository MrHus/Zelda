package zelda;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import zelda.engine.Scene;
import zelda.link.Link;
import zelda.link.LinkController;

/**
 *
 * @author maartenhus
 */
public class Controller implements Runnable
{

	private Thread thread;
	private ZeldaGame game;
	private View view;
	private Link link;
	private Scene scene;
	//private PolyCreator polyCreator;
	private BufferStrategy buffer;
	private BufferedImage bi;
	private GraphicsDevice gd;

	private int displayWidth   = 640;
	private int displayHeight  = 480;

	private int x;
	private int y;

	public Controller(ZeldaGame game, View view, final JFrame frame)
	{
		this.game = game;
		this.view = view;
		link = game.getLink();  //handles input
		scene = game.getScene();//handles input

		//frame.addMouseListener(new PolyCreator(scene));
		frame.addKeyListener(new LinkController(link));

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		
		gd.setFullScreenWindow(frame);

		if (gd.isDisplayChangeSupported())
		{
			gd.setDisplayMode(new DisplayMode(displayWidth, displayHeight, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
		}

		frame.createBufferStrategy(2);
		frame.setBackground(Color.BLACK);
		buffer = frame.getBufferStrategy();
		bi = gc.createCompatibleImage(game.getWidth(), game.getHeight());

		x = (displayWidth - game.getWidth()) /2;
		y = (displayHeight - game.getHeight()) /2;

		thread = new Thread(this);
		thread.start();
	}

	public void run()
	{
		while (game.isRunning())
		{
			try
			{
				scene.handleInput();
				link.handleInput();

				Graphics graphics = buffer.getDrawGraphics();
				Graphics2D g2d = bi.createGraphics();

				g2d.setColor(Color.black);

				view.draw(g2d);

				graphics.drawImage(bi, x, y, null);

				if (!buffer.contentsLost())
				{
					buffer.show();
				}

				graphics.dispose();
				g2d.dispose();

				Thread.sleep(game.getGameSpeed());
			}
			catch (InterruptedException e){}
		}

		gd.setFullScreenWindow(null);
		System.exit(0);
	}
}

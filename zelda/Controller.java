package zelda;

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
	private BufferStrategy bs;
	private Link link;
	private Scene scene;
	//private PolyCreator polyCreator;
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private GraphicsDevice gd = ge.getDefaultScreenDevice();
	private GraphicsConfiguration gc = gd.getDefaultConfiguration();

	public Controller(ZeldaGame game, View view, JFrame frame)
	{
		this.game = game;
		this.view = view;
		link = game.getLink();  //handles input
		scene = game.getScene();//handles input

		//frame.addMouseListener(new PolyCreator(scene));
		frame.addKeyListener(new LinkController(link));

		frame.createBufferStrategy(2);
		bs = frame.getBufferStrategy();

		thread = new Thread(this);
		thread.start();
	}

	public void run()
	{
		while (true)
		{
			try
			{

				scene.handleInput();
				link.handleInput();

				BufferedImage bi = gc.createCompatibleImage(game.getWidth(), game.getHeight());
				Graphics graphics = bs.getDrawGraphics();

				Graphics2D g2d = bi.createGraphics();
				view.draw(g2d);
				graphics.drawImage(bi, 0, 0, null);

				if (!bs.contentsLost())
					bs.show();

				graphics.dispose();
				g2d.dispose();

				Thread.sleep(game.getGameSpeed());
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}

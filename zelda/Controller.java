package zelda;

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
	private JFrame frame;
	private Link link;
	private Scene scene;

	public Controller(ZeldaGame game, View view, JFrame frame)
	{
		this.game = game;
		this.view = view;
		link = game.getLink();
		scene = game.getScene();

		frame.addKeyListener(new LinkController(link));

		thread = new Thread(this);
		thread.start();
	}

	public void run()
	{
		while (true)
		{
			scene.handleInput();
			link.handleInput();
			view.repaint();

			try
			{
				Thread.sleep(game.getGameSpeed());
			}
			catch(InterruptedException e){}
		}
	}
}

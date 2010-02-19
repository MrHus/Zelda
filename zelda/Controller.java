package zelda;

import javax.swing.JFrame;
import zelda.engine.GObject;
import zelda.link.Link;
import zelda.link.LinkController;

/**
 *
 * @author maartenhus
 */
public class Controller implements Runnable
{
	private Thread thread;

	private Game game;
	private View view;
	private JFrame frame;
	private Link link;

	public Controller(Game game, View view, JFrame frame)
	{
		this.game = game;
		this.view = view;
		link = game.getLink();

		frame.addKeyListener(new LinkController(link));

		thread = new Thread(this);
		thread.start();
	}

	public void run()
	{
		while (true)
		{
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

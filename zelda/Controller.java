package zelda;

import javax.swing.JFrame;
import zelda.engine.GObject;
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

	public Controller(Game game, View view, JFrame frame)
	{
		this.game = game;
		this.view = view;

		frame.addKeyListener(new LinkController(game.getLink()));

		thread = new Thread(this);
		thread.start();
	}

	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(game.getGameSpeed());

				for(GObject obj : game.getGObjects())
				{
					obj.animate();
				}
				
				view.repaint();
				//System.out.println("repaint");
			}
			catch(InterruptedException e){}
		}
	}
}

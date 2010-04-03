package zelda;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import zelda.engine.GObject;
import zelda.engine.Scene;
import zelda.link.Link;

/**
 * The Controller is reponsible for the gameloop.
 * And it handles user keyinput for the game.
 *
 * @author maartenhus
 */
public class Controller implements Runnable, KeyListener
{
	private Thread thread;
	private ZeldaGame game;
	private View view;
	private Link link;
	private Scene scene;
	//private PolyCreator polyCreator;

	public Controller(ZeldaGame game, View view, final JFrame frame)
	{
		this.game = game;
		this.view = view;
		link = game.getLink();  //handles input
		scene = game.getScene();//handles input

		//frame.addMouseListener(new PolyCreator(scene));
		frame.addKeyListener(this);

		thread = new Thread(this, "GameLoop");
		thread.start();
	}

	/**
	 * This function represents the gameloop, it does stuff like make objects
	 * react on input and draw the game.
	 */
	public void run()
	{
		while (game.isRunning())
		{
			try
			{
				if(!game.isPaused())
				{
					scene.handleInput(); // let scene handle user input for menu's etc.
					link.handleInput(); // let link handle key input.

					for(GObject obj : scene.getGObjects())
					{
						obj.doInLoop(); // this lets the GObject hook in on the gameloop
					}
				}
				view.draw();

				Thread.sleep(game.getGameSpeed());
			}
			catch (InterruptedException e){}
		}

		// if the game is not running close up.
		view.exitFullScreen();
		game.quit();
	}

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			game.setRunning(false); //quit game
		}

		if (e.getKeyCode() == KeyEvent.VK_P)
		{
			game.setPaused(!game.isPaused()); //pauze game
		}

		switch(e.getKeyCode())
		{
			case KeyEvent.VK_A:
				game.setaPressed(true);
				break;
			case KeyEvent.VK_D:
				game.setdPressed(true);
				break;
			case KeyEvent.VK_W:
				game.setwPressed(true);
				break;
			case KeyEvent.VK_S:
				game.setsPressed(true);
				break;
			case KeyEvent.VK_J:
				game.setjPressed(true);
				break;
			case KeyEvent.VK_K:
				game.setkPressed(true);
				break;
			case KeyEvent.VK_L:
				game.setlPressed(true);
				break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_A:
				game.setaPressed(false);
				break;
			case KeyEvent.VK_D:
				game.setdPressed(false);
				break;
			case KeyEvent.VK_W:
				game.setwPressed(false);
				break;
			case KeyEvent.VK_S:
				game.setsPressed(false);
				break;
			case KeyEvent.VK_J:
				game.setjPressed(false);
				break;
			case KeyEvent.VK_K:
				game.setkPressed(false);
				break;
			case KeyEvent.VK_L:
				game.setlPressed(false);
				break;
		}
	}

	public void keyTyped(KeyEvent e){}
}

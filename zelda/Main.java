package zelda;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Main extends JFrame
{

	private ZeldaGame game = new ZeldaGame();
	private View view = new View(game);
	private Controller ctl;

	public Main()
	{
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					game.setRunning(false);
				}
			}
		});

		setSize(game.getWidth(), game.getHeight());
		setIgnoreRepaint(true);
		setUndecorated(true);
		setResizable(false);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		ctl = new Controller(game, view, this);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}

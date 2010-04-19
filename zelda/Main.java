package zelda;

import javax.swing.JFrame;
import zelda.engine.Game;

public class Main extends JFrame
{
	private Game game;
	private View view;
	private Controller ctl;

	public Main()
	{
		setIgnoreRepaint(true);

		game = new Game();

		if(game.isDebug())
		{
			setLocationRelativeTo(null);
			setSize(game.getWidth(), game.getHeight());
		}
		
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		view = new View(game, this);
		ctl = new Controller(game, view, this);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
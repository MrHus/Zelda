package zelda;

import javax.swing.JFrame;

public class Main extends JFrame
{

	private ZeldaGame game = new ZeldaGame();
	private View view;
	private Controller ctl;

	public Main()
	{
		setSize(game.getWidth(), game.getHeight());
		setIgnoreRepaint(true);
		setUndecorated(true);
		setResizable(false);
		//setLocationRelativeTo(null);
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

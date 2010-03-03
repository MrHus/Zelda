package zelda;

import javax.swing.JFrame;

public class Main extends JFrame
{

	private ZeldaGame game = new ZeldaGame();
	private View view;
	private Controller ctl;

	public Main()
	{
		setIgnoreRepaint(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		view = new View(game, this);
		ctl = new Controller(game, view, this);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}

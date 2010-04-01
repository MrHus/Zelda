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
		//setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(game.getWidth(), game.getHeight());
		setVisible(true);

		view = new View(game, this);
		ctl = new Controller(game, view, this);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
package zelda;

import javax.swing.JFrame;

public class Main extends JFrame
{
	private ZeldaGame game = new ZeldaGame();
	private View view = new View(game);
	private Controller ctl = new Controller(game, view, this);

	public Main()
	{
		setContentPane(view);
		setSize(game.getWidth(), game.getHeight());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
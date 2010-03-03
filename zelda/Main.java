package zelda;

import javax.swing.JFrame;

public class Main extends JFrame
{
	private ZeldaGame game = new ZeldaGame();
	private View view = new View(game);
	private Controller ctl;

	public Main()
	{
		setLayout(null);
		
		setSize(game.getWidth(), game.getHeight());
		setIgnoreRepaint(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		ctl = new Controller(game, view, this);
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
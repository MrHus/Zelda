package zelda.link;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author maartenhus
 */
public class LinkController implements KeyListener
{
	private Link link;

	public LinkController(Link link)
	{
		this.link = link;
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_A:
				link.setaPressed(true);
				break;
			case KeyEvent.VK_D:
				link.setdPressed(true);
				break;
			case KeyEvent.VK_W:
				link.setwPressed(true);
				break;
			case KeyEvent.VK_S:
				link.setsPressed(true);
				break;
			case KeyEvent.VK_J:
				link.setjPressed(true);
				break;
			case KeyEvent.VK_K:
				link.setkPressed(true);
				break;
			case KeyEvent.VK_L:
				link.setlPressed(true);
				break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_A:
				link.setaPressed(false);
				break;
			case KeyEvent.VK_D:
				link.setdPressed(false);
				break;
			case KeyEvent.VK_W:
				link.setwPressed(false);
				break;
			case KeyEvent.VK_S:
				link.setsPressed(false);
				break;
			case KeyEvent.VK_J:
				link.setjPressed(false);
				break;
			case KeyEvent.VK_K:
				link.setkPressed(false);
				break;
			case KeyEvent.VK_L:
				link.setlPressed(false);
				break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
		//throw new UnsupportedOperationException("Not supported yet.");
	}
}

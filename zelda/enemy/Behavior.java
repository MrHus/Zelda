package zelda.enemy;

/**
 *
 * @author maartenhus
 */
public abstract class Behavior
{
	private long inputInterval = 50;
	private long lastInput = System.currentTimeMillis();

	public void behave()
	{
		if (System.currentTimeMillis() > lastInput + inputInterval)
		{
			doAction();
			lastInput = System.currentTimeMillis();
		}
	}

	public abstract void doAction();
}

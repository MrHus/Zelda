package zelda.engine;

import java.util.Comparator;

/**
 *
 * @author maartenhus
 */
public class GObjectComparator implements Comparator<Object>
{
	public int compare(Object obj1, Object obj2)
	{
		GObject gobj1 = (GObject) obj1;
		GObject gobj2 = (GObject) obj2;

		if (gobj1.getZ() > gobj2.getZ())
		{
			return 1;
		}

		if(gobj1.getZ() < gobj2.getZ())
		{
			return -1;
		}

		return 0;
	}
}

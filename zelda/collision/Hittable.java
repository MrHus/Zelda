package zelda.collision;

/**
 * Can something can get hit by a weapon?
 * Weapon represents the weapon that was used.
 *
 * @author maartenhus
 */
public interface Hittable
{
	public void hitBy(Weapon weapon);
}

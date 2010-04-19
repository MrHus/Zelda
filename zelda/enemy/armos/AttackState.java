/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda.enemy.armos;

import zelda.karacter.Karacter;
import zelda.karacter.KaracterState;

/**
 *
 * @author Christiaan
 */
public class AttackState extends KaracterState
{

    private final String[] animation = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static final int WALK_SPEED = 5;
    private int oldX, oldY;
    private long oldAnimationInterval;

    public AttackState(Karacter armosKnight)
    {
        super(armosKnight);
        name = "AttackState";

        armosKnight.setAnimationInterval(90);

        oldAnimationInterval = armosKnight.getAnimationInterval();

        oldX = armosKnight.getX();
        oldY = armosKnight.getY();
    }

    public void handleInput()
    {
        switch (karacter.getDirection())
        {
            case UP:
                animation();
                break;

            case DOWN:
                animation();
                break;

            case LEFT:
                animation();
                break;

            case RIGHT:
                animation();
                break;
        }
    }

    public void animation()
    {
        
        karacter.setAnimation(animation);


    }
}

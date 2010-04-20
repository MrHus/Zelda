/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zelda.scene;

import java.awt.Rectangle;
import zelda.engine.Game;

/**
 *
 * @author Christiaan
 */
public class CreditScene extends ZeldaScene
{
    public CreditScene(Game game)
    {
        super(game, "images/aftitel.png", "CreditScene");

         if (!game.getSong().equals("sounds/credits.mp3"))
            {
            game.stopMusic();
            game.playMusic("sounds/credits.mp3", true);
            }
    }

    @Override
    public void handleSwitchScene(Rectangle exit)
    {
       
    }

    @Override
    public void handleSwitchScene(String entrance)
    {
        
    }

}

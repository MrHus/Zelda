/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda.scene;

import java.awt.Polygon;
import zelda.enemy.BlueSoldier;
import zelda.engine.Game;
import zelda.items.Bush;
import zelda.karacter.Direction;

/**
 *
 * @author Christiaan
 */
public class HyruleScene extends ZeldaScene {

    private Polygon muur, muur1, muur2, muur3, muur4, muur5, muur6;

    public HyruleScene(Game game) {
        super(game, "images/hyrule.png");

int[] hxpos = {112, 72, 48, 44, 10, 9, 38, 84, 84, 89, 91, 110, 120, 141, 164, 177, 176, 113 };
int[] hypos = {15, 20, 36, 213, 231, 264, 265, 216, 201, 200, 56, 55, 91, 99, 93, 92, 17, 13 };

        for (int i = 0; i < hypos.length; i++) {
            hypos[i] += 20;

        }
        muur = new Polygon(hxpos, hypos, hypos.length);

        int[] axpos = {177, 176, 192, 193, 178, 178, 191, 192, 177, 179, 385, 386, 459, 464, 476, 471, 463, 462, 273, 273, 285, 286, 274, 272, 335, 339, 359, 362, 392, 393, 423, 427, 455, 457, 469, 474, 488, 487, 450, 450, 370, 368, 313, 311, 296, 293, 241, 241, 242, 255, 256, 244, 244, 433, 432, 416, 415, 208, 208, 222, 221, 207, 206, 220, 220, 208, 209, 263, 264, 277, 280, 280, 177};
        int[] aypos = {8, 163, 166, 336, 336, 466, 471, 543, 547, 646, 647, 692, 695, 631, 630, 570, 568, 546, 544, 472, 470, 336, 334, 165, 166, 246, 246, 261, 261, 249, 248, 261, 261, 248, 248, 275, 275, 161, 163, 191, 189, 113, 115, 132, 134, 116, 116, 113, 359, 359, 417, 417, 568, 567, 640, 639, 594, 591, 567, 565, 419, 416, 360, 355, 114, 112, 42, 42, 53, 53, 39, 9, 8};

        for (int i = 0; i < aypos.length; i++) {
            aypos[i] += 20;

        }
        muur1 = new Polygon(axpos, aypos, aypos.length);

        int[] bxpos = {112, 118, 143, 166, 175, 174, 111, 117,};
        int[] bypos = {57, 93, 102, 95, 79, 64, 54, 71,};

        for (int i = 0; i < bypos.length; i++) {
            bypos[i] += 20;
        }

        muur2 = new Polygon(bxpos, bypos, bypos.length);


        int[] cxpos = {10, 11, 31, 89, 90, 120, 466, 469, 462, 460, 44, 41, 32, 32, 444, 445, 121, 49, 47, 33, 11, 10};
        int[] cypos = {270, 308, 310, 357, 684, 709, 708, 871, 874, 883, 889, 905, 905, 848, 846, 777, 776, 708, 375, 361, 360, 313};

        for (int i = 0; i < cypos.length; i++) {
            cypos[i] += 20;
        }

        muur3 = new Polygon(cxpos, cypos, cypos.length);


        solids.add(muur);
        solids.add(muur1);
        solids.add(muur2);
//                solids.add(muur3);
        Bush bush = new Bush(game, 160, 50);
        gameObjects.add(bush);

        gameObjects.add(game.getLink());
        gameObjects.add(new BlueSoldier(game, 300, 90, Direction.LEFT, 20));
        gameObjects.add(new BlueSoldier(game, 325, 300, Direction.DOWN, 40));
        game.playMusic("sounds/overworld.mp3", true);
    }
}

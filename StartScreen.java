package com.arman1chrismhkcd2013.flappypotato;

import android.graphics.PointF;
import sofia.graphics.RectangleShape;
// import sofia.app.Screen;
// import android.os.Bundle;
// import android.app.Activity;
// import android.view.Menu;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Arman
 * @version Apr 8, 2014
 */

// TODO USE A STACK TO PUSH THE PLAYER'S SCORES ON TO AND REVERSE PRINT IT
public class StartScreen
    extends ShapeScreen
{

    public void initialize()
    {
        BaseImage theBase = new BaseImage(0, 0, getWidth(), getHeight());
// CoverTile tile;
        add(theBase);
// add(new RectangleShape(5, 5, 20, 20));
        Potato flyPotato =
            new Potato(
                getWidth() / 9,
                getHeight() / 2,
                getWidth() / 18,
                getWidth() / 19);
        add(flyPotato);

// setGravity(0, 0);
// flyPotato.setDensity(2);

// flyPotato.setGravityScale(20);
// flyPotato.animate(14000).position(getWidth() / 9, getHeight()).play();

        if (flyPotato.getY() >= getHeight() + 5)
        {
            flyPotato.remove();
        }

        Peeler aPeeler = new Peeler(getWidth(), getHeight());

        add(aPeeler);
// The way position works (I think): takes float x, and float y for the
// end position of the center of the object
        aPeeler
            .animate(10000)
            .position(
                0 - aPeeler.getWidth(),
                getHeight() - aPeeler.getHeight() / 2).play();

    }
}

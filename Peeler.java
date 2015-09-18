package com.arman1chrismhkcd2013.flappypotato;

import android.graphics.PointF;
import sofia.graphics.ShapeMotion;
import sofia.graphics.RectangleShape;
import sofia.util.Random;

public class Peeler
    extends RectangleShape
{

    private static Random      randomHeight = new Random();
// int x = randomHeight.nextInt(64);
    private float              randomH      = randomHeight.nextFloat(20, 200);

// if (randomHeight > 20)
// {
// long randNum = randomHeight;
// }

    private static final float HRADIUS      = 30f;
    private final float        VRADIUS      = randomH;
    private PointF             startingPosition;


    // float left, float top, float right, float bottom
    public Peeler(float x, float y)
    {
        super(x, y - randomHeight.nextFloat(y / 3, y / 2 + 15), x + 20f, y);
        startingPosition = new PointF(x, y);
// OvalShape oval = new OvalShape();
        setShapeMotion(ShapeMotion.STATIC);
// this.setLeftTop(HRADIUS, randomH);
// this.setRightTop(HRADIUS, randomH);
        setImage("peeler_pic");
    }


    private void setRightTop(float hradius2, float randomH2)
    {
        // TODO Auto-generated method stub

    }
}

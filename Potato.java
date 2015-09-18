package com.arman1chrismhkcd2013.flappypotato;

import sofia.graphics.Color;
import android.graphics.PointF;
import sofia.graphics.ShapeMotion;
import sofia.app.*;
import sofia.graphics.*;
import sofia.graphics.Shape.*;

public class Potato
    extends OvalShape
{
    private PointF startingPosition;


    public Potato(float x, float y, float h, float r)
    {
        super(x, y, h, r);
// startingPosition = new PointF(x, y);
        setShapeMotion(ShapeMotion.DYNAMIC);

        setImage("winged_potato");
// setLinearVelocity(0, -5);

// thePotato.setShapeMotion(ShapeMotion.DYNAMIC);

    }

}

package com.arman1chrismhkcd2013.flappypotato;

// import sofia.app.Screen; used in restaurant project
// import android.view.Gravity;
import sofia.util.Random;
import sofia.internal.events.EventDispatcher;
import java.util.ArrayList;
import sofia.graphics.ShapeMotion;
// import android.widget.TextView;
import android.widget.Button;
// import android.widget.EditText;
// import sofia.graphics.Anchor;
// import android.graphics.PointF;
// import sofia.graphics.RectangleShape;
// import android.os.Bundle;
// import android.app.Activity;
// import android.view.Menu;
import sofia.app.ShapeScreen;
import sofia.util.Timer;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Arman (arman1), Chris Hess, Kevin Dehart
 * @version Apr 8, 2014
 */

// TODO USE A STACK TO PUSH THE PLAYER'S SCORES ON TO AND REVERSE PRINT IT
public class StartScreen
    extends ShapeScreen
{

// private TextView finalScore;

    private Potato        flyPotato;
    // private ImageView tiny;
    private Peeler        lowPeeler;
    private Peeler        topPeeler;
    private boolean       gameLost     = false;
    // private ArrayList<Peeler> arrayListOfPeelers = new ArrayList();
    private static Random randomGen    = new Random();
    private int           scoreCounter = 0;


// private String type;
// private boolean h = false;
// private double screenHeight;
// private int hCounter = 0;

    public void initialize()
    {
        // screenHeight = getHeight();
// type = "";
        BaseImage theBase = new BaseImage(0, 0, getWidth(), getHeight());
        theBase.setShapeMotion(ShapeMotion.STATIC);

        add(theBase);
        flyPotato =
            new Potato(
                getWidth() / 9,
                getHeight() / 2,
                getWidth() / 18,
                getWidth() / 19);
        // flyPotato.setShapeMotion(ShapeMotion.KINEMATIC);

        add(flyPotato);

// finalScore.setGravity(5); // TODO TODO IMPORTANT!!!

        // kinematic objects can be given a velocity, statics can't. can they be
// effected by gravity?

        lowPeeler = new Peeler(getWidth(), getHeight());
        add(lowPeeler);
//

        float lowPeelerSize = lowPeeler.getHeight();
        // At most the two pipes can take up about 70% of the height of
// the
// screen. Note the potato is slightly > 5% of the height
        float fractionScreenHeight = (float)(getHeight() * .7);
        topPeeler = new Peeler(getWidth(), lowPeelerSize, fractionScreenHeight);
        add(topPeeler);

        lowPeeler.animate(4500).position(-50f, lowPeeler.getY()).play();
        topPeeler.animate(4500).position(-50f, topPeeler.getY()).play();

        // EventDispatcher eventDispatch = new EventDispatcher("fun");
        // Timer timer = new Timer(this, eventDispatch, 0, 0);

        Timer.callRepeatedly(this, "gameRunning", 50);
        Timer.callRepeatedly(this, "potatoGotPeeled", 25);
        // this.callRepeatedly(this, "gameRunning", 250);

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void onTouchDown(float x, float y)
    {
        boolean tooLow = false;
        boolean tooHigh = false;
        if (flyPotato.getY() >= getHeight() - flyPotato.getHeight() * 1.5)
        {
            tooLow = true;
            flyPotato.animate(500)
                .position(flyPotato.getX(), getHeight() - getHeight() / 4)
                .play();

        }
        else
        {
            tooLow = false;
        }
        if (flyPotato.getY() <= 0 + flyPotato.getHeight() * 1.5)
        {
            tooHigh = true;
            flyPotato.animate(500).position(flyPotato.getX(), getHeight() / 4)
                .play();

        }
        else
        {
            tooHigh = false;
        }
// fall
        if (y > getHeight() / 2 && !tooLow && !gameLost)
        {
            flyPotato
                .animate(100)
                .position(flyPotato.getX(), flyPotato.getY() + getHeight() / 10)
                .play();
            flyPotato.animate(0).delay(250);
// flyPotato.setPosition(flyPotato.getX(), flyPotato.getY()
// + getHeight() / 10);
        }
        // jump
        else if (y < getHeight() / 2 && !tooHigh && !gameLost)
        {
// lowPeeler
// .animate(randomGen.nextInt(4000, 6500))
// .position(
// -50f,
// lowPeeler.getY() - randomGen.nextFloat(0, getHeight()))
// .play();
            flyPotato
                .animate(100)
                .position(flyPotato.getX(), flyPotato.getY() - getHeight() / 10)
                .play();
            flyPotato.animate(0).delay(250);

// flyPotato.setPosition(flyPotato.getX(), flyPotato.getY()
// - getHeight() / 10);
        }

        // gameRunning();
    }


    // ----------------------------------------------------------
    /**
     * While the game is running new peelers are added to the screen and the
     * program checks to see if the potato has collided with a peeler
     */
    public void gameRunning()
    {
        if (!gameLost)
        {
            float lowPeelerSize;
            float fractionScreenHeight;

            // TODO fallingDeath(); and also it's not working with both adding
            // new peelers and chopping the potato
            // potatoGotPeeled();
            if (lowPeeler.getX() <= getWidth() / 9 - getWidth() / 15
                && topPeeler.getX() <= getWidth() / 9 - getWidth() / 15)
            {
                if (lowPeeler.getX() <= 0)
                {
                    lowPeeler.remove();
                    scoreCounter++;
                }
                if (topPeeler.getX() <= 0)
                {
                    topPeeler.remove();
                    scoreCounter++;
                }
               // System.out.print(scoreCounter); Why doesn't it print?
                lowPeeler = new Peeler(getWidth(), getHeight());
                add(lowPeeler);
                lowPeelerSize = lowPeeler.getHeight();
                fractionScreenHeight = (float)(getHeight() * .7);
                topPeeler =
                    new Peeler(getWidth(), lowPeelerSize, fractionScreenHeight);
                add(topPeeler);
                int randomRotation = randomGen.nextInt(0, 3500);
                int randomRotation2 = randomGen.nextInt(0, 3500);
                int rotateOrNot = randomGen.nextInt(0, 2);

                if (rotateOrNot == 0)
                {
                    randomRotation = 0;
                }
                rotateOrNot = randomGen.nextInt(0, 2);
                if (rotateOrNot == 0)
                {
                    randomRotation = 0;
                }

                lowPeeler
                    .animate(randomGen.nextInt(3500, 6500))
                    .position(
                        -250f,
                        lowPeeler.getY() - randomGen.nextFloat(0, getHeight()))
                    .rotation(2000).play();
                topPeeler
                    .animate(randomGen.nextInt(3500, 6500))
                    .position(
                        -250f,
                        topPeeler.getY() + randomGen.nextFloat(0, getHeight()))
                    .rotation(randomRotation2).play();
            }
        }

    }


// public void onhDown(float x, float y)
// {
//
// // h = true;
// // if (type.equals(""))
// // {
// // type = "j";
//
// // }
// // if (type.equals("j"))
// // {
//
// flyPotato
// .animate(100)
// .position(
// flyPotato.getX(),
// (float)(flyPotato.getY() - screenHeight / 5)).play();
// // type = "g";
// // fall();
// // }
// hCounter++;
// i = .1f; // reinitialize i
// while (hCounter % 2 == 1) // if it's odd
// {
//
// flyPotato.setPosition(flyPotato.getX(), flyPotato.getY() + i * i);
// i = i + .025f; // TODO
// }

// i = .1f;
// float goal = flyPotato.getY() - getHeight() / 10;
// while (flyPotato.getY() > goal)
// {
// // Jump:
// flyPotato.setPosition(flyPotato.getX(), flyPotato.getY() - i
// * i);
// i = i + .01f;
//
// }
// h = false;
// }
// fall();
// }

// public void fall()
// {
// i = .1f;
// while (!h) // && type.equals("p"))
// {
//
// flyPotato.setPosition(flyPotato.getX(), flyPotato.getY() + i * i);
// i = i + .025f; // TODO
//
// }
// Object fall =s
// flyPotato.animate(50)
// .position(
// flyPotato.getX(),
// (float)(flyPotato.getY() + screenHeight / 12));
// if (h)
// {
// ((sofia.graphics.Shape.Animator<?>)fall).stop();
// }
// while (!h)
// {
// ((sofia.graphics.Shape.Animator<?>)fall).play();
// }
// public void fallingDeath()
// {
// if (flyPotato.getY() >= getHeight())
// {
    // gameLost = true;
// // display game over screen and stop the game
// }
//
// }
    // ----------------------------------------------------------
    public void potatoGotPeeled()
    {

// Peeler low = arrayListOfPeelers.get(0);
// Peeler top = arrayListOfPeelers.get(1);
        float lowRight = lowPeeler.getLeft() + lowPeeler.getWidth();
        float topRight = topPeeler.getLeft() + topPeeler.getWidth();
        float lowBottom = lowPeeler.getTop() + lowPeeler.getHeight();
        float topBottom = topPeeler.getTop() + topPeeler.getHeight();

        if (flyPotato.getY() >= lowPeeler.getTop()
            && flyPotato.getY() <= lowBottom
            && (flyPotato.getX() >= lowPeeler.getLeft() && flyPotato.getX() <= lowRight))
        {
            gameLost = true;
            flyPotato.animate(1500).rotation(360).alpha(0).removeWhenComplete()
                .play();

            // display losing screen
        }
        if (flyPotato.getY() >= topPeeler.getTop()
            && flyPotato.getY() <= topBottom
            && (flyPotato.getX() >= topPeeler.getLeft() && flyPotato.getX() <= topRight))
        {
            gameLost = true;
            flyPotato.animate(1500).rotation(360).alpha(0).removeWhenComplete()
                .play();

            // display losing screen
        }

    }
}

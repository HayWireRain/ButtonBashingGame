import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Player1 frog;
    public Player2 keemstar;
    public String gameState;
    public Text startupMessageTxt, countdownTxt, frogWinning, keemstarWinning, tie, winPlayer1, winPlayer2, reset, rewind, controls;
    public int countdownTimer;
    public int rewindTimer;
    public Text onYourMarksTxt;
    public GreenfootSound countdownSound, runningSound, finishedSound, pikachuWin, frogWin, rewindSound;
    public int animationCount1, animationCount2;
    public boolean havePlayed;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(),1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        frog = new Player1();
        keemstar = new Player2();
        addObject(frog,100,100);
        addObject(keemstar,100,400);
        gameState = "startUp";
        startupMessageTxt = new Text("Press ENTER to start!",Color.WHITE,75);
        countdownTimer = 350;
        rewindTimer = 300;
        countdownTxt = new Text("5", Color.WHITE, 75);
        frogWinning = new Text("Player 1 is winning!", Color.WHITE, 75);
        keemstarWinning = new Text("Player 2 is winning!", Color.WHITE, 75);
        tie = new Text("You are currently tied!", Color.WHITE, 75);
        winPlayer1 = new Text("Player 1 Has Won!", Color.WHITE, 75);
        winPlayer2 = new Text("Player 2 Has Won!", Color.WHITE, 75);
        reset = new Text("Press ENTER to reset", Color.WHITE, 75);
        rewind = new Text("Rewinding...", Color.WHITE, 75);
        controls = new Text("Controls: Player 1: Z, Player 2: M", Color.WHITE, 75);
        countdownSound = new GreenfootSound("countdown.mp3");
        runningSound = new GreenfootSound("running.mp3");
        finishedSound = new GreenfootSound("finished.mp3");
        pikachuWin = new GreenfootSound("pikachuWin.mp3");
        frogWin = new GreenfootSound("Reeee.mp3");
        rewindSound = new GreenfootSound("rewind.mp3");
        animationCount1 = 0;
        animationCount2 = 0;
        havePlayed = false;
    }


    public void act()
    {
        animationCount1++;
        if (animationCount1 == 5)
        {
            animationCount1 = 0;
            animationCount2++;
            if (animationCount2 == 5)
            {
                animationCount2 = 0;              
             
                
            }
            if(animationCount2 ==0)
            {
                frog.setImage("frog0right.png");
            }
            else if(animationCount2 == 1)
            {
                frog.setImage("frog1right.png");
            }
            else if(animationCount2 == 2)
            {
                frog.setImage("frog2right.png");
            }
            else if(animationCount2 == 3)
            {
                frog.setImage("frog3right.png");
            }
            else if(animationCount2 == 4)
            {
                frog.setImage("frog4right.png");
            }
        }
        if(gameState.equals("startUp"))
        {
            addObject(startupMessageTxt, getWidth()/2, 200);
            addObject(controls, getWidth()/2, 500);
            if(Greenfoot.isKeyDown("Enter"))
            {
                gameState = ("countDown");
                removeObject(startupMessageTxt);
                removeObject(controls);
                addObject(countdownTxt, getWidth()/2, 200);
            }
        }
        else if(gameState.equals("rewind"))
        {
            rewindTimer--;
            addObject(rewind, getWidth()/2, 200);
            rewindSound.play();
            if(rewindTimer>300)
            {   
                rewind.setText("Rewinding",Color.WHITE,150);
            }
            else if(rewindTimer>250)
            {
                rewind.setText("Rewinding.",Color.WHITE,150);
            }
            else if(rewindTimer>200)
            {
                rewind.setText("Rewinding..",Color.WHITE,150);
            }
            else if(rewindTimer>150)
            {
                rewind.setText("Rewinding...",Color.WHITE,150); 
            }
            else if(rewindTimer>0)
            {
                rewindTimer = 300;
            }

            if(frog.getX()>100)
            {
                frog.setLocation(frog.getX()-5, frog.getY());
            }
            if(keemstar.getX()>100)
            {
                keemstar.setLocation(keemstar.getX()-5, keemstar.getY());
            }
            if(keemstar.getX()<=100&&frog.getX()<=100)
            {
                  addObject(countdownTxt, getWidth()/2, 200);
                countdownTimer = 350;
                gameState = "countDown";
            }
        }
        else if(gameState.equals("countDown"))
        {
            countdownTimer--;
            removeObject(reset);
            countdownSound.play();
            removeObject(rewind);
            rewindSound.stop();
            if(countdownTimer>300)
            {
                countdownTxt.setText("5",Color.WHITE,150);
            }
            else if(countdownTimer>250)
            {
                countdownTxt.setText("4",Color.WHITE, 150);
              
            }
            else if(countdownTimer>200)
            {
                countdownTxt.setText("3",Color.WHITE, 150);
              
            }
            else if (countdownTimer>150)
            {
              
                countdownTxt.setText("2", Color.WHITE, 150);
            }
             else if (countdownTimer>100)
            {
              
                countdownTxt.setText("1", Color.WHITE, 150);
            }
             else if (countdownTimer>50)
            {
              
                countdownTxt.setText("Go!", Color.WHITE, 150);
            }
            else
            {
                gameState = "running";
                removeObject(countdownTxt);
                countdownSound.stop();
            }
        }
        else if(gameState.equals("running"))
        {
            runningSound.play();
            if(frog.distance > keemstar.distance)
            {
                removeObject(tie);
                removeObject(keemstarWinning);
                addObject(frogWinning,  getWidth()/2, 200);
            }
            if(keemstar.distance > frog.distance)
            {
                removeObject(tie);
                removeObject(frogWinning);
                addObject(keemstarWinning,  getWidth()/2, 200);
            }
            if(frog.distance == keemstar.distance)
            {
                removeObject(keemstarWinning);
                removeObject(frogWinning);
                addObject(tie,  getWidth()/2, 200);
            }
        }
        else if(gameState.equals("finished"))
        {
            removeObject(frogWinning);
            removeObject(keemstarWinning);
            removeObject(tie);
            runningSound.stop();
            finishedSound.play();
            if(frog.distance > keemstar.distance)
            {
                addObject(winPlayer1, getWidth()/2, 200);
                addObject(reset, getWidth()/2, 400);
                if(!havePlayed)
                {
                   frogWin.play();
                   havePlayed = true;
                }
            }
            else if(keemstar.distance > frog.distance)
            {
                addObject(winPlayer2, getWidth()/2, 200);
                addObject(reset, getWidth()/2, 400);
                if(!havePlayed)
                {
                    pikachuWin.play();
                    havePlayed = true;
                }                
            }
            if(Greenfoot.isKeyDown("Enter"))
            {
                removeObject(winPlayer1);
                removeObject(winPlayer2);
                removeObject(reset);
                frog.distance = 0;
                keemstar.distance = 0;
                finishedSound.stop();
                havePlayed = false;
                gameState = "rewind";
            }
        }
    }
}

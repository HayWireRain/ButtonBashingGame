import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    public boolean keemstarCanMove;
    public int distance;
    public GifImage pikachuGif = new GifImage("pikachu.gif");
    public Player2()
    {
        distance=0;
       
    }
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         setImage(pikachuGif.getCurrentImage());
        MyWorld wrld=(MyWorld) getWorld();
       
        if(wrld.gameState.equals("running"))
        {
            if(!Greenfoot.isKeyDown("m"))
            {
                keemstarCanMove = true;
            }
            if (Greenfoot.isKeyDown("m") && keemstarCanMove)
            {
                move(8);
                distance+=8;
                keemstarCanMove = false;
            }
            if(distance>wrld.getWidth()-100)
            {
                wrld.gameState="finished";
            }
        }
    }    
}

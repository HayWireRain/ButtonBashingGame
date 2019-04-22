import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Actor
{
    public boolean frogCanMove;
    public int distance;
    
    public Player1()
    {
        distance=0;
    }
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       MyWorld wrld=(MyWorld) getWorld();
        if(wrld.gameState.equals("running"))
        {
            if(!Greenfoot.isKeyDown("z"))
            {
                frogCanMove = true;
            }
            if (Greenfoot.isKeyDown("z") && frogCanMove)
            {
                move(8);
                distance+=8;
                frogCanMove = false;
            }
            if(distance>wrld.getWidth()-100)
            {
                wrld.gameState="finished";
                
            }
            
            
            
        }
    }    
}

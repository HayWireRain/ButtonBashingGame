//You should make a new Actor class named Text, with
//no image.  Then copy and paste all of this code into
//its code window.



import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Text extends Actor
{
    public Text()  
    {  
        this("", Color.white, 24);  
    }  
 
    public Text(String text, Color color, int size)  
    {          setText(text, color, size);  
    }  
 
    public void setText(String text, Color color, int size)  
    {  
        setImage(new GreenfootImage(text, size, color, new Color(0, 0, 0, 0)));  
    }   
 
 
     
}    

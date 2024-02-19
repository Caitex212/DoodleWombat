import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class deathscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deathscreen extends Actor
{
    /**
     * Act - do whatever the deathscreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean played = false;
    
    public void act()
    {   
        if(!played) {
             Greenfoot.playSound("death.mp3");  
             played = true;
        }
    }
}

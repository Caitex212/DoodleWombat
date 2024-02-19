import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{   
    private int loc;
    private boolean first = true;
    
    public void act()
    {      
        if(first) {
            loc = getY();
            first = false;
        }
        setLocation(getX(), loc+((viewWorld) getWorld()).offset);
        if (getY() >= 799) {
            ((viewWorld) getWorld()).removeObject(this);
        }
    }
}

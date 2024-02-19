import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform2 extends Actor
{
    private int loc = 0;
    private boolean spawned = false;
    
    public void act()
    {
        if(loc == 0) {
            loc = getY();
        }
        if(((viewWorld) getWorld()).offset != loc) {
            setLocation(getX(), getY() + ((viewWorld) getWorld()).offset);
            loc = ((viewWorld) getWorld()).offset;
        }
        if (getY() >= 799) {
            ((viewWorld) getWorld()).removeObject(this);
        }
    }
}

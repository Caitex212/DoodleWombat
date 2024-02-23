import greenfoot.*;
 
public class Player extends Actor
{
    private double gravity = 2;
    private int maxVel = 15;
    public int vel = 0;
    public int score = 0;
    
    public int maxVelX = 30;
    public int minVelX = 4;
    public int velX = 0;
    private int speed = 1;
    
    public boolean right = false;
    public boolean left = false;
 
    public void act() {
        if (vel > maxVel) {
            vel = maxVel;
        }
        if (vel >= 0) {
            if (isTouching(Floor.class) || isTouching(Platform.class) || isTouching(Platform2.class)) {
                vel = -20;
                Greenfoot.playSound("boing.mp3");  
            }
        }
        
        if ((vel < 0 && getY() >= 400) || getY() >= 400) {
            setLocation(getX(), getY() + vel);
        } else {
            setLocation(getX(), 400);
            if(vel < 0) {
                ((viewWorld) getWorld()).offset = vel*-1;
                ((viewWorld) getWorld()).showText("Score: " + score, 100, 780);
                score += vel*(-1);
            }
        }
        vel += gravity;
        
        if (Greenfoot.isKeyDown("LEFT")) {
            setImage("wombatleft.png");
            if(velX > 0) {
                velX = 0;
            }
            velX -= speed;
            left = true;
            if (velX <= -maxVelX) {
                velX = -maxVelX;
            }
            if(getX() <= 1) {
                setLocation(500, getY());
            }
        }else {
                left = false;
        }
        if (Greenfoot.isKeyDown("RIGHT")) {
            setImage("wombat.png");
            if(velX < 0) {
                velX = 0;
            }
            velX += speed;
            right = true;
            if (velX >= maxVelX) {
                velX = maxVelX;
            }
            if(getX() >= 499) {
                setLocation(0, getY());
            }
        }else {
                right = false;
        }
        if(!right && !left) {
            velX = 0;
        }
        if(getY() >= 799) {
            ((viewWorld) getWorld()).generateDeath();
        }
        setLocation(getX() + velX, getY());
    }

}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class viewWorld extends World
{

    public int offset = 0;
    private int spawner = 1;
    private int tempOffset = 0;
    public Actor player = new Player();
    public Actor floor = new Floor();
    public boolean isdeath = false;
    
    public viewWorld()
    {    
        super(500, 800, 1); 
        addObject(player, 250, 725);
        addObject(floor, 250, 782);
        setBackground(new GreenfootImage("sky.png"));
        
        for(int i=0; i <= 8; i++) {
            int random = (int)(Math.random() * 500);
            Actor platform = new Platform2();
            spawner++;
            addObject(platform, random, spawner * 70);
        }
        int random = (int)(Math.random() * 500);
        Actor platform = new Platform();
        addObject(platform, random, 10);
        int random2 = (int)(Math.random() * 500);
        Actor cloud = new cloud();
        //addObject(cloud, random2, 0);
        setPaintOrder(deathscreen.class, Floor.class, Player.class, Platform.class, Platform2.class, cloud.class);
    }  
    
    public void generate() {
        int random = (int)(Math.random() * 500);
        Actor platform = new Platform();
        addObject(platform, random, 0);
    }

    public void generateCloud() {
        int random = (int)(Math.random() * 500);
        Actor cloud = new cloud();
        addObject(cloud, random, 0);
    }
    
    public void generateDeath() {
        if(!isdeath){
            isdeath = true;
            addObject(new deathscreen(), 250, 400);
        }
    }
}

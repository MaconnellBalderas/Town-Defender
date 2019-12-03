import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creatures{
    public int getBounds;
    //Animations
    private Animation animDown, animUp, animLeft, animRight, animDownSwing, animUpSwing, animLeftSwing, animRightSwing;
    //Inventory
    private Inventory inventory;

    public Player(Handler handler, float x, float y){
        super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 8;
        bounds.y = 25;
        bounds.width = 30;
        bounds.height = 30;

        //Animations
        animDown = new Animation( 95, Assets.player_down);
        animUp = new Animation( 95, Assets.player_up);
        animLeft = new Animation( 95, Assets.player_left);
        animRight = new Animation( 95, Assets.player_right);

        animDownSwing = new Animation( 95, Assets.player_down_swing);
        animUpSwing = new Animation( 95, Assets.player_up_swing);
        animLeftSwing = new Animation( 95, Assets.player_left_swing);
        animRightSwing = new Animation( 95, Assets.player_right_swing);
        //Inventory
        inventory = new Inventory(handler);
    }
    @Override
    public void tick(){
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        animDownSwing.tick();
        animUpSwing.tick();
        animLeftSwing.tick();
        animRightSwing.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //Attack
        checkAttack();
        //Inventory
        inventory.tick();

    }

    private void checkAttack(){
        Rectangle cb = getCollisionBounds( 0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width / 2- arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else if(handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else{
            return;
        }

        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds( 0, 0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
    }

    @Override
    public void die(){
        System.out.println("You Lose");
    }

    public void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
    }
    @Override
    public void render(Graphics g){
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        inventory.render(g);
    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            return animDown.getCurrentFrame();
        }

        if(handler.getKeyManager().aDown == true){
            return animDownSwing.getCurrentFrame();
        }else if(handler.getKeyManager().aUp == true){
            return animUpSwing.getCurrentFrame();
        }else if(handler.getKeyManager().aLeft == true){
            return animLeftSwing.getCurrentFrame();
        }else if(handler.getKeyManager().aRight == true){
            return animRightSwing.getCurrentFrame();
        }
        return Assets.player_still;
    }

    public Inventory getInventory(){
        return inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

}
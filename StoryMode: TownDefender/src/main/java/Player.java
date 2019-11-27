import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Creatures{
	public int getBounds;
	
	private Animation up;
	private Animation down;
	private Animation left;
	private Animation right;
	
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatues.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 8;
		bounds.y = 25;
		bounds.width = 30;
		bounds.height = 30;
		
		up = new Animation( 95, Assets.player_up);
		down = new Animation( 95, Assets.player_down);
		left = new Animation( 95, Assets.player_left);
		right = new Animation( 95, Assets.player_right);
		
		inventory = new Inventory(handler);
	}
	
	@Override
	public void tick() {
		up.tick();
		down.tick();
		left.tick();
		right.tick();
		getInput();
		move();
		handler.getGameCamera().coneterOnEntity(this);
		checkAttack();
		inventory.tick();
	}
	
	private void checkAttack() {
		Rectangle cb = getCollisionBounds( 0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if(handler.getKeyManager().aDown){
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
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
		
	}
	
	@Override
	public void die() {
		System.out.println("You Lose");
	}
	
	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getkeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}
	
	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		inventory.render(graphics);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return left.getCurrentFrame();
		} else if(xMove > 0) {
			return right.getCurrentFrame();
		} else if(yMove < 0) {
			return up.getCurrentFrame();
		} else if(yMove > 0) {
			return down.getCurrentFrame();
		}
		
		//create swing animation key manager
		
		//redo standing animation to bob up and down
		return Assets.player_still;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	

}

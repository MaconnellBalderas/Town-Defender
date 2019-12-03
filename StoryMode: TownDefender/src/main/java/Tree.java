import java.awt.*;

public class Tree extends StaticEntity{

    public Tree(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILE_WIDTH * 3, Tile.TILE_HEIGHT * 3);

        bounds.x = 30;
        bounds.y = Tile.TILE_HEIGHT * 3 / 2;
        bounds.width = Tile.TILE_WIDTH * 2 - 1;
        bounds.height = Tile.TILE_HEIGHT;
    }
    @Override
    public void tick(){

    }
    @Override
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew( (int) (x - bounds.x / 2 + width / 2), (int) (y + height / 2)));
    }
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }


}

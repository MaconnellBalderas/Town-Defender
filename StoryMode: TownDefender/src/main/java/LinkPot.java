import java.awt.*;

public class LinkPot extends StaticEntity{

    public LinkPot(Handler handler, float x, float y){
        super( handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = -1;
        bounds.y = 15;
        bounds.width = Tile.TILE_WIDTH / 2 + 3;
        bounds.height = Tile.TILE_HEIGHT / 2 - 15;
    }
    @Override
    public void tick(){

    }
    @Override
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.emeraldItem.createNew( (int) x, (int) y));
    }
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.breakable_pot, (int) ( x - handler.getGameCamera().getxOffset()), (int) ( y - handler.getGameCamera().getyOffset()), width / 2, height / 2, null);
    }
}

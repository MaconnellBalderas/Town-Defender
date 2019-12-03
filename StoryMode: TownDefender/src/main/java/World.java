import java.awt.*;
import java.util.Arrays;

public class World {

    private Player player;
    private World world;
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    //Entities
    private EntityManager entityManager;

    //Items
    private ItemManager itemManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        itemManager = new ItemManager(handler);

        entityManager.addEntity(new LinkPot(handler, 400, 200));
        entityManager.addEntity(new LinkPot(handler, 500, 200));

//        entityManager.addEntity(new Tree(handler, 100, 800));
//        entityManager.addEntity(new Tree(handler, 300, 800));

        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

//        if(player.y < world.getHeight()){
//            System.out.println("Change Map");
//        }
    }

    public void tick(){
        itemManager.tick();
        entityManager.tick();
    }

    public void render(Graphics g){

        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_WIDTH);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart; x < xEnd; x++){
                getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }

    //Items
    itemManager.render(g);
    //Entities
    entityManager.render(g);
    }
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.grassTile;
        }

//        // How to print a 2-dimensional array
//        for (int i = 0; i < width; i++){
//            for (int j = 0; j < height; j++){
//                System.out.printf("[%d][%d]:%d ", i, j, tiles[i][j]);
//            }
//            System.out.println("");
//        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.grassTile;
        }
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        System.out.println("Tokens: " + Arrays.toString(tokens));
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);


        tiles = new int[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public ItemManager getItemManager(){
        return itemManager;
    }
    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public Handler getHandler(){
        return handler;
    }
    public void setHandler(Handler handler){
        this.handler = handler;
    }
}

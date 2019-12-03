import javax.swing.*;
import java.awt.*;

public class GameState extends State{
    private Player player;
    private World world;
    private Entity entity;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "worlds/world2.txt");
        handler.setWorld(world);
        handler.getGameCamera().move( 0, 0);

    }

    @Override
    public void tick(){
        world.tick();
        handler.getGameCamera().move( 1, 1);
    }
    @Override
    public void render(Graphics g){
        world.render(g);
    }


}

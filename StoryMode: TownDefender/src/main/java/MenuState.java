import java.awt.*;

public class MenuState extends State{

    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton( 0, 0, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT, Assets.menu_start, new ClickListener(){
            @Override
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }
    @Override
    public void tick(){
        uiManager.tick();
    }
    @Override
    public void render(Graphics g){
        uiManager.render(g);
    }
}

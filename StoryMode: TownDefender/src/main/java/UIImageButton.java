import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{
    private BufferedImage images;
    private ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage images, ClickListener clicker){
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }
    @Override
    public void tick(){

    }
    @Override
    public void render(Graphics g){
        g.drawImage(ImageLoader.loadImage(("/textures/link_mainmenu.jpg")), (int) x, (int) y, width, height, null);
    }
    @Override
    public void onClick(){
        clicker.onClick();
    }



}

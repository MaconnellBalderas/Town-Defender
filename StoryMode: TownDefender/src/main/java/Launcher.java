
public class Launcher {

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600 ;

    public static void main (String[] args) {
        Game game = new Game("StoryMode: TownDefender", SCREEN_WIDTH, SCREEN_HEIGHT);

        game.start();
    }
}

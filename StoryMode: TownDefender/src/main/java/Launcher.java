
public class Launcher {
	
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 800;
	
	public static void main(String[] args) {
		Game game = new Game("Town Defender", SCREEN_WIDTH, SCREEN_HEIGHT);
		
		game.start();
	}

}

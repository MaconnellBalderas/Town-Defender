import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 30, height = 30;
    private static final int widthSwing = 25, heightSwing = 32;

    public static BufferedImage grass, stone, tree, menu_start, breakable_pot, player_still, wood, emerald, dirt;
    public static BufferedImage[] player_down, player_up, player_left, player_right, player_down_swing, player_up_swing, player_left_swing, player_right_swing;

    public static void init(){
        SpriteSheet sprite = new SpriteSheet(ImageLoader.loadImage("/textures/link_sprite_sheet.png"));
        SpriteSheet land = new SpriteSheet(ImageLoader.loadImage("/textures/link_grass_tile.png"));
        SpriteSheet wall = new SpriteSheet(ImageLoader.loadImage("/textures/link_stone_tile.png"));
        SpriteSheet nature = new SpriteSheet(ImageLoader.loadImage("/textures/link_tree_tile.png"));
        SpriteSheet start = new SpriteSheet(ImageLoader.loadImage("/textures/link_mainmenu.png"));
        SpriteSheet log = new SpriteSheet(ImageLoader.loadImage("/textures/link_log.png"));
        SpriteSheet pot = new SpriteSheet(ImageLoader.loadImage("/textures/breakable_pot.png"));
        SpriteSheet rupee = new SpriteSheet(ImageLoader.loadImage("/textures/link_emerald.png"));
        SpriteSheet ground = new SpriteSheet(ImageLoader.loadImage("/textures/link_dirt_tile.png"));

        //Breakables
        breakable_pot = pot.crop( 0, 0, width, height);
        //World
        grass = land.crop( 0, 0, width, height);
        stone = wall.crop( 0, 0, width, height);
        tree = nature.crop( 0, 0, width, height);
        dirt = ground.crop( 0, 0, width, height);
        //Menus
        menu_start = start.crop( 0, 0, width, height);
        //Drops
        wood = log.crop( 0, 0, width, height);
        emerald = rupee.crop( 0, 0, width, height);
        //Player Standing
        player_still = sprite.crop(width, 0, width, height);
        //Player Swing
        player_down_swing = new BufferedImage[6];
        player_up_swing = new BufferedImage[5];
        player_left_swing = new BufferedImage[5];
        player_right_swing = new BufferedImage[5];

        player_down_swing[0] = sprite.crop( 0, height * 3, widthSwing, heightSwing);
        player_down_swing[1] = sprite.crop( width, height * 3, widthSwing, heightSwing);
        player_down_swing[2] = sprite.crop( width * 2, height * 3, widthSwing, heightSwing);
        player_down_swing[3] = sprite.crop( width * 3, height * 3, widthSwing, heightSwing);
        player_down_swing[4] = sprite.crop( width * 4, height * 3, widthSwing, heightSwing);
        player_down_swing[5] = sprite.crop( width * 5, height * 3, widthSwing, heightSwing);

        player_up_swing[0] = sprite.crop( 0, height * 6, widthSwing, heightSwing);
        player_up_swing[1] = sprite.crop( width, height * 6, widthSwing, heightSwing);
        player_up_swing[2] = sprite.crop( width * 2, height * 6, widthSwing, heightSwing);
        player_up_swing[3] = sprite.crop( width * 3, height * 6, widthSwing, heightSwing);
        player_up_swing[4] = sprite.crop( width * 4, height * 6, widthSwing, heightSwing);

        player_left_swing[0] = sprite.crop( width * 8, height * 3, widthSwing, heightSwing);
        player_left_swing[1] = sprite.crop( width * 9, height * 3, widthSwing, heightSwing);
        player_left_swing[2] = sprite.crop( width * 10, height * 3, widthSwing, heightSwing);
        player_left_swing[3] = sprite.crop( width * 11, height * 3, widthSwing, heightSwing);
        player_left_swing[4] = sprite.crop( width * 12, height * 3, widthSwing, heightSwing);

        player_right_swing[0] = sprite.crop( width * 8, height * 6, widthSwing, heightSwing);
        player_right_swing[1] = sprite.crop( width * 9, height * 6, widthSwing, heightSwing);
        player_right_swing[2] = sprite.crop( width * 10, height * 6, widthSwing, heightSwing);
        player_right_swing[3] = sprite.crop( width * 11, height * 6, widthSwing, heightSwing);
        player_right_swing[4] = sprite.crop( width * 12, height * 6, widthSwing, heightSwing);
        //Player Movement
        player_down = new BufferedImage[8];
        player_up = new BufferedImage[8];
        player_left = new BufferedImage[6];
        player_right = new BufferedImage[6];

        player_down[0] = sprite.crop( 0, height, width, height);
        player_down[1] = sprite.crop( width, height, width, height);
        player_down[2] = sprite.crop( width * 1, height, width, height);
        player_down[3] = sprite.crop( width * 2, height, width, height);
        player_down[4] = sprite.crop( width * 3, height, width, height);
        player_down[5] = sprite.crop( width * 4, height, width, height);
        player_down[6] = sprite.crop( width * 5, height, width, height);
        player_down[7] = sprite.crop( width * 6, height, width, height);

        player_up[0] = sprite.crop( 0, height * 4, width, height);
        player_up[1] = sprite.crop( width, height * 4, width, height);
        player_up[2] = sprite.crop( width * 1, height * 4, width, height);
        player_up[3] = sprite.crop( width * 2, height * 4, width, height);
        player_up[4] = sprite.crop( width * 3, height * 4, width, height);
        player_up[5] = sprite.crop( width * 4, height * 4, width, height);
        player_up[6] = sprite.crop( width * 5, height * 4, width, height);
        player_up[7] = sprite.crop( width * 6, height * 4, width, height);

        player_left[0] = sprite.crop(width * 8, height, width, height);
        player_left[1] = sprite.crop(width * 9, height, width, height);
        player_left[2] = sprite.crop(width * 10, height, width, height);
        player_left[3] = sprite.crop(width * 11, height, width, height);
        player_left[4] = sprite.crop(width * 12, height, width, height);
        player_left[5] = sprite.crop(width * 13, height, width, height);

        player_right[0] = sprite.crop(width * 8, height * 4, width, height);
        player_right[1] = sprite.crop(width * 9, height * 4, width, height);
        player_right[2] = sprite.crop(width * 10, height * 4, width, height);
        player_right[3] = sprite.crop(width * 11, height * 4, width, height);
        player_right[4] = sprite.crop(width * 12, height * 4, width, height);
        player_right[5] = sprite.crop(width * 13, height * 4, width, height);
    }
}

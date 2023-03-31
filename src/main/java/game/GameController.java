package game;

import controller.RacingCarGameService;
import service.GameService;

public class GameController {
    private static final GameService gameService = RacingCarGameService.create();

    public static void main(String[] args) {
        gameService.run();
    }
}

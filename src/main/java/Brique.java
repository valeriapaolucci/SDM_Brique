import CLI.IO_Interface;
import CLI.Launch_Game_cli;
import Logic.Launch_Game;

public class Brique {

    public static void main(String[] args) {
        String inter_string = IO_Interface.ChooseInterface();
        if (inter_string.equals("GUI")) {
            Launch_Game game = new Launch_Game();
            game.launch();
        } else {
            Launch_Game_cli game = new Launch_Game_cli();
            game.launch();

        }
    }


}
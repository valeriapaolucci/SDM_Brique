import CLI.IO_Interface;


import Logic.Launch_Game;

public class Brique {

    public static void main(String[] args) {
        boolean chosen_interface = IO_Interface.ChooseInterface();
        Launch_Game game = new Launch_Game(chosen_interface);
        game.launch();
    }
}
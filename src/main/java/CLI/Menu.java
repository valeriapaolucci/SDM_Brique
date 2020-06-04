package CLI;

public class Menu {

    private final String menuOptions;

    public Menu() {
        String newLine = System.getProperty("line.separator");
        menuOptions = "Insert:"
                + newLine + "'0' to play vs. another human;"
                + newLine + "'1' to play vs. AI;"
                + newLine + "'2' to quit.";
    }

    public String getMenuOptions() {
        return menuOptions;
    }
}

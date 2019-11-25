public class main
{
    /**
     * Main function
     */
    public static Game game;
    public static void main(String[] args)
    {
        starting();

        while (Commands.read())
        {
        }
        quit();
    }

    /**
     * Start display
     */
    private static void starting()
    {
        Commands.print("Application has started");
        Commands.print("####################################################");
        Commands.print("");
        Commands.print("Welcome to .... RoleAdventure");
        Commands.print("");
        Commands.print("####################################################");
        Commands.print("");
    }

    /**
     * Exit display
     */
    private static void quit()
    {
        Commands.print("####################################################");
        Commands.print("");
        Commands.print("Good Bye");
        Commands.print("");
        Commands.print("####################################################");
        Commands.print("");
    }
}
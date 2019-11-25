public class main
{
    /**
     * Main function
     */
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
        print("Application has started");
        print("####################################################");
        print("");
        print("Welcome to .... RoleAdventure");
        print("");
        print("####################################################");
        print("");
    }

    /**
     * Exit display
     */
    private static void quit()
    {
        print("####################################################");
        print("");
        print("Good Bye");
        print("");
        print("####################################################");
        print("");
    }

    /**
     * Display an Object with back to line
     * @param o The object that you want to write
     */
    private static void print(Object o)
    {
        System.out.println(o);
    }
}

import java.util.Scanner;

/**
 *  Class that contains all the commands
 */
public class Commands
{
    /**
     * Method to read command from Menu
     * @return true to continue or false to exit
     */
    public static Boolean read()
    {
        Scanner sc = new Scanner(System.in);
        printn("*** Menu ***");
        print("> ");
        switch (sc.nextLine())
        {
            case "help":
                help();
                return true;
            case "exit":
                return false;
            default:
                printn("Command Error");
                printn("");
                help();
                return true;
        }
    }

    /**
     * Display all available commands
     */
    private static void help()
    {
        printn("Commands list :");
        printn("");
        printn("help");
        printn("exit");
        printn("");
        printn("************");
        printn("");
    }

    /**
     * Display an Object with back to line
     * @param o The object that you want to write
     */
    private static void printn(Object o)
    {
        System.out.println(o);
    }

    /**
     * Display an Object without back to line
     * @param o The object that you want to write
     */
    private static void print(Object o)
    {
        System.out.print(o);
    }
}

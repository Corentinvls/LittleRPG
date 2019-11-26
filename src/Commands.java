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
            case "play":
                main.game = new Game();
                printn("New game created !");
                return true;
            case "create":
                if(main.game == null)
                    printn("You must to create a new game with command 'play' !");
                else
                    main.game.create();
                return true;
            case "characters":
                if(main.game == null)
                    printn("You must to create a new game with command 'play' !");
                else
                {
                    if(main.game.characters.size() == 0)
                        printn("No characters found ! Use 'create' to create a character.");
                    else
                        main.game.listCharacters();
                }
                return true;
            case "info":
                int index;
                do
                {
                    printn("Enter '0' to quit the information.");
                    printn("");
                    printn("Enter character index :");
                    print("> ");
                    index = sc.nextInt();
                    if(index > main.game.characters.size() || index < 0)
                        printn("Character not found !");
                    else if (index != 0)
                        printn(main.game.characters.get(index - 1).info());
                }while(index != 0);
                return true;
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
        printn("help        - To get all the commands");
        printn("play        - To create a new game");
        printn("create      - To create a character");
        printn("characters  - To show all existing characters");
        printn("fight       - To show all existing characters");
        printn("info        - To show character information");
        printn("exit        - To quit the application");
        printn("");
        printn("************");
        printn("");
    }

    /**
     * Display an Object with back to line
     * @param o The object that you want to write
     */
    public static void printn(Object o)
    {
        System.out.println(o);
    }

    /**
     * Display an Object without back to line
     * @param o The object that you want to write
     */
    public static void print(Object o)
    {
        System.out.print(o);
    }
}
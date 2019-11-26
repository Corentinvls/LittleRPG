import java.util.ArrayList;
import java.util.List;

public class Game
{
    List<Character> characters;

    public Game()
    {
        characters = new ArrayList<Character>();
    }

    public void create()
    {
        Commands.printn("Creating a character...");
        characters.add(new Character());
        Commands.printn("Character '" + characters.get(characters.size() - 1).name + "' has been created");
    }

    public void listCharacters()
    {
        Commands.printn("List of characters :");
        Commands.printn("");
        //characters.forEach(Commands::printn);
        for(int i = 0; i < characters.size(); i++)
        {
            Commands.printn((i + 1) + " - " + characters.get(i));
        }

        Commands.printn("");
        Commands.printn("**********************");

    }
}
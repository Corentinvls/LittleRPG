import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        for(int i = 0; i < characters.size(); i++)
        {
            Commands.printn((i + 1) + " - " + characters.get(i));
        }

        Commands.printn("");
        Commands.printn("**********************");
    }

    public void fight()
    {
        Character playerTwo = null;

        Commands.printn("You're going to initiate a fight between two fighters.");
        listCharacters();
        Commands.printn("Choose your first fighter id.");
        Commands.print("> ");
        Scanner choiceFighter = new Scanner(System.in);
        Character playerOne = new Character(characters.get(choiceFighter.nextInt()-1));

        do
        {
            if(playerTwo != null && playerOne.name.equals(playerTwo.name))
                Commands.printn("Character already selected.");
            Commands.printn("Choose your second fighter id.");
            Commands.print("> ");
            playerTwo = new Character(characters.get(choiceFighter.nextInt() - 1));
        } while (playerOne.name.equals(playerTwo.name));

        if(playerTwo.initative>playerOne.initative)
        {
           var tempToChange=playerOne;
           playerOne=playerTwo;
           playerTwo=tempToChange;
        }

        Commands.printn("The fight between "+ playerOne.name + " and "+ playerTwo.name + " begin !\n");
        Commands.printn(playerOne.name + " has the initiative.");

        int round = 1;
        while (playerOne.isAlive() && playerTwo.isAlive())
        {
            Commands.printn("");
            Commands.printn("Round : " + round);
            playerOne.attack(playerTwo);
            if (playerTwo.isAlive())
               playerTwo.attack(playerOne);
            round++;
        }
        if (playerOne.isAlive())
            Commands.printn( playerOne.archetype.getArchetypeName() + ": " +playerOne.name + "is the best Winner in the street !");
        else
            Commands.printn( playerTwo.archetype.getArchetypeName() + ": " +playerTwo.name + "is the best Winner in the street !");
        Commands.printn("");
    }
}
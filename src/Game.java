import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Game to start the game that contain all create / list / editing methods
 */
public class Game
{
    List<IArchetype> characters;

    /**
     * Game method that contain the ArrayList of each characters created in the game
     * @see #characters ArrayList of DefaultArchetype
     */
    public Game()
    {
        characters = new ArrayList<IArchetype>();
    }

    /**
     * Create method for creating a new character with all attributes
     */
    public void create()
    {
        Commands.printn("Creating a character...");
        String archetype = createArchetype();
        if (archetype == null)
            return;
        String name = createName();
        if (name == null)
            return;
        int life = createLife();
        if(life == -1)
            return;
        int damage = createDamage();
        if(damage == -1)
            return;
        int initiative = createInitiative();
        if(initiative == -1)
            return;
        switch (archetype)
        {
            case  "warrior" :
                characters.add(new WarriorArchetype(name, damage, life, initiative));
                break;
            case  "wizard" :
                int magicalDamage = createMagicDamage();
                if(magicalDamage == -1)
                    return;
                characters.add(new WizardArchetype(name, damage, life, initiative, magicalDamage));
                break;
            case  "thief" :
                characters.add(new ThiefArchetype(name, damage, life, initiative));
                break;
        }
        Commands.printn("Character '" + characters.get(characters.size() - 1).getName() + "' has been created");
    }

    /**
     * createArchetype method for generate archetype of each new character
     * @return #archetype of the new character
     */
    private String createArchetype()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        String archetype;
        List<String> archetypes = new ArrayList<String>();
        archetypes.add("warrior");
        archetypes.add("wizard");
        archetypes.add("thief");
        listArchetype(archetypes);
        do
        {
            Commands.printn("");
            Commands.printn("Enter '-1' to cancel");
            Commands.printn("");
            Commands.print("> Choose your class : ");
            archetype = sc.nextLine().toLowerCase();
            if (archetype.equals("-1"))
                return null;
            if (archetype.equals(""))
            {
                Commands.printn("Class is empty !");
                continue;
            }
            if (archetypes.indexOf(archetype) == -1)
            {
                Commands.printn("The class '" + archetype + "' doesn't exist !");
                continue;
            }
            do
            {
                Commands.printn("Valid the class '" + archetype + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return archetype;
    }

    /**
     * createName method for create new character player name
     * @return #name of the new character created
     */
    private String createName()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        String name;
        do
        {
            Commands.printn("");
            Commands.printn("Enter '-1' to cancel");
            Commands.printn("");
            Commands.print("> Enter your name : ");
            name = sc.nextLine();
            if(name.equals("-1"))
                return null;
            if(name.equals(""))
            {
                Commands.printn("Name is empty !");
                continue;
            }
            if(usedName(name))
                continue;
            do
            {
                Commands.printn("Valid the name '" + name + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return name;
    }

    /**
     * usedName method for check if a name is already use or not
     * @param name : the name of the character
     * @return boolean true if name already in use and false if name available
     */
    private boolean usedName(String name)
    {
        for(IArchetype character : characters)
        {
            if(character.getName().equals(name))
            {
                Commands.printn("Name is already used !");
                return true;
            }
        }
        return false;
    }

    /**
     * createLife method for create new character player life
     * @return #life of the new character created
     */
    private int createLife()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int life;
        do
        {
            Commands.print("");
            Commands.print("Enter '-1' to cancel");
            Commands.print("");
            life = Commands.inputInt("Enter character's life (1 - 1000) :", 1, 1000);
            if(life == -1)
                return life;
            do
            {
                Commands.printn("Valid life '" + life + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return life;
    }

    /**
     * createDamage method for create new character player damage
     * @return #damage of the new character created
     */
    private int createDamage()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int damage;
        do
        {
            Commands.print("");
            Commands.print("Enter '-1' to cancel");
            Commands.print("");
            damage = Commands.inputInt("Enter character's power strike (1 - 500) :", 1, 500);
            if(damage == -1)
                return damage;
            do
            {
                Commands.printn("Valid power strike '" + damage + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return damage;
    }

    /**
     * createMagicDamage method for create new character wizard player magic damage
     * @return #magicDamage of the new character created
     */
    private int createMagicDamage()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int magicDamage;
        do
        {
            Commands.print("");
            Commands.print("Enter '-1' to cancel");
            Commands.print("");
            magicDamage = Commands.inputInt("Enter character's magic damage (1 - 500) :", 1, 500);
            if(magicDamage == -1)
                return  magicDamage;
            do
            {
                Commands.printn("Valid magic damage '" + magicDamage + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return magicDamage;
    }

    /**
     * createInitiative method for create new character player initiative
     * @return #initiative of the new character created
     */
    private int createInitiative()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int initiative;
        do
        {
            Commands.print("");
            initiative = Commands.inputInt("Enter character's initiative (1 - 100) :", 1, 100);
            if(initiative == -1)
                return initiative;
            do
            {
                Commands.printn("Valid initiative '" + initiative + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return initiative;
    }

    /**
     * listArchetype method to list all of the archetypes available for character creation.
     * @param archetypes available in the list
     */
    public void listArchetype(List<String> archetypes)
    {
        Commands.printn("List of archetype :");
        Commands.printn("");
        for(int i = 0; i < archetypes.size(); i++)
        {
            Commands.printn(" - " + archetypes.get(i));
        }

        Commands.printn("");
        Commands.printn("**********************");
    }

    /**
     * listCharacters method to display all characters already created
     */
    public void listCharacters()
    {
        Commands.printn("List of characters :");
        Commands.printn("");
        for(int i = 0; i < characters.size(); i++)
        {
            Commands.printn((i + 1) + " - " + characters.get(i).getName() +
                    " (" + characters.get(i).getArchetypeName() + ")");
        }

        Commands.printn("");
        Commands.printn("**********************");
    }


    /**
     * fight method to start a fight between two players
     * Select two characters in the characters list who have to fight
     */
    public void fight()
    {
        IArchetype playerTwo = null;

        Commands.printn("You're going to initiate a fight between two fighters.");
        listCharacters();
        IArchetype playerOne = characters.get(Commands.inputInt("Choose your first fighter id : ")-1);

        do
        {
            if(playerTwo != null && playerOne.getName().equals(playerTwo.getName()))
                Commands.printn("Character already selected.");
            playerTwo = characters.get(Commands.inputInt("Choose your second fighter id : ") - 1);
        } while (playerOne.getName().equals(playerTwo.getName()));

        if(playerTwo.getInitiative() > playerOne.getInitiative())
        {
           var tempToChange=playerOne;
           playerOne = playerTwo;
           playerTwo = tempToChange;
        }

        Commands.printn("The fight between "+ playerOne.getName() + " and "+ playerTwo.getName() + " begin !\n");
        Commands.printn(playerOne.getName() + " has the initiative.");

        int round = 1;
        while (isAlive(playerOne) && isAlive(playerTwo))
        {
            Commands.printn("");
            Commands.printn("*** Round : " + round + " ***");
            attackFight(playerOne, playerTwo);
            if (isAlive(playerTwo))
                attackFight(playerTwo, playerOne);
            round++;
        }
        if (isAlive(playerOne))
            Commands.printn( playerOne.getArchetypeName() + " : " + playerOne.getName() + " is the best Winner in the street !");
        else
            Commands.printn( playerTwo.getArchetypeName() + " : " + playerTwo.getName() + " is the best Winner in the street !");
        Commands.printn("");
        playerOne.reset();
        playerTwo.reset();
    }

    /**
     * attackFight method for display all characters information at each rounds start
     * @param striker is the character who become an attack
     * @param target is the character who receive the attack
     */
    private void attackFight(IArchetype striker, IArchetype target)
    {

        Commands.printn("Name         : " + striker.getName());
        Commands.printn("Archetype    : " + striker.getArchetypeName());
        Commands.printn("Health point : " + striker.getLife() + " / " + striker.getMaxLife());
        Commands.printn("Power Attack : " + striker.getDamage());
        int damageSend = striker.attack();
        Commands.printn("Damage       : " + damageSend);
        Commands.printn("");
        target.setDamageReceived(damageSend);
        Commands.printn("");

        if(!isAlive(target))
            Commands.printn(target.getName() + " is dead !");
    }

    /**
     * isAlive method use for check if character is alive or not checking is life
     * @param player is the player checked
     * @return true if life is superior 0 , false if life is inferior 0
     */
    public boolean isAlive(IArchetype player)
    {
        return player.getLife() > 0;
    }

    /**
     * remove method to remove a character from the character list with his index number
     */
    public void remove()
    {
        String valid = "";
        Scanner selectRemove = new Scanner(System.in);
        main.game.listCharacters();
        int indexRemove;
        do
        {
            Commands.printn("");
            Commands.printn("Enter '-1' to cancel");
            Commands.printn("");
            indexRemove = Commands.inputInt("Enter character index : ");
            if(indexRemove == -1)
                break;
            else if (indexRemove < 1 || indexRemove > characters.size())
            {
                Commands.printn("Character not found !");
                continue;
            }
            do
            {
                Commands.printn("Valid remove '"  + characters.get(indexRemove - 1).getName() + "' ? Yes / No");
                Commands.print("> ");
                valid = selectRemove.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        if(indexRemove != -1)
            characters.remove(indexRemove - 1);
        Commands.printn("**********************");
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game
{
    List<DefaultArchetype> characters;

    public Game()
    {
        characters = new ArrayList<DefaultArchetype>();
    }

    public void create()
    {
        Commands.printn("Creating a character...");
        switch (createArchetype())
        {
            case  "warrior" :
                characters.add(new WarriorArchetype(createName(),createDamage(), createLife(), createInitiative()));
                break;
            case  "wizard" :
                characters.add(new WizardArchetype(createName(),createDamage(), createLife(), createInitiative(),createMagicDamage()));
                break;
            case  "thief" :
                characters.add(new ThiefArchetype(createName(),createDamage(), createLife(), createInitiative()));
                break;
            default:
                characters.add(new DefaultArchetype(createName(), createDamage(), createLife(), createInitiative()));
        }
        Commands.printn("Character '" + characters.get(characters.size() - 1).getName() + "' has been created");
    }

    private String createName()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        String name;
        do
        {
            Commands.print("");
            Commands.print("> Enter your name : ");
            name = sc.nextLine();
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

    private int createDamage()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int damage = 0;
        do
        {
            Commands.print("");
            Commands.print("> Enter character's power strike : ");
            damage = sc.nextInt();
            sc.nextLine();
            if(damage == 0)
            {
                Commands.printn("Power Strike is null !");
                continue;
            }
            do
            {
                Commands.printn("Valid power strike '" + damage + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return damage;
    }

    private int createMagicDamage()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int magicDamage = 0;
        do
        {
            Commands.print("");
            Commands.print("> Enter character's magic damage : ");
            magicDamage = sc.nextInt();
            sc.nextLine();
            if(magicDamage == 0)
            {
                Commands.printn("Magic damage is null !");
                continue;
            }
            do
            {
                Commands.printn("Valid magic damage '" + magicDamage + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return magicDamage;
    }

    private int createInitiative()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int initiative = 0;
        do
        {
            Commands.print("");
            Commands.print("> Enter character's initiative: ");
            initiative = sc.nextInt();
            sc.nextLine();
            if(initiative == 0)
            {
                Commands.printn("Initiative is null !");
                continue;
            }
            do
            {
                Commands.printn("Valid initiative '" + initiative + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return initiative;
    }

    private int createLife()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int life = 0;
        do
        {
            Commands.print("");
            Commands.print("> Enter character's life : ");
            life = sc.nextInt();
            sc.nextLine();
            if(life == 0)
            {
                Commands.printn("Life is null !");
                continue;
            }
            do
            {
                Commands.printn("Valid life '" + life + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return life;
    }
    private boolean usedName(String name)
    {
        for(DefaultArchetype character : characters)
        {
            if(character.getName().equals(name))
            {
                Commands.printn("Name is already used !");
                return true;
            }
        }
        return false;
    }

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
            Commands.print("");
            Commands.print("> Choose your class: ");
            archetype = sc.nextLine().toLowerCase();
            if(archetype == "")
            {
                Commands.printn("Class is empty !");
                continue;
            }
            if(archetypes.indexOf(archetype) == -1)
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

    public void fight()
    {
        DefaultArchetype playerTwo = null;

        Commands.printn("You're going to initiate a fight between two fighters.");
        listCharacters();
        Commands.printn("Choose your first fighter id.");
        Commands.print("> ");
        Scanner choiceFighter = new Scanner(System.in);
        DefaultArchetype playerOne = characters.get(choiceFighter.nextInt()-1);

        do
        {
            if(playerTwo != null && playerOne.getName().equals(playerTwo.getName()))
                Commands.printn("Character already selected.");
            Commands.printn("Choose your second fighter id.");
            Commands.print("> ");
            playerTwo = characters.get(choiceFighter.nextInt() - 1);
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

    private void attackFight(DefaultArchetype striker, DefaultArchetype target)
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
     * @return life > 0
     * */
    public boolean isAlive(DefaultArchetype player)
    {
        return player.getLife() > 0;
    }

    public void remove()
    {
        String valid = "null";
        Scanner selectRemove = new Scanner(System.in);
        main.game.listCharacters();
        int indexRemove;
        do
        {
            Commands.printn("");
            Commands.print("> Enter character index : ");
            indexRemove = selectRemove.nextInt();
            selectRemove.nextLine();
            if(indexRemove < 1 || indexRemove > characters.size())
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
        characters.remove(indexRemove - 1);
        Commands.printn("**********************");
    }
}
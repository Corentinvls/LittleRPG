import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Character
{
    public DefaultArchetype archetype;
    public String name;
    public int life;
    public int damage;
    public int initative;

    public Character()
    {
        switch (createArchetype())
        {
            case  "warrior" :
                archetype = new WarriorArchetype();
                break;
            case  "wizard" :
                archetype = new WizardArchetype();
                break;
            case  "thief" :
                archetype = new ThiefArchetype();
                break;
            default:
                archetype = new DefaultArchetype();
        }
        life = archetype.getLife();
        damage = archetype.getAttack();
        initative = archetype.getInitiative();
        name = createName();
        archetype.characterName = this.name;
    }

    public Character(Character character)
    {
        this.archetype = character.archetype;
        this.life = character.life;
        this.damage = character.damage;
        this.initative = character.initative;
        this.name = character.name;
        this.archetype.characterName = this.name;
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

    private Boolean usedName(String name)
    {
        for(Character character : main.game.characters)
        {
            if(character.name.equals(name))
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

    /**
     * @return life > 0
     * */
    public Boolean isAlive()
    {
        return life > 0;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public String info()
    {
        return name + " " + archetype.toString();
    }

    public void attack(Character target)
    {
        int damageSend = this.archetype.getDamageSend();

        Commands.printn("Name         : " + this.name);
        Commands.printn("Archetype    : " + this.archetype.getArchetypeName());
        Commands.printn("Health point : " + this.life);
        Commands.printn("Power Attack : " + this.damage);
        Commands.printn("Damage       : " + damageSend);
        Commands.printn("");
        target.defend(damageSend);
        Commands.printn("");

        if(!target.isAlive())
            Commands.printn(target.name + " is dead !");
    }

    private void defend(int damage)
    {
        this.life -= archetype.setDamageReceived(damage);
    }

}
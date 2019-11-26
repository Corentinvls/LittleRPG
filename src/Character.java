import java.util.Scanner;

public class Character
{
    public DefaultArchetype archetype;
    public String name;
    public int life;
    public int attack;
    public int initative;

    public Character()
    {
        archetype = new DefaultArchetype();
        life = archetype.getLife();
        attack = archetype.getAttack();
        initative = archetype.getInitiative();

        Scanner sc = new Scanner(System.in);
        do
        {
            Commands.print("");
            Commands.print("> Enter your name : ");
            name = sc.nextLine();
            Commands.printn("Valid the name '" + name + "' ? Yes / No");
        } while(!sc.nextLine().toLowerCase().equals("yes"));
    }

    /**
     * @return life > 0
     * */
    public Boolean IsAlive()
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
}
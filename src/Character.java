import java.util.Random;
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
        archetype = new DefaultArchetype();
        life = archetype.getLife();
        damage = archetype.getAttack();
        initative = archetype.getInitiative();

        name = createName();
    }



    public Character(Character character)
    {
        this.archetype = character.archetype;
        this.life = character.life;
        this.damage = character.damage;
        this.initative = character.initative;
        this.name = character.name;
    }

    private String createName() {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        String name;
        do
        {
            Commands.print("");
            Commands.print("> Enter your name : ");
            name = sc.nextLine();
            if(name == "")
            {
                Commands.printn("Name is empty");
                continue;
            }
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
        int damageSend=this.archetype.getDamageSend();
        target.defend(damageSend);
        Commands.printn("Name         : " + this.name);
        Commands.printn("Archetype    : " + this.archetype.getArchetypeName());
        Commands.printn("Health point : " + this.life);
        Commands.printn("Power Attack : " + this.damage);
        Commands.printn("Damage       : " + damageSend);
        Commands.printn("");
        if(!target.isAlive())
            Commands.printn(target.name + " is dead !");

    }

    private void defend(int damage)
    {
        this.life -= archetype.setDamageReceived(damage);
    }

}
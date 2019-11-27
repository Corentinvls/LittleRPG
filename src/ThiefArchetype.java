import java.util.Random;

public class ThiefArchetype extends DefaultArchetype
{
    private int criticalChance;
    private boolean canCritical;
    private int evadeChance;

    public ThiefArchetype (String name)
    {
        super(name) ;
        this.criticalChance = 10;
        this.canCritical = true;
        this.evadeChance = 20;
        this.setArchetypeName("Thief");
    }

    @Override
    public int attack()
    {
        int damage = 0;
        if(this.canCritical)
        {
            if(new Random().nextInt(100) < this.criticalChance)
            {
                damage *= this.getDamage() * 2;
                this.canCritical = false;
                Commands.printn(this.getName() + " made a critical hit : " + damage);
            }
        }
        else
            this.canCritical = true;
        return damage;
    }

    @Override
    public void setDamageReceived(int damageReceived)
    {
        if(new Random().nextInt(100) < this.evadeChance)
        {
            Commands.printn(this.getName() + " dodge the attack: " + damageReceived + " damage received.");
        }
    }

}

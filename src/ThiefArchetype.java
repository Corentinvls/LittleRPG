import java.util.Random;

public class ThiefArchetype extends DefaultArchetype
{
    private int criticalChance;
    private boolean canCritical;
    private int evadeChance;

    public ThiefArchetype (String name, int damage, int life, int initiative)
    {
        super(name, damage, life, initiative) ;
        this.criticalChance = 10;
        this.canCritical = true;
        this.evadeChance = 20;
        this.setArchetypeName("Thief");
    }

    @Override
    public int attack()
    {
        int damage = this.getDamage();
        if(this.canCritical)
        {
            if(new Random().nextInt(100) < this.criticalChance)
            {
                damage *=  2;
                this.canCritical = false;
                Commands.printn(this.getName() + " made a critical hit !");
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
            damageReceived = 0;
            Commands.printn(this.getName() + " dodge the attack : 0 damage received.");
        }
        this.setLife(this.getLife() - damageReceived);
    }

    @Override
    public void reset()
    {
        this.setLife(this.getMaxLife());
        this.canCritical = true;
    }
}
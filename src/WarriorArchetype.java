import java.util.Random;

public class WarriorArchetype extends DefaultArchetype
{
    private float shield;
    public WarriorArchetype (String name)
    {
        super(name) ;
        this.shield = 0.2f;
        this.setArchetypeName("Warrior");
    }

    @Override
    public void setDamageReceived(int damageReceived)
    {
        Commands.printn(this.getName() + "'s shield reduced : " + shieldUsed(damageReceived) + " damage.");
        this.setLife(this.getLife() - damageReduced(damageReceived));
    }

    private int shieldUsed (int damageReceived)
    {
        return (int)(damageReceived * this.shield);
    }

    private int damageReduced (int damageReceived)
    {
        return (int)(damageReceived * (1 - this.shield));
    }

    @Override
    public void reset()
    {
        this.setLife(100);
    }
}
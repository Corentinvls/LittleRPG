import java.util.Random;

public class WizardArchetype extends DefaultArchetype
{

    private int magicDamage;
    public WizardArchetype (String name,int damage, int life, int initiative,int magicDamage)
    {
        super(name, damage, life, initiative);
        this.magicDamage = magicDamage;
        this.setArchetypeName("Wizard");
    }

    @Override
    public int attack()
    {
        int damageSend = this.getDamage() + this.magicDamage;
        if(this.magicDamage == 0)
        {
            Commands.printn(this.getName() + " 's stick is broken !");
        }
        else
        {
            Commands.printn(this.getName() + "'s stick inflict : " + (this.magicDamage) + " magical damage.");
            this.magicDamage /= 2;
        }
        return  damageSend;
    }

    @Override
    public void reset()
    {
        this.setLife(this.getMaxLife());
        this.magicDamage = 50;
    }
}
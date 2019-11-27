import java.util.Random;

public class WizardArchetype extends DefaultArchetype
{

    private int magicDamage;
    public WizardArchetype (String name)
    {
        super(name);
        this.magicDamage = 50;
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
        this.setLife(100);
        this.magicDamage = 50;
    }
}
import java.util.Random;

public class WizardArchetype extends DefaultArchetype
{

    private int magicDamage ;
    public WizardArchetype (String name)
    {
        super(name) ;
        this.magicDamage = 30 ;
        this.setArchetypeName("Wizard");
    }

    @Override
    public int attack()
    {
        int damageSend = this.getDamage() + this.magicDamage;
        if(this.magicDamage == 0){
            Commands.printn(this.getName() + " 's STICK IS BROKEN!!!! !");
        } else {
            Commands.printn(this.getName() + "'s stick inflict: " + (this.magicDamage) + " magical damage.");
            this.magicDamage /= 2;
        }
        return  damageSend;
    }


}
import java.util.Random;

public class WizardArchetype extends DefaultArchetype
{
    int magicDamage = 30;
    public WizardArchetype () { archetypeName = "Wizard"; }

    @Override
    public int getDamageSend()
    {
        int damageSend = new Random().nextInt(10) * attack + this.magicDamage;
        if(this.magicDamage == 0){
            Commands.printn(characterName + " 's STICK IS BROKEN!!!! !");
        } else {
            Commands.printn(characterName + "'s stick inflict: " + (this.magicDamage) + " magical damage.");
            this.magicDamage /= 2;
        }
        return  damageSend;
    }
}
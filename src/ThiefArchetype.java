import java.util.Random;

public class ThiefArchetype extends DefaultArchetype
{
    int critcalChanche;
    Boolean canCritical;
    int dodgeChance;
    Boolean canDodge;

    public ThiefArchetype ()
    {
        archetypeName = "Thief";
        critcalChanche = 10;
        canCritical = true;
        dodgeChance = 20;
        canCritical = false;
    }

    @Override
    public int setDamageReceived(int damageReceived)
    {
        this.canCritical = getCritical();
        if (canCritical) {
            int damageCritique = damageReceived * 2;
            Commands.printn(characterName + " give a critical hit : " + damageCritique + " damage.");
        } else {
            Commands.printn(characterName + "'s give  : " + (int)(damageReceived * 0.2) + " damage.");
        }

        return (int)(damageReceived * 0.8);
    }

    public Boolean getCritical() {
    if (this.critcalChanche < new Random().nextInt(100) )
        return true;
    return false;
    }
}

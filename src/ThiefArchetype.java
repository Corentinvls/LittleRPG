import java.util.Random;

public class ThiefArchetype extends DefaultArchetype
{
    int critcalChanche;
    Boolean canCritical;
    int evadeChance;
    Boolean canEvade;

    public ThiefArchetype ()
    {

        archetypeName = "Thief";
        critcalChanche = 10;
        canCritical = true;
        evadeChance = 20;
        canEvade = true;
    }

    @Override
    public int getDamageSend()
    {
        int damage;
        if (this.critcalChanche < new Random().nextInt(100) & canCritical )
        {
            damage = attack * 2;
            Commands.printn(characterName + " give a critical hit : " + damage + " damage.");
            canCritical = false;
        } else {
            damage = attack;
            Commands.printn(characterName + " give  : " + damage + " damage.");
            if (!canCritical) {
                canCritical = true;
            }
        }
        return damage;
    }

    @Override
    public int setDamageReceived(int damageReceived)
    {
        if (this.evadeChance < new Random().nextInt(100) & canEvade )
        {
            damageReceived = 0;
            Commands.printn(characterName + " dodge the attack: " + damageReceived + " damage received.");
            canEvade = false;
        } else {
            Commands.printn(characterName + " miss to evade: " + damageReceived + " damage received.");
            if (!canEvade) {
                canEvade = true;
            }
        }
        return damageReceived;
    }
}

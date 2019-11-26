import java.util.Random;

public class WarriorArchetype extends DefaultArchetype
{

    public WarriorArchetype ()
    {
        archetypeName = "Warrior";
    }

    @Override
    public int setDamageReceived(int damageReceived)
    {
        Commands.printn(characterName + "'s chibre reduced : " + (int)(damageReceived * 0.2) + " damage.");
        return (int)(damageReceived * 0.8);
    }
}
import java.util.Random;

public class ThiefArchetype extends DefaultArchetype
{

    public ThiefArchetype () { archetypeName = "Thief"; }

    @Override
    public int setDamageReceived(int damageReceived)
    {
        Commands.printn(characterName + "'s chibre reduced : " + (int)(damageReceived * 0.2) + " damage.");
        return (int)(damageReceived * 0.8);
    }
}

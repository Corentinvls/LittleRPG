/**
 * IArchetype interface
 */
public interface IArchetype
{
    String getName();
    String getArchetypeName();
    int getLife();
    int getMaxLife();
    int getDamage();
    int getInitiative();
    void reset();
    int attack();
    void setDamageReceived(int damageReceived);
    String toString();
}
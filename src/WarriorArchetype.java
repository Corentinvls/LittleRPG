/**
 * WarriorArchetype Class extends by DefaultArchetype
 * @see #shield int number that reduce defined damage quantity
 */
public class WarriorArchetype extends DefaultArchetype
{
    private float shield;

    /**
     * WarriorArchetype constructor
     * @param name string to set the character name
     */
    public WarriorArchetype (String name)
    {
        super(name);
        this.shield = 0.2f;
        this.setArchetypeName("Warrior");
    }

    /**
     * Override method reset from DefaultArchetype to reset the archetype properties
     */
    @Override
    public void reset()
    {
        this.setLife(100);
    }

    /**
     * Override method setDamageReceived from DefaultArchetype to update life after receiving damage
     * @param damageReceived int quantity of damage received
     */
    @Override
    public void setDamageReceived(int damageReceived)
    {
        Commands.printn(this.getName() + "'s shield reduced : " + shieldUsed(damageReceived) + " damage.");
        this.setLife(this.getLife() - damageReduced(damageReceived));
    }

    /**
     * Method shieldUsed
     * @param damageReceived
     * @return int blocked damage
     */
    private int shieldUsed (int damageReceived)
    {
        return (int)(damageReceived * this.shield);
    }

    /**
     * Method damageReduced
     * @param damageReceived
     * @return int reduced damage
     */
    private int damageReduced (int damageReceived)
    {
        return (int)(damageReceived * (1 - this.shield));
    }
}
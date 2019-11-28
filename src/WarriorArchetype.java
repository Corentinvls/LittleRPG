/**
 * WarriorArchetype Class implements IArchetype
 * @see #characterName string Name of the archetype's character
 * @see #archetypeName string Name of the archetype
 * @see #life   int life  of the archetype
 * @see #damage int attack of the archetype
 * @see #initiative int initiative of the archetype
 * @see #shield int number that reduce defined damage quantity
 */
public class WarriorArchetype implements IArchetype
{
    private String characterName;
    private String archetypeName;
    private int damage;
    private int life;
    private int maxLife;
    private int initiative;

    private float shield;

    /**
     * WarriorArchetype constructor
     * @param name string to set the character name
     * @param damage int to set the character damage
     * @param life int to set the character life
     * @param initiative int to set the character initiative
     */
    public WarriorArchetype (String name, int damage, int life, int initiative)
    {
        this.characterName = name;
        this.archetypeName = "Warrior";
        this.damage = damage;
        this.life = life;
        this.maxLife = life;
        this.initiative = initiative;

        this.shield = 0.2f;
    }

    /**
     * Getter getName
     * @return string of the character name
     */
    public String getName()
    {
        return this.characterName;
    }

    /**
     * Getter getArchetypeName
     * @return string of the archetype name
     */
    public String getArchetypeName()
    {
        return this.archetypeName;
    }

    /**
     * Getter getLife
     * @return int life of the archetype
     */
    public int getLife()
    {
        return this.life;
    }

    /**
     * Getter getMaxLife
     * @return int max life of the archetype
     */
    public int getMaxLife()
    {
        return this.maxLife;
    }

    /**
     * Getter getDamage
     * @return int of the archetype damage
     */
    public int getDamage()
    {
        return this.damage;
    }

    /**
     * Getter getInitiative
     * @return int of the archetype initiative
     */
    public int getInitiative ()
    {
        return this.initiative;
    }

    /**
     * Method to reset the archetype properties
     */
    public void reset()
    {
        this.life = this.maxLife;
    }

    /**
     * Method attack
     * @return int of archetype attack
     */
    public int attack()
    {
        return getDamage();
    }

    /**
     * Method setDamageReceived to update life after receiving damage
     * @param damageReceived int quantity of damage received
     */
    public void setDamageReceived(int damageReceived)
    {
        Commands.printn(this.getName() + "'s shield reduced : " + shieldUsed(damageReceived) + " damage.");
        this.life -= damageReduced(damageReceived);
    }

    /**
     * Method shieldUsed
     * @param damageReceived int quantity of damage received
     * @return int blocked damage
     */
    private int shieldUsed (int damageReceived)
    {
        return (int)(damageReceived * this.shield);
    }

    /**
     * Method damageReduced
     * @param damageReceived int quantity of damage received
     * @return int reduced damage
     */
    private int damageReduced (int damageReceived)
    {
        return (int)(damageReceived * (1 - this.shield));
    }

    /**
     * Override method toString from Object
     * @return String with all archetype attributes
     */
    public String toString()
    {
        return  this.characterName + " is a " + this.archetypeName + ", had " + this.life + " HP, " + this.damage + " strength and " + this.initiative + " initiative.";
    }
}
/**
 * WizardArchetype Class implements IArchetype
 * @see #characterName string Name of the archetype's character
 * @see #archetypeName string Name of the archetype
 * @see #life   int life  of the archetype
 * @see #damage int attack of the archetype
 * @see #initiative int initiative of the archetype
 * @see #magicDamage int number to do magical damage
 * @see #maxMagicDamage int number to do magical damage
 */
public class WizardArchetype implements IArchetype
{
    private String characterName;
    private String archetypeName;
    private int damage;
    private int life;
    private int maxLife;
    private int initiative;

    private int magicDamage;
    private int maxMagicDamage;

    /**
     * WizardArchetype constructor
     * @param name string to set the character name
     * @param damage int to set the character damage
     * @param life int to set the character life
     * @param initiative int to set the character initiative
     * @param magicDamage int to set the character magic damage
     */
    public WizardArchetype (String name,int damage, int life, int initiative,int magicDamage)
    {
        this.characterName = name;
        this.archetypeName = "Wizard";
        this.damage = damage;
        this.life = life;
        this.maxLife = life;
        this.initiative = initiative;

        this.magicDamage = magicDamage;
        this.maxMagicDamage = magicDamage;
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
        this.magicDamage = this.maxMagicDamage;
    }

    /**
     * Method attack
     * @return int of archetype attack
     */
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

    /**
     * Method setDamageReceived to update life after receiving damage
     * @param damageReceived int quantity of damage received
     */
    public void setDamageReceived(int damageReceived)
    {
        this.life -= damageReceived;
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
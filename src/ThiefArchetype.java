import java.util.Random;

/**
 * ThiefArchetype Class implements IArchetype
 * @see #characterName string Name of the archetype's character
 * @see #archetypeName string Name of the archetype
 * @see #life   int life  of the archetype
 * @see #damage int attack of the archetype
 * @see #initiative int initiative of the archetype
 * @see #canCritical boolean for check if thief can do a critical hit
 * @see #criticalChance int chance number in percent to do a critical hit
 * @see #dodgeChance int chance number in percent to dodge a hit
 */
public class ThiefArchetype implements IArchetype
{
    private String characterName;
    private String archetypeName;
    private int damage;
    private int life;
    private int maxLife;
    private int initiative;

    private int criticalChance;
    private boolean canCritical;
    private int dodgeChance;

    /**
     * ThiefArchetype constructor
     * @param name string to set the character name
     * @param damage int to set the character damage
     * @param life int to set the character life
     * @param initiative int to set the character initiative
     */
    public ThiefArchetype (String name, int damage, int life, int initiative)
    {
        this.characterName = name;
        this.archetypeName = "Thief";
        this.damage = damage;
        this.life = life;
        this.maxLife = life;
        this.initiative = initiative;

        this.criticalChance = 10;
        this.canCritical = true;
        this.dodgeChance = 20;
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
        this.canCritical = true;
    }

    /**
     * Method attack
     * @return int of archetype attack
     */
    public int attack()
    {
        int damage = this.getDamage();
        if(this.canCritical)
        {
            if(new Random().nextInt(100) < this.criticalChance)
            {
                damage *=  2;
                this.canCritical = false;
                Commands.printn(this.getName() + " made a critical hit !");
            }
        }
        else
            this.canCritical = true;
        return damage;
    }

    /**
     * Method setDamageReceived to update life after receiving damage
     * @param damageReceived int quantity of damage received
     */
    public void setDamageReceived(int damageReceived)
    {
        if(new Random().nextInt(100) < this.dodgeChance)
        {
            damageReceived = 0;
            Commands.printn(this.getName() + " dodge the attack : 0 damage received.");
        }
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
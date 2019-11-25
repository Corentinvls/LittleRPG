import java.util.Random;

public class DefaultArchetype
{
        private String name;
        private int attack;
        private int life;
        private int initiative;

        /**
         * Archetype constructor.
         * @see #name   string name of the archetype
         * @see #attack int attack of the archetype
         * @see #life   int life  of the archetype
         * @see #initiative int initiative of the archetype
         */
        public DefaultArchetype ()
        {
            name= "unknow";
            attack = 10;
            life = 100;
            initiative = 100;
        }

        /**
         * Method getName.
         * @return String name of the archetype
         */
        public String getName () {
            return name;
        }

        /**
         * Method getAttack.
         * @return int Attack of the archetype
         */
        public int getAttack () {
            return attack;
        }

        /**
         * Method getLife.
         * @return int life of the archetype
         */
        public int getLife () {
            return life;
        }

        /**
         * Method getInitiative.
         * @return int initiative of the archetype
         */
        public int getInitiative () {
            return initiative;
        }

        /**
         * Method getDamageSend.
         * @return int Damage send of the archetype
         */
        public int getDamageSend()
        {
            return new Random().nextInt(10) * attack;
        }

        /**
         * Method setDamageReceived.
         * @param damageReceived quantity of damage received
         * update life after receiving damage
         */
        public void setDamageReceived(int damageReceived)
        {
            life -= damageReceived;
        }
        /**
         * Method toString.
         * @return String all archetype's attributes
         */
        public String toString()
        {
            return name + " had " + life + " HP, " + attack + " strength and " + initiative + " initiative";
        }
    }



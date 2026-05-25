package math130.gui;

public class Monster extends YourMoodCharacter {

    private int heal;

    /*
    Monster constructor that extends from the YourMoodCharacter parent class and uses super to copy over the variables
    while also adding the unique feature of the monster class and the whole reason for the parent class being created
    which is the feature of being able to heal
     */

    public Monster(int health, boolean alive, String emotion, int defence, int heal) {
        super(health, alive, emotion, defence);
        this.heal = heal;
    }

    /*
    basic constructor to help the controller identify a set object
     */

    public Monster() {
        this(100, true, "Angry", 10, 10);
    }


    /*
    This method is called when the attack method from the YourMoodCharacter is called in respect to the monster object
    this specific method returns the Max amount of possible damage needed, if you notice the damage is always increased by one
    for example when the monster is angry its max damage is 20, however the minimum is 5 damage which is the base,
    but since the Math.random will never return the greatest number since the (int) is being attached to the Math.random
    the number returned cannot equal the max number of whats supposed to be 15 for sad, so the number has to be 16 for the max value
     */
    public int getMax() {
        if (getEmotion().equals("Sad")) {
            return 16;
        }
        if (getEmotion().equals("Angry")) {
            return 81;
        }
        if (getEmotion().equals("Happy")) {
            return 201;
        }
        return 41;

    }


    /*
    This method is called when the attack method from the YourMoodCharacter is called in respect to the monster object
    this specific method returns the base  amount of possible damage needed (minimum)
     */

    public int getBase() {
        if (getEmotion().equals("Sad")) {
            return 5;
        }
        if (getEmotion().equals("Angry")) {
            return 60;
        }
        if (getEmotion().equals("Happy")) {
            return 0;
        } else {
            return 10;
        }
    }


    /*
    This method is the unique feature of the monster class in which it will heal based on the emotion it
    currently is in. So this method returns the correct amount of health that is supposed to be gained in the monster's
    current emotion
     */
    public int getHeal() {
        if (getEmotion().equals("Sad")) {
            return 100;
        }
        if (getEmotion().equals("Angry")) {
            return 25;
        }
        if (getEmotion().equals("Happy")) {
            return 50;
        } else {
            return 0;
        }
    }


    /*
    So although this method setEmotion is already in the parent class of YourMoodCharacter, the problem I had with
    this whole game is that the monster isn't a user choice battle system, the monster has it's decisions decided by
    randomness. So whenever the monster's choice is chosen through randomness, the only time the defence can be changed
    is when the emotion is changed, so by using super to recall the original setEmotion method from the parent class,
    I also added the if statements to set the defence of the monster based on the emotion it is changed to.
     */
    public void setEmotion(String yes) {
        super.setEmotion(yes);
        if (yes.equals("Sad")) {
            setDefence(80);
        }
        if (yes.equals("Angry")) {
            setDefence(0);
        }
        if (yes.equals("Happy")) {
            setDefence(5);
        }
    }


    /*
    This method using the set and get accessors of the health and heal variables to update the health of the monster
    based on the current emotion of the monster
     */
    public void heal() {
        setHealth(getHealth() + getHeal());
    }

}


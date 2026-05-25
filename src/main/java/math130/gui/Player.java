package math130.gui;

public class Player extends YourMoodCharacter {

    /*
    Unique variables for this child class of YourMoodCharacter
     */

    private double critValue;
    private boolean crit;
    
    /*
    Constructors for this class 
     */
    public Player(int health, boolean alive, String emotion, int defence, double critValue, boolean crit) {
        super(health, alive, emotion, defence);
        this.crit = crit;
        this.critValue = critValue;
    }

    public Player() {
        this(10, false, "Happy", 10, 1.0, false);
    }
    /*
    This is the main method that is unique to the player subclass
    in which the attack method is already created in the parent class 
    YourMoodCharacter but now the idea of a 20% critical hit is implemented
    and then super is used to call the original attack method while adding on
    the condition if ult is true using the ult(boolean) method below
     */
    public int attack(int max, int base, double ultimate) {
        ult(false);
        if ((int) (Math.random() * 10) + 1 >= 9) {
            ult(true);
            return (int) (super.attack(max, base) * ultimate);
        }
        return (super.attack(max, base));

    }

    public void ult(boolean yes) {
        this.crit = yes;
    }

    /*
    These next two methods are the value constraints of an attack based on the
    current emotion the player is in, the getMax value is one more than it's
    supposed to be because of the Math.random value never being able to be 
    rounded to the final value of for example 25 which is needed but would return 24
     */

    public int getMax() {
        if (getEmotion().equals("Sad")) {
            return 26;
        }
        if (getEmotion().equals("Angry")) {
            return 31;
        }
        if (getEmotion().equals("Happy")) {
            return 41;
        }
        return 41;

    }

    public int getBase() {
        if (getEmotion().equals("Sad")) {
            return 5;
        }
        if (getEmotion().equals("Angry")) {
            return 30;
        }
        if (getEmotion().equals("Happy")) {
            return 0;
        } else {
            return 10;
        }
    }
    
    /*
    These emotion getters will set the crit value of the player because that is the 
    unique feature of the player subclass instead of healing for the monster class.
    Not only do each of these methods change the crit value but also the defence
    and String emotion of the player
     */
    
    public void getSad() {
        setEmotion("Sad");
        setDefence(100);
        setCritValue(1.5);
    }

    public void getHappy() {
        setEmotion("Happy");
        setDefence(10);
        setCritValue(10.0);
    }

    public void getAngry() {
        setEmotion("Angry");
        setDefence(0);
        setCritValue(5.0);
    }

/*
normal setters and getters 
 */
    public void setCritValue(double hello) {
        this.critValue = hello;
    }

    public boolean getCrit() {
        return crit;
    }

    public double getCritValue(){
        return critValue;
    }

}

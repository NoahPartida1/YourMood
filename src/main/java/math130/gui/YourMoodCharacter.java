package math130.gui;

public class YourMoodCharacter {
    /*
    These 4 variables are the shared variables of this parent class YourMoodCharacter
    that will branch off in the monster and Player child classes
     */
    private int health;
    private int defence;
    private boolean alive;
    private String emotion;

    /*
    This is the basic constructor for the Character Class
     */
    public YourMoodCharacter(int health, boolean alive, String emotion, int defence) {
        this.health = health;
        this.alive = alive;
        this.emotion = emotion;
        this.defence = defence;
    }

    /*
    This is my main idea for the game in that the attacks are random depending
    on the value that is assigned, when I looked into the Math.random, it was
    going to return a decimal value from 0-1 , so in order for the value
    to be an int, I had to add (int) in front and add 1 so there will always
    be damage being dealt, this is great for the parent class, because I will
    be able to use polymorphism to adapt this attack method with the player class
     */
    public int attack(int max, int base) {
        return ((int) (Math.random() * max + base));
    }

    /*
    This method will only run if the damage variable is greater than the defence of the object
    that is using this method
     */
    public void takeDamage(int damage) {
        if (damage >= getDefence()) {
            setHealth(getHealth() - (damage - getDefence()));
        }
    }


    /*
       Normal getters and setters for the variables
     */
    public int getHealth() {
        return health;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int no) {
        defence = no;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String yes) {
        emotion = yes;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    /*
    checking  to see if the character is still alive
     */

    public void isDead() {
        if (health <= 0) {
            alive = false;
        }
    }





}

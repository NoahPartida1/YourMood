package math130.gui;

public class YourMoodCharacter {
    /*
    These are the variables that i will start with that  can add onto later
    this will set my parent class of Character to have a final set starting health
    along with keeping track of its current health and if the character is alive.
     */
    private int health;
    private final int startingHealth;
    public boolean alive;

    /*
    This is the basic constructor for the Character Class
     */
    public YourMoodCharacter(int health, int startingHealth, boolean alive) {
        this.health = health;
        this.startingHealth = startingHealth;
        this.alive = alive;
    }

    /*
    This is my main idea for the game in that the attacks are random depending
    on the value that is assigned, when i looked into the Math.random, it was
    going to return a value from 0-1 that is a decimal, so in order for the value
    to be a int, i had to add (int) in front and add 1 so there will always
    be damage being dealt, this si great for the parent class, because i will
    be able to use polymorphism to adapt this attack method
     */
    public int attack(int value) {
        int number = (int) Math.random() * value + 1;
        return number;
    }

    /*
    this allows me to change the value of the health that the character has
    while also checking if the character is still alive
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        isAlive();
    }

    /* Normal getters for the variables

     */
    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.startingHealth;
    }


    /*
    checking  to see if the character is still alive
     */
    public boolean isAlive() {
        return this.health > 0;
    }


}

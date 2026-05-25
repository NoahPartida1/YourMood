package math130.gui;

public class Player extends YourMoodCharacter {

    private double critValue;
    private boolean crit;

    public Player(int health, boolean alive, String emotion, int defence, double critValue, boolean crit) {
        super(health, alive, emotion, defence);
        this.crit = crit;
        this.critValue = critValue;
    }

    public Player() {
        this(10, false, "Happy", 10, 1.0, false);
    }

    public void setCritValue(double hello) {
        this.critValue = hello;
    }

    public boolean getCrit() {
        return crit;
    }


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

    public double getCritValue(){
        return critValue;
    }

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

}

package math130.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/*
create all the names for the objects used in java.fx
 */
public class YourMoodController {
    @FXML
    private Label gameOver;
    @FXML
    private Label monsterDamageTaken1;
    @FXML
    private Label playerDamageTaken;
    @FXML
    private Button attack;
    @FXML
    private Button becomeSad;
    @FXML
    private Button becomeAngry;
    @FXML
    private Button becomeHappy;
    @FXML
    private Label monsterDamageTaken;
    @FXML
    private Button StartButton;
    @FXML
    private ImageView monsterImage;
    @FXML
    private ImageView playerImage;
    @FXML
    private Circle neutralCircle;
    @FXML
    private Circle happyCircle;
    @FXML
    private Circle sadCircle;
    @FXML
    private Circle angryCircle;
    @FXML
    private Circle neutralCircle1;
    @FXML
    private Circle happyCircle1;
    @FXML
    private Circle sadCircle1;
    @FXML
    private Circle angryCircle1;

    @FXML
    private Label HP1;
    @FXML
    private Label HP2;

    /*
    initialize a basic monster and player object
     */
    private Monster monster = new Monster();
    private Player player = new Player();



    /*
    When the user clicks the start button, everything except that original button will
    appear on the screen using opacity, then the characters are initialized, And the
    health is set to the amount depending on the health initialized to.
     */
    @FXML
    protected void startGame() {

        monsterImage.setOpacity(1);
        playerImage.setOpacity(1);
        StartButton.setOpacity(0);
        neutralCircle.setOpacity(1);
        attack.setOpacity(1);
        becomeSad.setOpacity(1);
        becomeAngry.setOpacity(1);
        becomeHappy.setOpacity(1);
        neutralCircle1.setOpacity(1);

        // Initializing game characters
        monster = new Monster(1000, true, "", 10, 0);
        player = new Player(1000, true, "", 30, 2.0, false);

        HP1.setOpacity(1);
        HP1.setText("HP: " + monster.getHealth());
        HP2.setOpacity(1);
        HP2.setText("HP: " + player.getHealth());
    }

    /*
    Although these next 3 button clicks are very long lines of text there were
    many problems I ran into that im going to explain here instead of each individual
    clicked emotion button. The first problem I had to address was showing which
    colored circle is showing, so I adjusted each button clicked method to only show
    the correct colored circle by using opacity. The next problem I ran into was
    when it was finally the monsters turn to attack, I didn't properly think about
    this at first. The way the monster attacks is through randomness, however
    since the player doesn't always have to attack, the monster still needs
    to have its "turn". This is decided by first creating a number 1-20 based on
    randomness. The main problem I had was when the monster wanted to heal, I wanted
     to be able to show how much the monster heals, but the text kept lingering
     on through attacks, so for each other choice that doesn't have a value of 5-8 that
     makes the monster heal, then the text that displays the amount healed is set to
      an empty string. The values 1-3 have the monster itself changes its emotion
    to either happy, sad, angry. With this, the circles opacities have
     to be changed and the amount of damage that was done last turn to the player
     has to be set to an empty string since it's a personal monster move. The value of 4
     removes the emotion of the player and sets it back to the neutral emotion.
     The rest of the value from 9 to 20 will have the monster use its attack method
     but will first check if this randomized attack is less than the players' defence
     if this is true the string result is "BLOCKED", however if the damage is greater
     the string will display "DMG: - whatever the damage - the player's defence is"
     and will set the players health using the takeDamage method. Lastly
     since I have only been addressing the clickedSad, clickedHappy and clickedAngry
     methods, the only object that I have to check is alive is the player object
     since the player is changing its own emotion instead of attacking, so when the
     method getAlive() is called, the previous statemtn of player.isDead()
     will set the variabel alive to be either true or false if their health is less
     than 0. If the value is set to false, then the !isAlive() is true so every object's
     opacity is set to zero except for the game over text at the end.
     */
    @FXML
    protected void clickedSad() {
        player.getSad();
        neutralCircle.setOpacity(0);
        sadCircle.setOpacity(1);
        happyCircle.setOpacity(0);
        angryCircle.setOpacity(0);
        int monsterChoice = (int) (Math.random() * 20) + 1;
        monsterDamageTaken.setText("");

        if (monsterChoice == 1) {
            monster.setEmotion("Sad");
            sadCircle1.setOpacity(1);
            neutralCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(0);
            monsterDamageTaken1.setText("");
        }
        if (monsterChoice == 2) {
            monster.setEmotion("Happy");
            playerDamageTaken.setText("");
            sadCircle1.setOpacity(0);
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(1);
            monsterDamageTaken1.setText("");
        }
        if (monsterChoice == 3) {
            monster.setEmotion("Angry");
            sadCircle1.setOpacity(0);
            neutralCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            angryCircle1.setOpacity(1);
            happyCircle1.setOpacity(0);
            monsterDamageTaken1.setText("");
        }
        if (monsterChoice == 4) {
            player.setEmotion("");
            sadCircle.setOpacity(0);
            neutralCircle.setOpacity(1);
            playerDamageTaken.setText("");
            angryCircle.setOpacity(0);
            happyCircle.setOpacity(0);
            monsterDamageTaken1.setText("");
        }
        if (monsterChoice >= 5 && monsterChoice <= 8) {
            monster.heal();
            monsterDamageTaken1.setText("HP: +" + monster.getHeal());
            HP2.setText("HP: " + monster.getHealth());
            playerDamageTaken.setText("");

        }
        if (monsterChoice >= 9) {
            int monsterAttack = monster.attack(monster.getMax(), monster.getBase());
            monsterDamageTaken1.setText("");

            if ((monsterAttack - player.getDefence() <= 0)) {
                playerDamageTaken.setText("BLOCKED");
            } else {
                playerDamageTaken.setText("DMG: -" + (monsterAttack - player.getDefence()));
                player.takeDamage(monsterAttack);
            }
            HP1.setText("HP: " + player.getHealth());
        }
        player.isDead();
        if (!player.getAlive()) {
            gameOver.setText("       YOU LOST");
            monsterDamageTaken1.setText("");
            playerDamageTaken.setOpacity(0);
            gameOver.setOpacity(1);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            HP2.setOpacity(0);
            attack.setOpacity(0);
            monsterDamageTaken.setOpacity(0);
            becomeSad.setOpacity(0);
            becomeAngry.setOpacity(0);
            becomeHappy.setOpacity(0);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            HP1.setOpacity(0);
            happyCircle.setOpacity(0);
            sadCircle.setOpacity(0);
            angryCircle.setOpacity(0);
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(0);
            sadCircle1.setOpacity(0);
        }
    }


    @FXML
    protected void clickedAngry() {
        player.getAngry();
        neutralCircle.setOpacity(0);
        sadCircle.setOpacity(0);
        happyCircle.setOpacity(0);
        monsterDamageTaken.setText("");
        angryCircle.setOpacity(1);
        int monsterChoice = (int) (Math.random() * 20) + 1;

        if (monsterChoice == 1) {
            monster.setEmotion("Sad");
            sadCircle1.setOpacity(1);
            neutralCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(0);
            monsterDamageTaken1.setText("");
        }
        if (monsterChoice == 2) {
            monster.setEmotion("Happy");
            sadCircle1.setOpacity(0);
            neutralCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(1);
            monsterDamageTaken1.setText("");
        }
        if (monsterChoice == 3) {
            monster.setEmotion("Angry");
            sadCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(1);
            happyCircle1.setOpacity(0);
            monsterDamageTaken1.setText("");
        }
        if (monsterChoice == 4) {
            player.setEmotion("");
            monsterDamageTaken1.setText("");
            playerDamageTaken.setText("");
            sadCircle.setOpacity(0);
            neutralCircle.setOpacity(1);
            angryCircle.setOpacity(0);
            happyCircle.setOpacity(0);
        }
        if (monsterChoice >= 5 && monsterChoice <= 8) {
            monster.heal();
            monsterDamageTaken1.setText("HP: +" + monster.getHeal());
            HP2.setText("HP: " + monster.getHealth());
            playerDamageTaken.setText("");

        }
        if (monsterChoice >= 9) {
            int monsterAttack = monster.attack(monster.getMax(), monster.getBase());
            monsterDamageTaken1.setText("");

            if ((monsterAttack - player.getDefence() <= 0)) {
                playerDamageTaken.setText("BLOCKED");
            } else {
                playerDamageTaken.setText("DMG: -" + (monsterAttack - player.getDefence()));
                player.takeDamage(monsterAttack);
            }
            HP1.setText("HP: " + player.getHealth());
        }
        player.isDead();
        if (!player.getAlive()) {
            gameOver.setText("       YOU LOST");
            playerDamageTaken.setOpacity(0);
            monsterDamageTaken1.setText("");
            gameOver.setOpacity(1);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            HP2.setOpacity(0);
            attack.setOpacity(0);
            monsterDamageTaken.setOpacity(0);
            becomeSad.setOpacity(0);
            becomeAngry.setOpacity(0);
            becomeHappy.setOpacity(0);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            HP1.setOpacity(0);
            happyCircle.setOpacity(0);
            sadCircle.setOpacity(0);
            angryCircle.setOpacity(0);
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(0);
            sadCircle1.setOpacity(0);
        }
    }


    @FXML
    protected void clickedHappy() {
        player.getHappy();
        neutralCircle.setOpacity(0);
        sadCircle.setOpacity(0);
        happyCircle.setOpacity(1);
        monsterDamageTaken.setText("");
        angryCircle.setOpacity(0);
        int monsterChoice = (int) (Math.random() * 20) + 1;

        if (monsterChoice == 1) {
            monster.setEmotion("Sad");
            playerDamageTaken.setText("");
            sadCircle1.setOpacity(1);
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            monsterDamageTaken1.setText("");
            happyCircle1.setOpacity(0);
        }
        if (monsterChoice == 2) {
            monster.setEmotion("Happy");
            sadCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(1);
            monsterDamageTaken1.setText("");
        }
        if (monsterChoice == 3) {
            monster.setEmotion("Angry");
            sadCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            neutralCircle1.setOpacity(0);
            monsterDamageTaken1.setText("");
            angryCircle1.setOpacity(1);
            happyCircle1.setOpacity(0);
        }
        if (monsterChoice == 4) {
            player.setEmotion("");
            sadCircle.setOpacity(0);
            neutralCircle.setOpacity(1);
            angryCircle.setOpacity(0);
            monsterDamageTaken1.setText("");
            playerDamageTaken.setText("");
            happyCircle.setOpacity(0);
        }
        if (monsterChoice >= 5 && monsterChoice <= 8) {
            monster.heal();
            playerDamageTaken.setText("");
            monsterDamageTaken1.setText("HP: +" + monster.getHeal());
            HP2.setText("HP: " + monster.getHealth());

        }
        if (monsterChoice >= 9) {
            int monsterAttack = monster.attack(monster.getMax(), monster.getBase());
            monsterDamageTaken1.setText("");

            if ((monsterAttack - player.getDefence() <= 0)) {
                playerDamageTaken.setText("BLOCKED");
            } else {
                playerDamageTaken.setText("DMG: -" + (monsterAttack - player.getDefence()));
                player.takeDamage(monsterAttack);
            }
            HP1.setText("HP: " + player.getHealth());
        }
        player.isDead();
        if (!player.getAlive()) {
            gameOver.setText("       YOU LOST");
            playerDamageTaken.setOpacity(0);
            gameOver.setOpacity(1);
            monsterImage.setOpacity(0);
            monsterDamageTaken1.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            HP2.setOpacity(0);
            attack.setOpacity(0);
            monsterDamageTaken.setOpacity(0);
            becomeSad.setOpacity(0);
            becomeAngry.setOpacity(0);
            becomeHappy.setOpacity(0);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            HP1.setOpacity(0);
            happyCircle.setOpacity(0);
            sadCircle.setOpacity(0);
            angryCircle.setOpacity(0);
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(0);
            sadCircle1.setOpacity(0);
        }
    }

    /*
    I've already explained how the monster attack/turn works in the above 
    methods of the clicked emotions buttons, however I now need to explain the 
    player's attack when the attack button is clicked. Firstly the random attack 
    will be generated by using getter methods to determine the base and 
    max values of the attack based on the current player's emotion. This value will
    then be checked to see if it greater than the monster's defence, if it is less
    then the string result below the monster hp will say "BLOCKED", if the value
    is greater, then the unique feature of the player subclass will be checked
    and a 20% chance the getCrit() method will be true, in which the text will 
    say CRIT DMG instead of just DMG, if the getCrit isn't true. So that 
    is how the player attack works after that the monster.getAlive is checked 
    which ive explained before and then the monster has its turn which ive also 
    explained and then the player.isAlive() is checked again and for some reason
    i was habing problems where some of the emotion circles were popping up after
    the YOU LOST or YOU WON text pops up so i had the monster.isALive() checked
    one more time so all the objects have a set opacity to 0.
     */
    @FXML
    protected void clickedAttack() {

        int playerAttack = player.attack(player.getMax(), player.getBase(), player.getCritValue());
        monster.takeDamage(playerAttack);
        if ((playerAttack - monster.getDefence() <= 0)) {
            monsterDamageTaken.setText("BLOCKED");
        } else {
            if (player.getCrit()) {
                monsterDamageTaken.setText("CRIT DMG: -" + (playerAttack - monster.getDefence()));
            } else if (!player.getCrit()) {
                monsterDamageTaken.setText("DMG: -" + (playerAttack - monster.getDefence()));
            }
        }

        HP2.setText("HP: " + monster.getHealth());
        player.isDead();
        monster.isDead();
        if (!monster.getAlive()) {
            gameOver.setText("         YOU WON");
            gameOver.setOpacity(1);
            monsterDamageTaken1.setText("");
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            sadCircle.setOpacity(0);
            happyCircle.setOpacity(0);
            angryCircle.setOpacity(0);
            HP2.setOpacity(0);
            attack.setOpacity(0);
            monsterDamageTaken.setOpacity(0);
            becomeSad.setOpacity(0);
            becomeAngry.setOpacity(0);
            becomeHappy.setOpacity(0);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            HP1.setOpacity(0);
            playerDamageTaken.setOpacity(0);
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(0);
            sadCircle1.setOpacity(0);
        }

        int monsterChoice = (int) (Math.random() * 20) + 1;

        if (monsterChoice == 1) {
            monster.setEmotion("Sad");
            sadCircle1.setOpacity(1);
            monsterDamageTaken1.setText("");
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            happyCircle1.setOpacity(0);
        }
        if (monsterChoice == 2) {
            monster.setEmotion("Happy");
            sadCircle1.setOpacity(0);
            neutralCircle1.setOpacity(0);
            monsterDamageTaken1.setText("");
            angryCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            happyCircle1.setOpacity(1);
        }
        if (monsterChoice == 3) {
            monster.setEmotion("Angry");
            sadCircle1.setOpacity(0);
            monsterDamageTaken1.setText("");
            neutralCircle1.setOpacity(0);
            playerDamageTaken.setText("");
            angryCircle1.setOpacity(1);
            happyCircle1.setOpacity(0);
        }
        if (monsterChoice == 4) {
            player.setEmotion("");
            sadCircle.setOpacity(0);
            neutralCircle.setOpacity(1);
            angryCircle.setOpacity(0);
            monsterDamageTaken1.setText("");
            happyCircle.setOpacity(0);
            playerDamageTaken.setText("");
        }

        if (monsterChoice >= 5 && monsterChoice <= 8) {
            monster.heal();
            monsterDamageTaken1.setText("HP: +" + monster.getHeal());
            playerDamageTaken.setText("");
            HP2.setText("HP: " + monster.getHealth());

        }
        if (monsterChoice >= 9) {
            int monsterAttack = monster.attack(monster.getMax(), monster.getBase());
            monsterDamageTaken1.setText("");

            if ((monsterAttack - player.getDefence() <= 0)) {
                playerDamageTaken.setText("BLOCKED");
            } else {
                playerDamageTaken.setText("DMG: -" + (monsterAttack - player.getDefence()));
                player.takeDamage(monsterAttack);
            }
            HP1.setText("HP: " + player.getHealth());
        }


        monster.isDead();
        player.isDead();
        if (!player.getAlive()) {
            gameOver.setText("       YOU LOST");
            playerDamageTaken.setOpacity(0);
            gameOver.setOpacity(1);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            HP2.setOpacity(0);
            monsterDamageTaken1.setText("");
            attack.setOpacity(0);
            monsterDamageTaken.setOpacity(0);
            becomeSad.setOpacity(0);
            becomeAngry.setOpacity(0);
            becomeHappy.setOpacity(0);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            HP1.setOpacity(0);
            happyCircle.setOpacity(0);
            sadCircle.setOpacity(0);
            angryCircle.setOpacity(0);
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(0);
            sadCircle1.setOpacity(0);
        }
        if (!monster.getAlive()) {
            gameOver.setText("         YOU WON");
            gameOver.setOpacity(1);
            monsterDamageTaken1.setText("");
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            neutralCircle.setOpacity(0);
            sadCircle.setOpacity(0);
            happyCircle.setOpacity(0);
            angryCircle.setOpacity(0);
            HP2.setOpacity(0);
            attack.setOpacity(0);
            monsterDamageTaken.setOpacity(0);
            becomeSad.setOpacity(0);
            becomeAngry.setOpacity(0);
            becomeHappy.setOpacity(0);
            monsterImage.setOpacity(0);
            playerImage.setOpacity(0);
            HP1.setOpacity(0);
            playerDamageTaken.setOpacity(0);
            neutralCircle1.setOpacity(0);
            angryCircle1.setOpacity(0);
            happyCircle1.setOpacity(0);
            sadCircle1.setOpacity(0);
        }
    }
}

package math130.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class YourMoodController {
    @FXML
    private Label gameOver;
    @FXML
    private Label monsterDamageTaken1;
    @FXML
    private Label playerDamageDealt;
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
    private Label monsterDamageDealt;
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

    private Monster monster = new Monster();
    private Player player = new Player();


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

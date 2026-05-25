package math130.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class YourMoodController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
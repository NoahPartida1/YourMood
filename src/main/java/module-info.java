module math130.gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens math130.gui to javafx.fxml;
    exports math130.gui;
}
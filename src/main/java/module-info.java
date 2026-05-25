module math130.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens math130.gui to javafx.fxml;
    exports math130.gui;
}
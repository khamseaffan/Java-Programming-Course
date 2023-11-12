module JavaFXChallenge {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    exports contactApplication.dataModules;
    opens contactApplication;

}
module org.anr {

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;

    opens org.anr to javafx.fxml;
    exports org.anr;
}
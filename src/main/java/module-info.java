module org.sobs.sobs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;
    requires jlayer;


    opens org.sobs.sobs to javafx.fxml;
    exports org.sobs.sobs;
    exports org.sobs.sobs.controllers;
    opens org.sobs.sobs.controllers to javafx.fxml;
}
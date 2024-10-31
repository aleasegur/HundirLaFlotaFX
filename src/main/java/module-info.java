module com.example.hundirlaflotafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports com.example.hundirlaflotafx.app;
    opens com.example.hundirlaflotafx.app to javafx.fxml;
    exports com.example.hundirlaflotafx.controller;
    opens com.example.hundirlaflotafx.controller to javafx.fxml;
}
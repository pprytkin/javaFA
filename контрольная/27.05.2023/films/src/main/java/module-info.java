module com.prytkin.films {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.prytkin.films to javafx.fxml;
    exports com.prytkin.films;
}
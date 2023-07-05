module com.github.ericnaibert.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.github.ericnaibert.tictactoe to javafx.fxml;
    exports com.github.ericnaibert.tictactoe;
}
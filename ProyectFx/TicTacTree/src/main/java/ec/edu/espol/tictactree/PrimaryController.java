package ec.edu.espol.tictactree;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button primaryButton;
    @FXML
    private Button primaryButton1;
    @FXML
    private Button primaryButton11;
    @FXML
    private Button primaryButton12;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("board");
    }

    @FXML
    private void switchToCPUvsCPU(ActionEvent event) {
    }

    @FXML
    private void switchToHvsH(ActionEvent event) {
    }

    @FXML
    private void exitGame(ActionEvent event) {
    }
}

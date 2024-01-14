module ec.edu.espol.tictactree {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.tictactree to javafx.fxml;
    exports ec.edu.espol.tictactree;
}

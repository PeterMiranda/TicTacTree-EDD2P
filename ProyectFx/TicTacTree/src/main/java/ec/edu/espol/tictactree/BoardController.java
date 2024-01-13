package ec.edu.espol.tictactree;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class BoardController implements Initializable {

    @FXML
    private Text gameText1;
    @FXML
    private Text gameText2;
    @FXML
    private Text gameText3;
    @FXML
    private Text gameText4;
    @FXML
    private Text gameText5;
    @FXML
    private Text gameText6;
    @FXML
    private Text gameText7;
    @FXML
    private Text gameText8;
    @FXML
    private Text gameText9;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    int countMovement = 0;
    
   private String setSymbol(int countMovement){
        if (countMovement % 2 == 0) {
            return "O";
        } else {
            return "X";
        }
    }
   
    boolean allowedMovement1 = true;
    @FXML
    private void setPos1(MouseEvent event) {
        if(allowedMovement1){
            countMovement++;
            System.out.println("Pos1");
            gameText1.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement1 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }   
    }

    boolean allowedMovement2 = true;
    @FXML
    private void setPos2(MouseEvent event) {
        if(allowedMovement2){
            countMovement++;
            System.out.println("Pos2");
            gameText2.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement2 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }          
    }

    boolean allowedMovement3 = true;
    @FXML
    private void setPos3(MouseEvent event) {
        if(allowedMovement3){
            countMovement++;
            System.out.println("Pos3");
            gameText3.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement3 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }           
    }

    boolean allowedMovement4 = true;
    @FXML
    private void setPos4(MouseEvent event) {
        if(allowedMovement4){
            countMovement++;
            System.out.println("Pos4");
            gameText4.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement4 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }   
    }

    boolean allowedMovement5 = true;
    @FXML
    private void setPos5(MouseEvent event) {
        if(allowedMovement5){
            countMovement++;
            System.out.println("Pos5");
            gameText5.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement5 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }   
    }

    boolean allowedMovement6 = true;
    @FXML
    private void setPos6(MouseEvent event) {
        if(allowedMovement6){
            countMovement++;
            System.out.println("Pos6");
            gameText6.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement6 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }   
    }

    boolean allowedMovement7 = true;
    @FXML
    private void setPos7(MouseEvent event) {
        if(allowedMovement7){
            countMovement++;
            System.out.println("Pos7");
            gameText7.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement7 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }   
    }

    boolean allowedMovement8 = true;
    @FXML
    private void setPos8(MouseEvent event) {
        if(allowedMovement8){
            countMovement++;
            System.out.println("Pos8");
            gameText8.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement8 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }   
    }

    boolean allowedMovement9 = true;

    @FXML
    private void setPos9(MouseEvent event) {
        if(allowedMovement9){
            countMovement++;
            System.out.println("Pos9");
            gameText9.setText(setSymbol(countMovement));
            // LLAMADA FUNCION
            allowedMovement9 = false;
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }  
    }


}

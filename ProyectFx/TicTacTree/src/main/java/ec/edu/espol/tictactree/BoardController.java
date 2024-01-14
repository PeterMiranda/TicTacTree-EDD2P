package ec.edu.espol.tictactree;

import javafx.scene.Node;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class BoardController implements Initializable {

    @FXML
    private Label gameText1;
    @FXML
    private Label gameText2;
    @FXML
    private Label gameText3;
    @FXML
    private Label gameText4;
    @FXML
    private Label gameText5;
    @FXML
    private Label gameText6;
    @FXML
    private Label gameText7;
    @FXML
    private Label gameText8;
    @FXML
    private Label gameText9;
    @FXML
    private GridPane mainBoard;
    @FXML
    private GridPane DemoGridpane1;

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
            //System.out.println(GridPaneToArrayList());
            ArrayListToGridPane(GridPaneToArrayList(), DemoGridpane1);
        }  
    }

    public ArrayList<String> GridPaneToArrayList() {
        ArrayList<String> movementList = new ArrayList<>();

        for (int i = 0; i < mainBoard.getRowCount(); i++) {
            for (int j = 0; j < mainBoard.getColumnCount(); j++) {
                String movement = getStringFromGridPane(mainBoard, i,j);
                movementList.add(movement);
            }
        }
        return movementList;
    }
 
    public String getStringFromGridPane(GridPane gridPane, int row, int column) {
        for (Node node : gridPane.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);
            if (rowIndex == null) rowIndex = 0;
            if (colIndex == null) colIndex = 0;
            if (rowIndex == row && colIndex == column && node instanceof Label) {
                return ((Label) node).getText();
            }
        }
        return null;
    }
    
    /* LABEL
    public Label getLabelFromGridPane(GridPane gridPane, int row, int column) {
        for (Node node : gridPane.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);
            if (rowIndex == null) rowIndex = 0;
            if (colIndex == null) colIndex = 0;
            if (rowIndex == row && colIndex == column && node instanceof Label) {
                return (Label) node;
            }
        }
        return null;
    }
    */
    
    public void ArrayListToGridPane(ArrayList<String> list, GridPane gridPane) {
        ObservableList<Node> children = gridPane.getChildren();
        for (int i = children.size() - 1; i >= 0; i--) {
            if (children.get(i) instanceof Label) {
                gridPane.getChildren().remove(i);
            }
        }
        
        int rows = gridPane.getRowCount();
        int columns = gridPane.getColumnCount();
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index < list.size()) {
                    String text = list.get(index);
                    Label etiqueta = new Label(text);
                    etiqueta.setFont(new Font(22));
                    
                    HBox hbox = new HBox(etiqueta);
                    hbox.setAlignment(Pos.CENTER);
                
                    GridPane.setRowIndex(etiqueta, i);
                    GridPane.setColumnIndex(etiqueta, j);
                    gridPane.getChildren().add(etiqueta);
                    index++;
                } else {
                    break;
                }
            }
        }
    }
    
    
}

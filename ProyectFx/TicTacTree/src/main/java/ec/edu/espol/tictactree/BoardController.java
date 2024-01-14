package ec.edu.espol.tictactree;

import javafx.scene.Node;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
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
    private Label gameText0;
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
    private GridPane mainBoard;
    @FXML
    private GridPane DemotrationGridpane;
    @FXML
    private GridPane DemoGridpane1;
    @FXML
    private GridPane DemoGridpane2;
    @FXML
    private GridPane DemoGridpane3;
    @FXML
    private GridPane DemoGridpane4;
    @FXML
    private GridPane DemoGridpane5;
    @FXML
    private GridPane DemoGridpane6;
    @FXML
    private GridPane DemoGridpane7;
    @FXML
    private GridPane DemoGridpane8;
    @FXML
    private GridPane DemoGridpane9;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    int countMovement = 0;
       
    @FXML
    private void setPos(MouseEvent event) {
        Label l = (Label)event.getSource();
        
        if(l.getText().equals("")){
            l.setText("O");
            countMovement++;
            System.out.println("Pos0");
            System.out.println(GridPaneToArrayList());
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }   
    }

    /*
           System.out.println(GridPaneToArrayList());
            
            //DEMOS EN GRIDPANE IN GRIDPANE
            Node node = DemotrationGridpane.getChildren().get(8);
            if (node instanceof GridPane) {
                GridPane indexGridPane = (GridPane) node;
                ArrayListToGridPane(GridPaneToArrayList(), indexGridPane);
            } else {
                System.out.println("El nodo en la posición 0,0 no es un GridPane");
            }
    */
         
    public ArrayList<String> GridPaneToArrayList() {
        ArrayList<String> movementList =  new ArrayList();
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

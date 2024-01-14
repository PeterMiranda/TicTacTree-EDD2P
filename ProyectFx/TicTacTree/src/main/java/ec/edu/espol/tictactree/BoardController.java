package ec.edu.espol.tictactree;

import ec.edu.espol.tree.Tree;
import javafx.scene.Node;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
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
    
    Integer[][] lines = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
    Tree<Integer> t = new Tree(0);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("","","","","","","","",""));
    ArrayList<Integer> al = new ArrayList<>();
    String user = "";
    int lastIndex = -1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showAlert();
    }    

    int countMovement = 0;
       
    @FXML
    private void setPos(MouseEvent event) {
        Label l = (Label)event.getSource();
        int ind = ((GridPane) l.getParent()).getChildren().indexOf(l);
        if(l.getText().equals("")){
            user = (al.size()%2==0)?"X":"O";
            l.setText(user);
            humanMovement(ind);
            countMovement++;
            System.out.println("Pos0");
            System.out.println(GridPaneToArrayList());
        }else{
            System.out.println("MOVIMIENTO NO PERMITIDO");
        }
        user = (al.size()%2==0)?"X":"O";
        lastIndex = getMovementBot(t, moves, lines, user);
        moves.set(lastIndex, user);
        al.add(lastIndex);
        
    }

//           System.out.println(GridPaneToArrayList());
        public void setPossibleMovement(int ind, ArrayList<String> moves){
            //DEMOS EN GRIDPANE IN GRIDPANE
            Node node = DemotrationGridpane.getChildren().get(ind);
            System.out.println(node.toString());
            if (node instanceof GridPane) {
                GridPane indexGridPane = (GridPane) node;
                ArrayListToGridPane(moves, indexGridPane);
            } else {
                System.out.println("El nodo en la posición 0,0 no es un GridPane");
            }
        }
            
         
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
//        System.out.println(children.toString());
        for (int i = 0; i < children.size(); i++) {
            System.out.println(children.get(i).getProperties().toString());
                
        }
//        System.out.println(children.toString());
//            l.setText(list.get(i));

//        System.out.println(children.toString());
        
//        int rows = gridPane.getRowCount();
//        int columns = gridPane.getColumnCount();
//        int index = 0;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                if (index < list.size()) {
//                    String text = list.get(index);
//                    Label etiqueta = new Label(text);
//                    etiqueta.setFont(new Font(22));
//                    
//                    HBox hbox = new HBox(etiqueta);
//                    hbox.setAlignment(Pos.CENTER);
//                
//                    GridPane.setRowIndex(etiqueta, i);
//                    GridPane.setColumnIndex(etiqueta, j);
//                    gridPane.getChildren().add(etiqueta);
//                    index++;
//                } else {
//                    break;
//                }
//            }
//        }
    }
    
//    public void Game(){
//        Integer[][] lines = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
//        Tree<Integer> t = new Tree(0);
//        ArrayList<String> moves = new ArrayList<>(Arrays.asList("","","","","","","","",""));
//        ArrayList<Integer> al = new ArrayList<>();
//    }
    
//    public void humanVsComputer(boolean botFirst){
//        int movement;
//        if(botFirst){
//            movement = getMovementBot(t, moves, lines, 0, "X");
//        }
//        while(al.size()<9 && winner== null){
//            
//        }
//    }
    
    public void humanMovement(int ind){
        moves.set(ind, user);
        al.add(ind);
        t.addChild(ind+1);
        
    }
    
    public int getMovementBot(Tree<Integer> t,ArrayList<String> moves, Integer[][] lines, String user){
        possibleChilds(t, moves, user, lines);
        List<Tree> tChilds =  t.getChilds();
        int indMovement = -1;
        int maxUtility = -8;
        for(Tree tChild: tChilds){
            int utility =  tChild.getUtility();
            if (utility>maxUtility){
                maxUtility = utility;
                indMovement = (int)tChild.getContent();
            }
        }
        return indMovement;
    }
    
    public int getMinUtility(ArrayList<String> moves, Integer[][] lines, int indexAdded, String user){
        ArrayList<String> nextBoard = (ArrayList<String>) moves.clone();
        nextBoard.set(indexAdded, user);
        Integer minUtility = 8;
        String otherUser = user.equals("X")?"O":"X";
        for(int i = 0; i < 9; i++){
            if(nextBoard.get(i).isBlank()){
                nextBoard.set(i, otherUser);
                int utility = calculateUtility(nextBoard, lines, user, otherUser);
                minUtility = (utility<minUtility)?utility:minUtility;
                nextBoard.set(i, "");
            }
        }
        return minUtility;
    }
    
    public void newChild(ArrayList<String> moves, Tree<Integer> t, Integer[][] lines, int ind, String user, int indNextBoard){
        if(moves.get(ind).isBlank()){
            ArrayList<String> nextBoard = (ArrayList<String>)moves.clone();
            nextBoard.set(ind, user);
            int utility = getMinUtility(moves, lines, ind,user);
            t.addChild(ind+1, utility);
            setPossibleMovement(ind, nextBoard);
        }
    }
    
    public void possibleChilds(Tree<Integer> t,ArrayList<String> moves, String nextUser, Integer[][] lines){
        int indNextBoard = -1;
        for(int i = 0; i<3; i++){
            indNextBoard++;
            newChild(moves, t, lines, i, nextUser, indNextBoard);
        }
        indNextBoard++;
        newChild(moves, t, lines, 4, nextUser, indNextBoard);
        if(isPrincipalSymmetrical(moves)){
            if(isSecondarySymmetrical(moves)){
                return;
            } else {
                indNextBoard++;
                newChild(moves, t, lines, 5, nextUser, indNextBoard);
                indNextBoard++;
                newChild(moves, t, lines, 8, nextUser, indNextBoard);
                return;
            }
        } else if(isSecondarySymmetrical(moves)){
            indNextBoard++;
            newChild(moves, t, lines, 3, nextUser, indNextBoard);
            indNextBoard++;
            newChild(moves, t, lines, 6, nextUser, indNextBoard);
            return;
        }
        indNextBoard++;
        newChild(moves, t, lines, 3, nextUser, indNextBoard);
        for(int i = 5; i<9; i++){
            indNextBoard++;
            newChild(moves, t, lines, i, nextUser, indNextBoard);
        }
    }
    
    public static boolean isPrincipalSymmetrical(ArrayList<String> moves){
        boolean first = moves.get(1).equals(moves.get(3));
        boolean second = moves.get(2).equals(moves.get(6));
        boolean third = moves.get(5).equals(moves.get(7));
        return first && second && third;
    }
    public static boolean isSuperPrincipalSymmetrical(ArrayList<String> moves){
        boolean first = moves.get(1).equals(moves.get(5));
        boolean second = moves.get(0).equals(moves.get(8));
        return first && second;
    }
    
    public static boolean isSecondarySymmetrical(ArrayList<String> moves){
        boolean first = moves.get(1).equals(moves.get(5));
        boolean second = moves.get(0).equals(moves.get(8));
        boolean third = moves.get(3).equals(moves.get(7));
        return first && second && third;
    }
    public static boolean isSuperSecondarySymmetrical(ArrayList<String> moves){
        boolean first = moves.get(1).equals(moves.get(3));
        boolean second = moves.get(2).equals(moves.get(6));
        return first && second;
    }
    
    public int calculateP(ArrayList<String> moves, Integer[][] lines, String user){
        int result = 0;
        for (Integer[] line : lines) {
            int a = line[0];
            int b = line[1];
            int c = line[2];
            
            boolean aValid = moves.get(a).isBlank() || moves.get(a).equals(user);
            boolean bValid = moves.get(b).isBlank() || moves.get(b).equals(user);
            boolean cValid = moves.get(c).isBlank() || moves.get(c).equals(user);
          
            if (aValid && bValid && cValid) {
                result += 1;
            }
        }
        return result;
    }
    
    public int calculateUtility(ArrayList<String> moves, Integer[][] lines, String user, String otherUser) {
        int pU = calculateP(moves, lines, user);
        int pO = calculateP(moves, lines, otherUser);
        return pU - pO;
    }
    
    public static String calculateWinner(ArrayList<String> moves, Integer [][] lines) {
        for (Integer[] line : lines) {
            int a = line[0];
            int b = line[1];
            int c = line[2];
            
            if (!moves.get(a).isBlank() && moves.get(a).equals(moves.get(b)) && moves.get(a).equals(moves.get(c))) {
                return moves.get(a);
            }
        }
        return null;
    }

    public void showAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("¿Quién inicia la Partida?");
        alert.setContentText("¿Quién deseas que inicie la Partida?");

        ButtonType buttonTypeCPU = new ButtonType("CPU", ButtonData.YES);
        ButtonType buttonTypeHUMAN = new ButtonType("HUMAN", ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeCPU, buttonTypeHUMAN);

        alert.showAndWait();
        
        alert.getDialogPane().lookupButton(buttonTypeCPU).setId("botonCPU");
        alert.getDialogPane().lookupButton(buttonTypeHUMAN).setId("botonHuman");
    }
    
}

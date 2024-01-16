package ec.edu.espol.tictactree;

import ec.edu.espol.tree.Tree;
import javafx.scene.Node;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
    
    private Integer[][] lines = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
    private Tree<Integer> t = new Tree(0);
    private ArrayList<String> moves = new ArrayList<>(Arrays.asList("","","","","","","","",""));
    private ArrayList<Integer> al = new ArrayList<>();
    private String user = "";
    private int lastIndex = -1;
    private boolean botMove = true;
    private boolean humanMove = true;
    private boolean won = false;
    @FXML
    private Button movements;
    @FXML
    private Text textState;
    @FXML
    private Text userState;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alertGameMode();
        if(humanMove && botMove){
            alertBotOrHuman();
            if(botMove) botMovement();
            
            botMove=true;
        }
        Platform.runLater(() -> {
            if(!humanMove)
            setHumanDisable();
        });

    }    

    int countMovement = 0;
       
    @FXML
    private void setPos(MouseEvent event) {
        if(humanMove){
            Label l = (Label)event.getSource();
            humanMovement(l);
        }
        if(!won){
            if(botMove) botMovement();
            if(!won) return;
        }
        movements.setOnMouseClicked(null);
        userState.setText(user);
        setHumanDisable();
    }
    
    public void setDataMove(int ind){
        moves.set(ind, user);
        al.add(ind);
    }
    
    public void botMovement(){
        user = (al.size()%2==0)?"X":"O";
        System.out.println(moves);
        System.out.println(user);
        System.out.println(al);
        lastIndex = getMovementBot(t, moves, lines, user);
        System.out.println(lastIndex+ " aaaaaaaaaa");
        setDataMove(lastIndex);
        ((Label)mainBoard.getChildren().get(lastIndex)).setText(user);
        calculateWinner(moves, lines);
        if(won) return;
        userState.setText((al.size()%2==0)?"X":"O");
    }
    
    public void setDataTree(int ind){
        List<Tree> tChilds = t.getChilds();
        for(Tree tChild: tChilds){
            if(((int)tChild.getContent())==ind+1){
                t =  tChild;
                return;
            }
        }
        t.addChild(ind+1);
        List<Tree> lTree = t.getChilds();
        t = lTree.get(lTree.size()-1);
    }
    
    public void humanMovement(Label l){
        int ind = ((GridPane) l.getParent()).getChildren().indexOf(l);
        user = (al.size()%2==0)?"X":"O";
        l.setText(user);
        setDataMove(ind);
        setDataTree(ind);
        countMovement++;
        l.setOnMouseClicked(null);
        calculateWinner(moves, lines);
        if(won) return;
        userState.setText((al.size()%2==0)?"X":"O");
    }
    
    public void setHumanDisable(){
        for (Node n:mainBoard.getChildren()){
            if(n instanceof Label){
                Label l = (Label)n;
                l.setOnMouseClicked(null);
            }
        }
    }
    
     public void setPossibleMovement(int ind, ArrayList<String> moves, int utility){
        //DEMOS EN GRIDPANE IN GRIDPANE
        ObservableList<Node> oLN = ((VBox)DemotrationGridpane.getChildren().get(ind)).getChildren();
        GridPane nGP = (GridPane) oLN.get(1);
        Label l = (Label)oLN.get(0);
        l.setText(Integer.toString(utility));
        ArrayListToGridPane(moves, nGP);

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
        for (int i = 0; i < 9; i++) {
            ((Label)children.get(i)).setText(list.get(i)); 
        }
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
                indMovement = (int)tChild.getContent()-1;
                this.t = tChild;
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
    
    public boolean newChild(ArrayList<String> moves, Tree<Integer> t, Integer[][] lines, int ind, String user, int indNextBoard){
        if(moves.get(ind).isBlank()){
            ArrayList<String> nextBoard = (ArrayList<String>)moves.clone();
            nextBoard.set(ind, user);
            int utility = getMinUtility(moves, lines, ind,user);
            t.addChild(ind+1, utility);
            setPossibleMovement(indNextBoard, nextBoard, utility);
            return true;
        }
        return false;
    }
    
    public void clearPossibleChilds(){
        for(Node n: DemotrationGridpane.getChildren()){
            if(n instanceof VBox){
                ObservableList<Node> oLN = ((VBox)n).getChildren();
                GridPane gp = (GridPane)oLN.get(1);
                for(Node n2: gp.getChildren()){
                    if(n2 instanceof Label)
                        ((Label)n2).setText("");
                }
                ((Label)oLN.get(0)).setText("Utilidad");
            }
        }
    }
    
    public void possibleChilds(Tree<Integer> t,ArrayList<String> moves, String nextUser, Integer[][] lines){
        clearPossibleChilds();
        int indNextBoard = 0;
        boolean added;
        for(int i = 0; i<3; i++){
            added = newChild(moves, t, lines, i, nextUser, indNextBoard);
            indNextBoard += (added)?1:0;

        }
        added = newChild(moves, t, lines, 4, nextUser, indNextBoard);
        indNextBoard += (added)?1:0;
        if(isPrincipalSymmetrical(moves)){
            if(isSecondarySymmetrical(moves)){
                return;
            } else {
                added = newChild(moves, t, lines, 5, nextUser, indNextBoard);
                indNextBoard += (added)?1:0;
                newChild(moves, t, lines, 8, nextUser, indNextBoard);
                return;
            }
        } else if(isSecondarySymmetrical(moves)){
            added = newChild(moves, t, lines, 3, nextUser, indNextBoard);
            indNextBoard += (added)?1:0;
            newChild(moves, t, lines, 6, nextUser, indNextBoard);
            return;
        }
        added = newChild(moves, t, lines, 3, nextUser, indNextBoard);
        indNextBoard += (added)?1:0;
        for(int i = 5; i<9; i++){
            added = newChild(moves, t, lines, i, nextUser, indNextBoard);
            indNextBoard += (added)?1:0;
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
    
    public void calculateWinner(ArrayList<String> moves, Integer [][] lines) {
        for (Integer[] line : lines) {
            int a = line[0];
            int b = line[1];
            int c = line[2];
            
            if (!moves.get(a).isBlank() && moves.get(a).equals(moves.get(b)) && moves.get(a).equals(moves.get(c))) {
                won = true;
                textState.setText("Winner:");
                movements.setOnMouseClicked(null);
                return;
            }
        }
    }

    public void alertBotOrHuman() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("¿Quién inicia la Partida?");
        alert.setContentText("¿Quién deseas que inicie la Partida?");

        ButtonType buttonTypeCPU = new ButtonType("CPU", ButtonData.YES);
        ButtonType buttonTypeHUMAN = new ButtonType("HUMAN", ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeCPU, buttonTypeHUMAN);

        Optional<ButtonType> result = alert.showAndWait();
        
        botMove = result.isPresent() && result.get() == buttonTypeCPU;
    }
    
    public void alertGameMode() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Mode");

        ButtonType buttonTypeHvC = new ButtonType("HUMAN VS CPU", ButtonData.YES);
        ButtonType buttonTypeHvH = new ButtonType("HUMAN VS HUMAN", ButtonData.YES);
        ButtonType buttonTypeCvC = new ButtonType("CPU VS CPU", ButtonData.YES);
        ButtonType buttonTypeClose = new ButtonType("CLOSE", ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeHvC, buttonTypeHvH, buttonTypeCvC, buttonTypeClose);
        alert.setHeaderText("Select Game Mode");
        Optional<ButtonType> result = alert.showAndWait();
        
        botMove = result.isPresent() && (result.get() == buttonTypeHvC || result.get() == buttonTypeCvC);
        humanMove = result.isPresent() && (result.get() == buttonTypeHvC || result.get() == buttonTypeHvH);
        if(!humanMove){
            movements.setText("Next bot move");
        }
    }

    @FXML
    private void next(ActionEvent event) {
        if(humanMove){
            String nextUser = (al.size()%2==0)?"X":"O";
            possibleChilds(t, moves, nextUser, lines);
            return;
        }
        botMovement();
        if(al.size()==9) movements.setOnMouseClicked(null); 
    }
    
}

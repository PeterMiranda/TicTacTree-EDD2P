/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espol.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JorgeHN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    Integer[][] lines = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
    Tree<Integer> t = new Tree(0);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("","","","","","","","",""));
    ArrayList<Integer> al = new ArrayList<>();
    String winner = null;
    
    public static void main(String[] args) {
        Integer[][] lines = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
        Tree<Integer> t = new Tree(0);
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> al = new ArrayList<>();
        String winner = null;
        ArrayList<String> moves = new ArrayList<>(Arrays.asList("","","","","","","","",""));
        while (al.size()<9 && winner== null) {
            System.out.println("Ingrese su movimiento");
            String userInput = sc.nextLine();
            int number = Integer.parseInt(userInput);
            al.add(number);
            if(al.size()%2!=0){
                moves.set(number-1, "X");}
            else{
                moves.set(number-1, "O");}
            t.addChild(number);
            Tree<Integer> actual = t;
            List<Tree> childs = actual.getChilds();
            for(Tree c: childs) {
                if((int)c.getContent()==number){
                    actual = c;
                }
            }
            actual.recorrer((a) -> {
                Tree<Integer> tn = (Tree) a;
                for (int i = 0; i < 9; i++) {
                    if (!al.contains(i+1)) {
                        tn.addChild(i + 1);
                    }
                }
            });

//            actual.recorrer();
            System.out.println(al.toString());
            System.out.println(moves.toString());
            winner = calculateWinner(moves, lines);
            System.out.println("Ganó " + winner);
        }
    
        t.recorrer();
        
        
    }
    
    public void Game(){
        Integer[][] lines = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
        Tree<Integer> t = new Tree(0);
        ArrayList<String> moves = new ArrayList<>(Arrays.asList("","","","","","","","",""));
        ArrayList<Integer> al = new ArrayList<>();
    }
    
    public void humanVsComputer(boolean botFirst){
        int movement;
        if(botFirst){
            movement = getMovementBot(t, moves, lines, 0, "X");
        }
        while(al.size()<9 && winner== null){
            
        }
    }
    
    public int getMovementBot(Tree<Integer> t,ArrayList<String> moves, Integer[][] lines, int ind, String user){
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
            //Añadir funcion que setee el posible resultado en el gridPane
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
    
}

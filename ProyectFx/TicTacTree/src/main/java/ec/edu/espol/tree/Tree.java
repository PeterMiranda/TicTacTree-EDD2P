package ec.edu.espol.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author CltControl
 */
public class Tree<E> {
   
    public static void main(String[] args) {
        
        Tree<Integer> t = new Tree(0);
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> al = new ArrayList<>();
        String winner = null;
        ArrayList<String> moves = new ArrayList<>(Arrays.asList("v","v","v","v","v","v","v","v","v"));
        while (al.size()<9 && winner== null) {
            System.out.println("Ingrese su movimiento");
            String userInput = sc.nextLine();
            int number = Integer.parseInt(userInput);
            al.add(number);
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
            if(al.size()%2!=0){
                moves.set(number-1, "X");}
            else{
                moves.set(number-1, "O");}
//            actual.recorrer();
            System.out.println(al.toString());
            System.out.println(moves.toString());
            winner = Tree.calculateWinner(moves);
            System.out.println("Ganó" + winner);
        }
//        LinkedList<Integer> recorrido = t.recorrer();
//        t.recorrer((a)->{
//            Tree tn = (Tree)a;
//            for(int i=0; i<9; i++){
//                tn.addChild(i+1);
//            }
//        });
//        List<Tree> lt2 = (ArrayList<Tree>) t.getChilds();
//        for(Tree t2: lt2){
//            t2.recorrer((a)->{
//                Tree tn = (Tree)a;
//                int c = (int)tn.getContent();
//                for(int i=0; i<9; i++){
//                    if(i+1!=c)
//                        tn.addChild(i+1);
//                }
//            });
//        }
//        
        t.recorrer();

    }
    TreeNode<E> root;

    public Tree() {
        this.root = null;
    }

    public Tree(E content) {
        this.root = new TreeNode<>(content);
    }

    public E getContent() {
        return root.getContent();
    }

    public List<Tree> getChilds() {
        return root.getChilds();
    }

    public boolean isLeaf() {
        return root.getChilds().isEmpty();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void addChild(E e) {
        root.getChilds().add(new Tree(e));
    }

    public void recorrer(OperationOnVertex operation) {
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            Tree<E> tn = queue.poll();
            for (Tree t : tn.getChilds()) {
                queue.offer(t);
            }
            operation.op(tn);
        }
    }

    public void recorrer() {
        recorrer((o) -> System.out.println(((Tree) o).getContent()));
    }
    
    public static String calculateWinner(ArrayList<String> squares) {
        Integer[][] lines = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
        for (int i = 0; i < lines.length; i++) {
          Integer[] line = lines[i];
          int a = line[0];
          int b = line[1];
          int c = line[2];
          
          if (!squares.get(a).equals("v") && squares.get(a).equals(squares.get(b)) && squares.get(a).equals(squares.get(c))) {
            return squares.get(a);
          }
        }
        return null;
     }
}

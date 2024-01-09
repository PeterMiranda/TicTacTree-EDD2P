package TicTacTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author CltControl
 */
public class Tree<E> {
    public static void main(String[] args) {
        Tree<Integer> t = new Tree(1);
//        t.addChild(2);
//        t.addChild(3);
//        t.addChild(4);
//        t.addChild(5);
//        List<Tree> lT = (ArrayList<Tree>) t.getChilds();
//        Tree<Integer> t2 = lT.get(0);
//        t2.addChild(6);
//        t2.addChild(7);
//        Tree<Integer> t3 = lT.get(1);
//        t2.addChild(8);
//        t2.addChild(9);
//        Tree<Integer> t4 = lT.get(2);
//        t2.addChild(10);
//        t2.addChild(11);
//        Tree<Integer> t5 = lT.get(3);
//        t2.addChild(12);
//        t2.addChild(13);
//        LinkedList<Integer> recorrido = t.recorrer();
        t.recorrer((a)->{
            Tree tn = (Tree)a;
            for(int i=0; i<9; i++){
                tn.addChild(i+1);
            }
        });
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
    
    public boolean isLeaf(){
        return root.getChilds().isEmpty();
    }

    public boolean isEmpty() {
        return root == null;
    }
    
    public void addChild(E e) {
        root.getChilds().add(new Tree(e));
    }
    
    public void recorrer(OperationOnVertex operation){
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(this);
        while(!queue.isEmpty()){
            Tree<E> tn = queue.poll();
            for(Tree t: tn.getChilds()){
                queue.offer(t);
            }
            operation.op(tn); 
            
        }
    }

    public void recorrer(){
        recorrer((o)->System.out.println(((Tree)o).getContent()));
    }
}

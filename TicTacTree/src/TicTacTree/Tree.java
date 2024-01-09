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
        Tree<Integer> t = new Tree(0);

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

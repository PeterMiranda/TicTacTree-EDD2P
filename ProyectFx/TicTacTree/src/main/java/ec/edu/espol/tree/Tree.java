package ec.edu.espol.tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author CltControl
 */
public class Tree<E> {
   

    TreeNode<E> root;

    public Tree() {
        this.root = null;
    }

    public Tree(E content) {
        this.root = new TreeNode<>(content);
    }
    
    public Tree(E content, int utility) {
        this.root = new TreeNode<>(content, utility);
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
    
    public void addChild(E e, int utility) {
        root.getChilds().add(new Tree(e, utility));
    }

    public void recorrer(Operation operation) {
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
}

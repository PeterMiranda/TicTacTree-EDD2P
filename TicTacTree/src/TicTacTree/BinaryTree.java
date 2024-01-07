package TicTacTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree<E>{

    private BinaryTreeNode<E> root;         

    public BinaryTree() {
        this.root = null;
    }

    public E getContent() {
        return root.content;
    }

    public void setContent(E content) {
        this.root.content = content;
    }

    private BinaryTreeNode<E> getRoot() {
        return root;
    }

    private void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }
    
    public boolean isLeaf(){
        return this.root.getLeftChildren() == null && this.root.getRightChildren() == null;
    }
    
    
    public List<E> preOrderTraversal(){
        List<E> ListPreOrder = new LinkedList<>();
        if(this.isEmply())
            return ListPreOrder;
        ListPreOrder.add(this.root.getContent());
        
        
        if (this.isLeaf()){
           ListPreOrder.add(root.content);
        }
        this.root.getLeftChildren().preOrderTraversal();
        return ListPreOrder;
    }

    private boolean isEmply() {
        return this.root == null;
    }
    
}

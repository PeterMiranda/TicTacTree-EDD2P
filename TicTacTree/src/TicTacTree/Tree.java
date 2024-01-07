package TicTacTree;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Tree<E> {
    
    private TreeNode<E> root;         

    public Tree() {
        this.root = null;
    }
    
    public E getContent() {
        return root.content;
    }
    
    public void setContent(E content) {
        this.root.content = content;
    }
    
    private TreeNode<E> getRoot() {
        return root;
    }

    private void setRoot(TreeNode<E> root) {
        this.root = root;
    }
    
    public boolean isLeaf(){
        return this.root.getChildrenList().isEmpty();
    }
    
    
    /*
    public void x(){
        Queue<TreeNode<E>> cola = new ArrayDeque<>();
        cola.offer(root);
        TreeNode<E> nodeTmp;
        while(!cola.isEmpty()){
           nodeTmp = cola.poll();
           for(int i=0; i<nodeTmp.ChildrenList.size(); i++){
               cola.offer(nodoTmp.ChildrenList.get(i).root);
           }
        }
    */
}

package TicTacTree;

class BinaryTreeNode<E> {
    E content;
    BinaryTree<E> leftChildren;
    BinaryTree<E> rightChildren;

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public BinaryTreeNode(E content) {
        this.content = content;
        this.leftChildren = null;
        this.rightChildren = null;
    }

    public BinaryTree<E> getLeftChildren() {
        return leftChildren;
    }

    public void setLeftChildren(BinaryTree<E> leftChildren) {
        this.leftChildren = leftChildren;
    }

    public BinaryTree<E> getRightChildren() {
        return rightChildren;
    }

    public void setRightChildren(BinaryTree<E> rightChildren) {
        this.rightChildren = rightChildren;
    }
    
}

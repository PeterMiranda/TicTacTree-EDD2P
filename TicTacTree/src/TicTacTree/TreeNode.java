package TicTacTree;

import java.util.List;

public class TreeNode<E> {
    
    E content;
    List<Tree> ChildrenList;

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public TreeNode(E content) {
        this.content = content;
        this.ChildrenList = null;
    }

    public List<Tree> getChildrenList() {
        return ChildrenList;
    }

    public void setChildrenList(List<Tree> ChildrenList) {
        this.ChildrenList = ChildrenList;
    }
    
}

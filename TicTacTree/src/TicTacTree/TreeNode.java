package TicTacTree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CltControl
 */
class TreeNode<E> {
    private E content;
    private List<Tree> childs;
    
    public TreeNode(E content) {
        this.content = content;
        this.childs = new ArrayList();
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public List<Tree> getChilds() {
        return childs;
    }

    public void setChilds(List<Tree> childs) {
        this.childs = childs;
    }
    
    
}

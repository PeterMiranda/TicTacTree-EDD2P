package ec.edu.espol.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CltControl
 */
class TreeNode<E> {
    private E content;
    private List<Tree> childs;
    private int utility;
    
    public TreeNode(E content) {
        this.content = content;
        this.childs = new ArrayList();
    }
    
    public TreeNode(E content, int utility) {
        this.content = content;
        this.childs = new ArrayList();
        this.utility = utility;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public Integer getUtility() {
        return utility;
    }

    public void setUtility(Integer utility) {
        this.utility = utility;
    }

    public List<Tree> getChilds() {
        return childs;
    }

    public void setChilds(List<Tree> childs) {
        this.childs = childs;
    }
    
    
}

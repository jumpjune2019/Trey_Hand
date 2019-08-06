import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class ButtonUtil {
    public static void setTreeExpandedState(JTree tree, boolean expanded) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
        setNodeExpandedState(tree, node, expanded);
    }

    @SuppressWarnings("unchecked")
	public static void setNodeExpandedState(JTree tree, TreeNode node, boolean expanded) {
        ArrayList<TreeNode> list = (ArrayList<TreeNode>) Collections.list(node.children());
        
        for (TreeNode treeNode : list) {
            setNodeExpandedState(tree, treeNode, expanded);
        }
        if (!expanded && ((DefaultMutableTreeNode) node).isRoot()) {
            return;
        }
        TreePath path = new TreePath(((DefaultMutableTreeNode) node).getPath());
        if (expanded) {
            tree.expandPath(path);
            expanded = false;
        } else {
            tree.collapsePath(path);
            expanded = true;
        }
    }
}
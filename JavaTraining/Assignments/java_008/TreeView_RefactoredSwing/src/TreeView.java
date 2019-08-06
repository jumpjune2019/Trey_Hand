
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.Dimension;
import java.awt.GridLayout;

public class TreeView extends JPanel implements TreeSelectionListener {
    private JPanel selectionPane;
    private JTree tree;
    JLabel selectedNode;
    JLabel nodePath;
    

    //Optionally play with line styles.  Possible values are
    //"Angled" (the default), "Horizontal", and "None".
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    
    //Optionally set the look and feel.
    private static boolean useSystemLookAndFeel = false;

    public TreeView() {
        super(new GridLayout(1,0));

        //Create the nodes.
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Food");
        createNodes(root);

        //Create a tree that allows one selection at a time.
        tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Listen for when the selection changes.
        tree.addTreeSelectionListener(this);

        if (playWithLineStyle) {
            System.out.println("line style = " + lineStyle);
            tree.putClientProperty("JTree.lineStyle", lineStyle);
        }

        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);

        //Create the HTML viewing pane.
        selectionPane = new JPanel();
        selectionPane.setLayout(new BoxLayout(selectionPane, BoxLayout.Y_AXIS));
        selectedNode = new JLabel("Currently Selected: ");
        nodePath = new JLabel("Complete Path is: ");
        JToggleButton jbtn = new JToggleButton("Expand All", false);
        jbtn.addChangeListener(ae -> {
        	if (jbtn.isSelected() == true) {
        		//jbtn.setText("Collapse All");
        		jbtn.setText("Collapse All");
        		ButtonUtil.setTreeExpandedState(tree, jbtn.isSelected());
        	} else {
        		jbtn.setText("Expand All");
        		ButtonUtil.setTreeExpandedState(tree, jbtn.isSelected());
        	}
            
            
        });

        selectionPane.add(selectedNode);
        selectionPane.add(nodePath);
        selectionPane.add(jbtn);
        
        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(selectionPane);

        Dimension minimumSize = new Dimension(100, 50);
        selectionPane.setSize(minimumSize);
        treeView.setPreferredSize(new Dimension(700, 550));
        splitPane.setDividerLocation(-1); 
        splitPane.setPreferredSize(new Dimension(800, 650));

        //Add the split pane to this panel.
        add(splitPane);
    }

    /** Required by TreeSelectionListener interface. */
    public void valueChanged(TreeSelectionEvent e) {
    	DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    	if (node == null) return;
        selectedNode.setText("Currently Selected: " + node.getUserObject().toString());
    		
        TreePath path = getPath(node);
        // get the tree view selection model

        List<String> nodeList = new ArrayList<String>();
        while (node.getParent()!= null) {
        	String temp = node.getUserObject().toString();
        	nodeList.add(temp);
        	node = (DefaultMutableTreeNode) node.getParent();
        }
        StringBuilder sb = new StringBuilder();

        for (int i = nodeList.size() - 1; i >= 0; i--) {
        	if (i == 0) {
        		sb.append(nodeList.get(i));
        	} else {
        		sb.append(nodeList.get(i) + " -> ");
        	}
        }
        nodePath.setText("Complete Path is: Food -> " + sb);

        
    }
    public static TreePath getPath(TreeNode treeNode) {
        List<Object> nodes = new ArrayList<Object>();
        if (treeNode != null) {
          nodes.add(treeNode);
          treeNode = treeNode.getParent();
          while (treeNode != null) {
            nodes.add(0, treeNode);
            treeNode = treeNode.getParent();
          }
        }

        return nodes.isEmpty() ? null : new TreePath(nodes.toArray());
      }

    private void createNodes(DefaultMutableTreeNode root) {
		
		DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
        DefaultMutableTreeNode appleNode = new DefaultMutableTreeNode("Apples");
        fruitNode.add(appleNode);
        appleNode.add(new DefaultMutableTreeNode("Fuji"));
        appleNode.add(new DefaultMutableTreeNode("Winesap"));
        appleNode.add(new DefaultMutableTreeNode("Clark"));
        fruitNode.add(new DefaultMutableTreeNode("Pears"));
        fruitNode.add(new DefaultMutableTreeNode("Oranges"));
		
		DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
        vegetableNode.add(new DefaultMutableTreeNode("Corn"));
        vegetableNode.add(new DefaultMutableTreeNode("Peas"));
        vegetableNode.add(new DefaultMutableTreeNode("Broccoli"));
        vegetableNode.add(new DefaultMutableTreeNode("Beans"));
        
        DefaultMutableTreeNode nutNode = new DefaultMutableTreeNode("Nuts");
        nutNode.add(new DefaultMutableTreeNode("Walnuts"));
        nutNode.add(new DefaultMutableTreeNode("Almonds"));
        nutNode.add(new DefaultMutableTreeNode("Pistachios"));
        nutNode.add(new DefaultMutableTreeNode("Cashews"));
        
        //add child nodes to root
        root.add(fruitNode);
        root.add(vegetableNode);
        root.add(nutNode);
        
        //create tree by passing root node
        JTree tree = new JTree(root);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);
    }
        
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }

        //Create and set up the window.
        JFrame frame = new JFrame("TreeView Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new TreeView());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
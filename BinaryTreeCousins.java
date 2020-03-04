import java.util.HashMap;
import java.util.Map;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x;
	}
}

public class BinaryTreeCousins {

	
	static Map<Integer, Integer> depth = new HashMap<>();
    static Map<Integer, TreeNode> parents = new HashMap<>();
    
    public static boolean isCousins(TreeNode root, int x, int y) {
        
        dfs(root, null);
        return(depth.get(x) == depth.get(y) && parents.get(x) != parents.get(y));
    }
    
    private static void dfs(TreeNode node, TreeNode parent){
        if( node != null && parent!=null){
            depth.put(node.val, 1 + depth.get(parent.val));
            
            parents.put(node.val, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }             
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(isCousins(root,5,6));

	}
    


}

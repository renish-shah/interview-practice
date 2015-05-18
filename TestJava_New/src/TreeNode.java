public class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	int size;
	boolean valid;
	int order;

	public TreeNode(int data, int order) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.size = 0;
		this.valid = false;
		this.order = order;
	}

	public TreeNode(int data, int order, TreeNode parent) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = parent;
		this.order = order;
	}

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

}

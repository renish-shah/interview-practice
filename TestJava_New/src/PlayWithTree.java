/**
 * @author s0176953
 * 
 */
public class PlayWithTree {

    private static int globalCount = -1;
    private static boolean firstTime = true;

    public static TreeNode createBinaryTree() {

        TreeNode eleventhNode = new TreeNode(0, 11);
        TreeNode tenthNode = new TreeNode(0, 10);
        TreeNode ninthNode = new TreeNode(0, 9);
        TreeNode eighthNode = new TreeNode(0, 8);
        TreeNode sevenNode = new TreeNode(0, 7);
        TreeNode sixthNode = new TreeNode(0, 6);
        TreeNode fifthNode = new TreeNode(0, 5);
        TreeNode fourthNode = new TreeNode(0, 4);
        TreeNode thirdNode = new TreeNode(0, 3);
        TreeNode secondNode = new TreeNode(0, 2);
        TreeNode firstNode = new TreeNode(1, 1);

        eighthNode.left = tenthNode;
        eighthNode.right = eleventhNode;

        sevenNode.left = tenthNode;
        sevenNode.right = eleventhNode;

        fifthNode.left = eighthNode;
        fifthNode.right = ninthNode;

        fourthNode.left = sixthNode;
        fourthNode.right = sevenNode;

        thirdNode.left = fourthNode;
        thirdNode.right = fifthNode;

        // secondNode.left = new TreeNode(100);
        // secondNode.right = new TreeNode(50);

        firstNode.left = secondNode;
        firstNode.right = thirdNode;

        return firstNode;

    }
    

	/*
	 * 
	 *     				20
	 *     				/\
	 *     			  8   22
	 *				/  \   
	 *     		   4   12
	 *     				/\
	 *     			  10  14
	 *     
	 *     
	 */  
    
    public static TreeNode createTreeForInOrderSuccessor(){

    	TreeNode nodeFirst = new TreeNode(20, 1);
    	TreeNode nodeSecond = new TreeNode(8, 2, nodeFirst);

    	TreeNode nodeFifth = new TreeNode(12, 5, nodeSecond);
    	TreeNode nodeFourth = new TreeNode(4, 4, nodeSecond);
    	
    	TreeNode nodeSixth = new TreeNode(10, 6, nodeFifth);
    	TreeNode nodeSeventh = new TreeNode(14, 7, nodeFifth);

    	TreeNode nodeThird = new TreeNode(22, 3, nodeFirst);
    	
    	nodeFifth.left = nodeSixth;
    	nodeFifth.right = nodeSeventh;
    	
    	nodeSecond.left = nodeFourth;
    	nodeSecond.right = nodeFifth;
    	
    	nodeFirst.left = nodeSecond;
    	nodeFirst.right = nodeThird;
    	
    	return nodeFirst;
    	
    }

    public static void main(String[] args) {
        // TreeNode tree = createBinaryTree();
        // tree = returnHighestSizeOfAllZerosInSubTree(tree);
        // System.out.println("Global Count:"+tree.size+1);

        PlayWithTree playWithTree = new PlayWithTree();

//         int[] array = new int[]{5,8,13,17,20,21,24};
//         TreeNode node = playWithTree.createBinarySearchTree(array, 0,
//         array.length-1);

//        TreeNode node = playWithTree.createBinaryTree();

        // int height = playWithTree.calculateMaxHeight(node);
        // int height = playWithTree.calculateMinHeight(node);
        // System.out.println("Minimum Height of Tree :" + height);

//        boolean isBalanced = playWithTree.isBalanced(node);
//        System.out.println("isBalanced: " + isBalanced);

//         TreeNode lowestCommonAncestorNode = playWithTree.findLowestCommmonAncestor(node, new TreeNode(40), new TreeNode(21));
//         System.out.println("lowestCommonAncestorNode Value:"+lowestCommonAncestorNode.data);
         
         TreeNode tree = playWithTree.createTreeForInOrderSuccessor();
//         TreeNode node = new TreeNode(8, 2);
         tree = playWithTree.findInOrderSuccessor(tree, tree.right);
         System.out.println("Ancesstor is:"+tree.data);
         
         
    }

    public static TreeNode returnHighestSizeOfAllZerosInSubTree(TreeNode node) {

        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null && node.data == 0) {
            node.size++;
            node.valid = true;
            return node;
        } else if (node.left == null && node.right == null) {
            return node;
        }

        TreeNode leftNode = returnHighestSizeOfAllZerosInSubTree(node.left);
        TreeNode rightNode = returnHighestSizeOfAllZerosInSubTree(node.right);

        if (leftNode.valid && rightNode.valid && node.data == 0) {

            if (firstTime) {
                node.valid = true;
                node.size = 3;
                firstTime = false;
            } else {
                node.valid = true;
                node.size = Math.max(leftNode.size, rightNode.size);
            }
        } else {
            node.size = Math.max(leftNode.size, rightNode.size);
        }

        return node;
    }

    // 0,1, 2, 3, 4, 5, 6
    // create a minimal height tree from a sorted array 5,8,13,17,20,21,24
    public TreeNode createBinarySearchTree(int[] array, int leftIndex,
            int rightIndex) {

        if (rightIndex < leftIndex)
            return null;

        int currentIndexValue = (leftIndex + rightIndex) / 2;

        TreeNode tree = new TreeNode(array[currentIndexValue]);
        tree.left = createBinarySearchTree(array, leftIndex,
                currentIndexValue - 1);
        tree.right = createBinarySearchTree(array, currentIndexValue + 1,
                rightIndex);

        return tree;
    }

    public int calculateMaxHeight(TreeNode node) {

        if (node == null)
            return -1;

        int lh = calculateMaxHeight(node.left);
        int rh = calculateMaxHeight(node.right);

        int height = 1 + Math.max(lh, rh);
        return height;
    }

    public int calculateMinHeight(TreeNode node) {

        if (node == null)
            return -1;

        int lh = calculateMaxHeight(node.left);
        int rh = calculateMaxHeight(node.right);

        int height = 1 + Math.min(lh, rh);
        return height;
    }

    public boolean isBalanced(TreeNode node) {

        int maxH = calculateMaxHeight(node);
        int minH = calculateMinHeight(node);

        if (maxH - minH < 2)
            return true;

        return false;
    }

    public TreeNode findLowestCommmonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

    	//If the data is found in root node, return root node
        if(root.data == node1.data || root.data == node2.data){
            return root;
        }
        
        // Check left subtree for node1 and node2
        TreeNode leftTree = traversePreOrder(root.left, node1);
        TreeNode rightTree = traversePreOrder(root.left, node2);
        
        if(leftTree != null && rightTree!=null){
            findLowestCommmonAncestor(root.left, node1, node2);
        }
            
        leftTree = traversePreOrder(root.right, node1);
        rightTree = traversePreOrder(root.right, node2);
        
        if(leftTree != null && rightTree!=null){
            findLowestCommmonAncestor(root.right, node1, node2);
        }
        
        return root;
    }
    
    public TreeNode traversePreOrder(TreeNode root, TreeNode node) {

        if(root == null)
            return null;
        
        if (root.data == node.data) {
            return root;
        }

        traversePreOrder(root.left, node);
        traversePreOrder(root.right, node);

        return null;
    }

    public TreeNode findInOrderSuccessor(TreeNode root, TreeNode node) {
    	
    	if (node.right != null) {
    		return findMinimumValue(node.right);
    	}
    	
    	TreeNode parentNode = node.parent;
    	while (parentNode != null && node == parentNode.right) {
    		node = parentNode;
    		parentNode = parentNode.parent;
    	}
    	
		return parentNode;
    }

	private TreeNode findMinimumValue(TreeNode node) {
		if(node.left != null) {
			node = node.left;
			findMinimumValue(node);
		}
		return node;
	}
    
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void buildBinaryTree(int[] arr) {
        root = buildTreeFromArray(arr, 0, arr.length - 1);
    }

    private TreeNode buildTreeFromArray(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = buildTreeFromArray(arr, start, mid - 1);
        node.right = buildTreeFromArray(arr, mid + 1, end);

        return node;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void removeNodesAtLevel(int level) {
        int targetLevel = level / 3;
        root = removeNodesAtLevel(root, 1, targetLevel);
    }

    private TreeNode removeNodesAtLevel(TreeNode node, int currentLevel, int targetLevel) {
        if (node == null) {
            return null;
        }

        if (currentLevel % targetLevel == 0) {
            node.left = null;
        } else {
            node.left = removeNodesAtLevel(node.left, currentLevel + 1, targetLevel);
            node.right = removeNodesAtLevel(node.right, currentLevel + 1, targetLevel);
        }

        return node;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildBinaryTree(arr);

        System.out.println("Binary Tree before removing nodes:");
        binaryTree.printInOrder();
        System.out.println();

        int height = binaryTree.getHeight();
        System.out.println("Height of the Binary Tree: " + height);
        binaryTree.removeNodesAtLevel(height);

        System.out.println("Binary Tree after removing nodes at level h/3:");
        binaryTree.printInOrder();
    }
}

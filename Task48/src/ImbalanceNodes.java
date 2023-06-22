public class ImbalanceNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void findImbalanceNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        if (Math.abs(leftCount - rightCount) >= 3) {
            System.out.println("Найдена вершина: " + root.val);
        }

        findImbalanceNodes(root.left);
        findImbalanceNodes(root.right);
    }

    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        System.out.println("Вершины, у которых количество потомков в левом и правом поддереве отличается на 3 и более: ");
        findImbalanceNodes(root);
    }
}

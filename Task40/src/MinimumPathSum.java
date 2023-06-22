
public class MinimumPathSum {
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
    private static int minSum = Integer.MAX_VALUE;

    public static int findMinimumPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        findMinPath(root, 0);

        return minSum;
    }

    private static void findMinPath(TreeNode node, int currentSum) {
        if (node == null) {
            return;
        }

        currentSum += node.val;

        if (node.left == null && node.right == null) { // Если достигнут листовой узел
            minSum = Math.min(minSum, currentSum); // Обновляем минимальную сумму пути
        } else {
            findMinPath(node.left, currentSum); // Рекурсивный вызов для левого поддерева
            findMinPath(node.right, currentSum); // Рекурсивный вызов для правого поддерева
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int minimumSum = findMinimumPathSum(root);
        System.out.println("Минимальная сумма пути от корня до листа: " + minimumSum);
    }
}

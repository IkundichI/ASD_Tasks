

public class BinaryTreeAverage {
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
    private static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }

    private static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static double average(TreeNode root) {
        int sum = sum(root);
        int count = countNodes(root);

        if (count == 0) {
            return 0;
        }

        return (double) sum / count;
    }

    public static void main(String[] args) {
        // Создание двоичного дерева
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        double average = average(root);
        System.out.println("Среднее арифметическое значение чисел в вершинах дерева: " + average);
    }
}

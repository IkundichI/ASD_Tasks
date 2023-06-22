public class InternalNodeSearch {

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

    public static int countInternalNodes(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0; // Базовый случай: пустое дерево или листовая вершина
        }

        // Рекурсивно обходим левое и правое поддеревья и суммируем количество внутренних вершин
        int count = 1; // Учитываем текущую вершину

        count += countInternalNodes(root.left); // Левое поддерево
        count += countInternalNodes(root.right); // Правое поддерево

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int count = countInternalNodes(root);
        System.out.println("Количество внутренних вершин в дереве: " + count);
    }
}

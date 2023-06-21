import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(this, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(node.value);

        if (node.left != null || node.right != null) {
            sb.append(" (");
            buildString(node.left, sb);
            sb.append(", ");
            buildString(node.right, sb);
            sb.append(")");
        }
    }
}

public class BalancedSubtrees {
    private static List<Integer> findImbalancedNodes(TreeNode root) {
        List<Integer> imbalancedNodes = new ArrayList<>();
        countNodes(root, imbalancedNodes);
        return imbalancedNodes;
    }

    private static int countNodes(TreeNode node, List<Integer> imbalancedNodes) {
        if (node == null)
            return 0;

        int leftCount = countNodes(node.left, imbalancedNodes);
        int rightCount = countNodes(node.right, imbalancedNodes);
        int totalCount = leftCount + rightCount + 1;

        if (leftCount != rightCount)
            imbalancedNodes.add(node.value);

        return totalCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        System.out.println(root);

        List<Integer> imbalancedNodes = findImbalancedNodes(root);
        if (imbalancedNodes.isEmpty()) {
            System.out.println("Нет вершин с неравным количеством потомков.");
        } else {
            System.out.println("Номера вершин с неравным количеством потомков:");
            for (int node : imbalancedNodes) {
                System.out.print(node + " ");
            }
        }
    }
}

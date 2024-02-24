import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinarySearchTreeValidator {

    // Verificação em profundidade (DFS) para verificar se a árvore é uma árvore de busca válida
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    // Verificação em largura (BFS) para verificar se a árvore é uma árvore de busca válida
    public boolean isValidBST_BFS(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> minValues = new LinkedList<>();
        Queue<Integer> maxValues = new LinkedList<>();

        queue.offer(root);
        minValues.offer(null);
        maxValues.offer(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer min = minValues.poll();
            Integer max = maxValues.poll();

            if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;

            if (node.left != null) {
                queue.offer(node.left);
                minValues.offer(min);
                maxValues.offer(node.val);
            }

            if (node.right != null) {
                queue.offer(node.right);
                minValues.offer(node.val);
                maxValues.offer(max);
            }
        }

        return true;
    }

    // Construção de árvore de busca binária com validação durante a inserção
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    // Função para verificar se uma árvore é uma árvore binária de busca
    public static boolean isBinarySearchTree(TreeNode root) {
        return new BinarySearchTreeValidator().isValidBST(root);
    }

    public static void main(String[] args) {
        // Exemplo de uso
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);



        // Verificar se a árvore é uma árvore de busca válida
        System.out.println("É uma árvore de busca válida? " + isBinarySearchTree(root));

        // Adicionando um nó que quebra a propriedade de árvore de busca
        root.right.right.left = new TreeNode(6);

        // Verificar novamente
        System.out.println("É uma árvore de busca válida agora? " + isBinarySearchTree(root));

    }
}
class TreeNode2 {
    int val;
    int height;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(int val) {
        this.val = val;
        this.height = 1;
    }
}

public class AVLTree {
    TreeNode2 root;

    // Retorna a altura de um nó
    int height(TreeNode2 node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Função de rotação à direita
    TreeNode2 rightRotate(TreeNode2 y) {
        TreeNode2 x = y.left;
        TreeNode2 T2 = x.right;

        // Realiza a rotação
        x.right = y;
        y.left = T2;

        // Atualiza alturas
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Retorna o novo nó raiz
        return x;
    }

    // Função de rotação à esquerda
    TreeNode2 leftRotate(TreeNode2 x) {
        TreeNode2 y = x.right;
        TreeNode2 T2 = y.left;

        // Realiza a rotação
        y.left = x;
        x.right = T2;

        // Atualiza alturas
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Retorna o novo nó raiz
        return y;
    }

    // Retorna o fator de balanceamento de um nó
    int getBalance(TreeNode2 node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Função para inserir um nó na árvore AVL
    TreeNode2 insert(TreeNode2 node, int val) {
        // Inserção normal de um nó BST
        if (node == null)
            return (new TreeNode2(val));

        if (val < node.val)
            node.left = insert(node.left, val);
        else if (val > node.val)
            node.right = insert(node.right, val);
        else // Duplicatas não são permitidas na AVL
            return node;

        // Atualiza a altura deste nó ancestral
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Verifica se este nó se tornou desbalanceado
        int balance = getBalance(node);

        // Se este nó se tornou desbalanceado, então há 4 casos

        // Caso Esquerda-Esquerda
        if (balance > 1 && val < node.left.val)
            return rightRotate(node);

        // Caso Direita-Direita
        if (balance < -1 && val > node.right.val)
            return leftRotate(node);

        // Caso Esquerda-Direita
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Caso Direita-Esquerda
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Retorna o nó (sem alteração)
        return node;
    }

    // Função de utilidade para percorrer a árvore AVL
    void inorder(TreeNode2 node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.val + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Exemplo de inserção de elementos */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* Saída da árvore AVL */
        System.out.println("Árvore AVL:");
        tree.inorder(tree.root);
        System.out.println("\n" +tree.root.val);
    }
}

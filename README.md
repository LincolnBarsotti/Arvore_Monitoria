<p>Este repositório contém duas implementações de árvores binárias em Java: uma Árvore de Busca Binária (BST) e uma Árvore AVL (Árvore Binária de Busca Balanceada).</p>

  <h2>Implementação da Árvore de Busca Binária (BST)</h2>

  <p>A classe <code>BinarySearchTreeValidator</code> implementa uma árvore de busca binária (BST) e fornece métodos para validar se a árvore é uma BST válida.</p>

  <h3>Métodos Principais:</h3>
    <ul>
        <li><code>isValidBST(TreeNode root)</code>: Utiliza uma abordagem de verificação em profundidade (DFS) para verificar se a árvore é uma BST válida.</li>
        <li><code>isValidBST_BFS(TreeNode root)</code>: Utiliza uma abordagem de verificação em largura (BFS) para verificar se a árvore é uma BST válida.</li>
        <li><code>insertIntoBST(TreeNode root, int val)</code>: Insere um novo nó na BST.</li>
    </ul>

  <h3>Exemplo de Uso:</h3>
    <pre><code>// Criando uma árvore de busca binária
TreeNode root = new TreeNode(5);
root.left = new TreeNode(3);
root.right = new TreeNode(8);
// Mais operações...

// Verificando se é uma árvore de busca válida
System.out.println("É uma árvore de busca válida? " + isBinarySearchTree(root));

// Adicionando um nó que quebra a propriedade de árvore de busca
// Verificando novamente...
    </code></pre>

  <h2>Implementação da Árvore AVL</h2>

  <p>A classe <code>AVLTree</code> implementa uma Árvore AVL (Árvore Binária de Busca Balanceada), que é uma extensão da BST. Essa implementação mantém a árvore balanceada durante as operações de inserção.</p>

  <h3>Métodos Principais:</h3>
    <ul>
        <li><code>insert(TreeNode2 node, int val)</code>: Insere um novo nó na árvore AVL mantendo seu balanceamento.</li>
        <li><code>inorder(TreeNode2 node)</code>: Realiza um percurso em ordem na árvore.</li>
    </ul>

  <h3>Exemplo de Uso:</h3>
    <pre><code>// Criando uma árvore AVL
AVLTree tree = new AVLTree();

// Inserindo elementos na árvore
tree.root = tree.insert(tree.root, 10);
tree.root = tree.insert(tree.root, 20);
tree.root = tree.insert(tree.root, 30);
// Mais operações...

// Saída da árvore AVL
System.out.println("Árvore AVL:");
tree.inorder(tree.root);
System.out.println("\n" + tree.root.val);
    </code></pre>

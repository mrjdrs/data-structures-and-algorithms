package tree;

/**
 * 二叉树
 *
 * @author zhoude
 * @date 2021/3/15 15:03
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        //    4
        //  2   6
        // 1 3 5 7
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(4);
        binaryTree.insert(2);
        binaryTree.insert(6);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(5);
        binaryTree.insert(7);

        BinaryTree.Node node = binaryTree.find(4);
        System.out.println("----- 二叉树前序遍历 -----");
        binaryTree.preOrder(node);
        System.out.println("\r\n----- 二叉树中序遍历 -----");
        binaryTree.inOrder(node);
        System.out.println("\r\n----- 二叉树后序遍历 -----");
        binaryTree.postOrder(node);

        binaryTree.delete(4);
    }

}
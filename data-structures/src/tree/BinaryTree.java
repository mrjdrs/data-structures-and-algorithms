package tree;

/**
 * 二叉树
 *
 * @author zhoude
 * @date 2021/3/15 15:03
 */
public class BinaryTree {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 1、先取根节点，如果满足则返回根节点。
     * 2、如果小于根节点则在左子树递归查找，大于则在右子树递归查找。
     *
     * @param value 查询的值
     */
    public Node find(int value) {
        Node node = root;
        while (node != null) {
            if (value > node.value) {
                node = node.right;
            }
            else if (value < node.value) {
                node = node.left;
            }
            else {
                // value == node.value
                return node;
            }
        }
        return null;
    }

    /**
     * 1、若根节点无数据则将数据放入根节点。
     * 2、插入数据比节点大且右子树为空，则直接插入到右子节点；如果不为空，则递归遍历右子树。
     * 3、同理，插入数据比节点小且左子树为空，则直接插入到左子节点；如果不为空，则递归遍历左子树。
     *
     * @param value 插入的值
     */
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node node = root;
        while (node != null) {
            if (value > node.value) {
                if (node.right == null) {
                    node.right = new Node(value);
                    return;
                }
                node = node.right;
            }
            else {
                // value <= node.value
                if (node.left == null) {
                    node.left = new Node(value);
                    return;
                }
                node = node.left;
            }
        }
    }

    /**
     * 1、删除的是叶子节点，只需要将父节点中指向要删除节点的指针置为null。
     * 2、删除的节点只有一个子节点（左子节点或右子节点），我们只需要将其父节点的指向改为其子节点即可（需要根据大小判断放在左还是右）。
     * 3、删除的节点有两个子节点，找到该节点右子树中最小的节点，把它替换到删除的节点上。然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了）。
     *
     * @param value 删除的值
     */
    public void delete(int value) {
        // p指向要删除的节点，初始化指向根节点
        Node p = root;
        // pp记录的是p的父节点
        Node pp = null;
        // 找到要删除的节点
        while (p != null && p.value != value) {
            pp = p;
            if (value > p.value) {
                p = p.right;
            }
            else {
                p = p.left;
            }
        }
        if (p == null) {
            // 没有找到要删除的节点
            return;
        }

        // 要删除的节点有两个子节点，找到右子树的最小节点
        if (p.left != null && p.right != null) {
            Node minp = p.right;
            Node minpp = p;
            while (minp.left != null) {
                minpp = minp;
                minp = minp.left;
            }
            // 将minp的数据替换到p中
            p.value = minp.value;
            p = minp;
            pp = minpp;
        }

        // 删除节点是叶子节点或仅有一个子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        }
        else if (p.right != null) {
            child = p.right;
        }
        else {
            child = null;
        }

        if (pp == null) {
            // 删除的是根节点
            root = child;
        }
        else if (pp.left == p) {
            pp.left = child;
        }
        else {
            pp.right = child;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.value + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.print(treeNode.value + " ");
        inOrder(treeNode.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.value + " ");
    }

    /**
     * 树节点
     */
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
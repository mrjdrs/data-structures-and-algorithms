package tree;

/**
 * 二叉树
 *
 * @author zhoude
 * @date 2021/3/15 15:03
 */
public class BinaryTreeTest {

    /**
     * 第一，散列表中的数据是无序存储的，如果要输出有序的数据，需要先进行排序。而对于二叉查找树来说，我们只需要中序遍历，就可以在 O(n) 的时间复杂度内，输出有序的数据序列。第二，散列表扩容耗时很多，而且当遇到散列冲突时，性能不稳定，尽管二叉查找树的性能不稳定，但是在工程中，我们最常用的平衡二叉查找树的性能非常稳定，时间复杂度稳定在 O(logn)。第三，笼统地来说，尽管散列表的查找等操作的时间复杂度是常量级的，但因为哈希冲突的存在，这个常量不一定比 logn 小，所以实际的查找速度可能不一定比 O(logn) 快。加上哈希函数的耗时，也不一定就比平衡二叉查找树的效率高。第四，散列表的构造比二叉查找树要复杂，需要考虑的东西很多。比如散列函数的设计、冲突解决办法、扩容、缩容等。平衡二叉查找树只需要考虑平衡性这一个问题，而且这个问题的解决方案比较成熟、固定。最后，为了避免过多的散列冲突，散列表装载因子不能太大，特别是基于开放寻址法解决冲突的散列表，不然会浪费一定的存储空间。综合这几点，平衡二叉查找树在某些方面还是优于散列表的，所以，这两者的存在并不冲突。我们在实际的开发过程中，需要结合具体的需求来选择使用哪一个。
     * @param args
     */
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
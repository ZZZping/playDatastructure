public class Solution {
    /**
     * 根据前序遍历和中序遍历创建二分搜索树
     * 先序遍历的第一个元素是树的根结点，
     * 在中序遍历中找出先序遍历收个元素的位置，
     * 在根结点左侧为树的左子树，在书的右侧为树的右子树
     *
     * @param preorder 前序遍历结果
     * @param inorder 中序遍历结果
     * @return 返回二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * 递归函数
     * @param preStart 先序遍历首个元素
     * @param inStart 中序遍历首个元素
     * @param inEnd  中序遍历最后一个元素
     * @param preorder 先序遍历数组
     * @param inorder 后序遍历数组
     * @return 返回构造的二分搜索树
     */
    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        //记录在中序遍历中根结点的位置
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i ++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = buildTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}

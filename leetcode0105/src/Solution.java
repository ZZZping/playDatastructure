public class Solution {
    /**
     * ����ǰ����������������������������
     * ��������ĵ�һ��Ԫ�������ĸ���㣬
     * ������������ҳ���������ո�Ԫ�ص�λ�ã�
     * �ڸ�������Ϊ������������������Ҳ�Ϊ����������
     *
     * @param preorder ǰ��������
     * @param inorder ����������
     * @return ���ض�����
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * �ݹ麯��
     * @param preStart ��������׸�Ԫ��
     * @param inStart ��������׸�Ԫ��
     * @param inEnd  ����������һ��Ԫ��
     * @param preorder �����������
     * @param inorder �����������
     * @return ���ع���Ķ���������
     */
    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        //��¼����������и�����λ��
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

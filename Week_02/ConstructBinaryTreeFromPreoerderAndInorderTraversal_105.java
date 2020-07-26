/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //1. ���� ջ
 //2. �ݹ�


// �ⷨ2 �ݹ�
class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0) {
			return null;
		}
		//����ǰ������ĵ�һ��Ԫ�أ��Ϳ���ȷ�����ڵ�
		TreeNode root = new TreeNode(preorder[0]);
		for(int i=0;i<preorder.length;++i) {
			//��preorder[0]ȥ���������в��Ҷ�Ӧ��Ԫ��
			if(preorder[0]==inorder[i]) {
				//��ǰ������ֳ��������룬�ٽ���������ֳ���������
				//֮��ݹ�Ĵ���ǰ���������߲��ֺ������������߲���
				//�ݹ鴦��ǰ�������ұ߲��ֺ����������ұ߲���
				int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
				int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
				int[] in_left = Arrays.copyOfRange(inorder,0,i);
				int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
				root.left = buildTree(pre_left,in_left);
				root.right = buildTree(pre_right,in_right);
				break;
			}
		}
		return root;
	}
}

//��һ��
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //1. 迭代 栈
 //2. 递归


// 解法2 递归
class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0) {
			return null;
		}
		//根据前序数组的第一个元素，就可以确定根节点
		TreeNode root = new TreeNode(preorder[0]);
		for(int i=0;i<preorder.length;++i) {
			//用preorder[0]去中序数组中查找对应的元素
			if(preorder[0]==inorder[i]) {
				//将前序数组分成左右两半，再将中序数组分成左右两半
				//之后递归的处理前序数组的左边部分和中序数组的左边部分
				//递归处理前序数组右边部分和中序数组右边部分
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

//第一遍
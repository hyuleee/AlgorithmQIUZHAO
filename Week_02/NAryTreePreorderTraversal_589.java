/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// 类似二叉树 根-左-右
//1. 递归
//2. 迭代 层序遍历

// 解法1. 递归

class Solution {
    public List<Integer> preorder(Node root) {       
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) {
            helper(node, res);
        }

    }
}

//第一遍
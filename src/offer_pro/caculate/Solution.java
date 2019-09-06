package offer_pro.caculate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/16 15:25
 * @Description:
 */

class Solution {
    public static void main (String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> l = s.preorderTraversal(root);
        System.out.print("result----" + l.toString());
    }

    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> result = new ArrayList<>();//存放结果
        Deque<Guide> path = new ArrayDeque<>();//用
        path.addFirst(new Guide(0, root));

        while (!path.isEmpty()) {
            Guide current = path.removeFirst();
            if (current.node == null) {
                continue;
            }
            if (current.opear == 1) {
                result.add(current.node.value);
            } else {
                path.addFirst(new Guide(0, current.node.right));
                path.addFirst(new Guide(0, current.node.left));
                path.addFirst(new Guide(1, current.node));
            }
        }
        return result;
    }


    private class Guide {
        int opear;//操作类型0访问，1打印
        TreeNode node;

        public Guide (int opear, TreeNode node) {
            this.opear = opear;
            this.node = node;
        }
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode (int value) {
        this.value = value;
    }
}
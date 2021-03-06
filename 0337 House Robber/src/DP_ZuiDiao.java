public class DP_ZuiDiao {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int rob(TreeNode root) {
            int[] res = robSub (root);
            return Math.max (res[0], res[1]);
        }

        private int[] robSub(TreeNode node) {
            if (node == null) {
                return new int[2];
            }

            int[] left = robSub (node.left);
            int[] right = robSub (node.right);

            int[] res = new int[2];

            res[0] = Math.max (left[0], left[1]) + Math.max (right[0], right[1]);
            res[1] = node.val + left[0] + right[0];

            return res;
        }
    }
}

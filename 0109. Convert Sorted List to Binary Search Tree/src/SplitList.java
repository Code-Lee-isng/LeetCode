public class SplitList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Definition for a binary tree node.
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
        public TreeNode sortedListToBST(ListNode head) {
            // corner case
            if (head == null) {
                return null;
            }

            ListNode mid = findMid (head);
            TreeNode root = new TreeNode (mid.val);

            if (head == mid) {
                return root;
            }

            root.left = sortedListToBST (head);
            root.right = sortedListToBST (mid.next);
            return root;
        }

        private ListNode findMid(ListNode head) {
            ListNode slow = head, fast = head, prev = slow;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;
            return slow;
        }
    }
}

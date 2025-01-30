/**
 * # Time complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
 * # Space complexity: O(n), due to the storage of nodes in the queue and result list.
 * # Leetcode: Yes
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                arr.add(curr.val);

                if (curr.left != null) que.add(curr.left);
                if (curr.right != null) que.add(curr.right);
            }
            result.add(arr);
        }
        return result;
    }
}

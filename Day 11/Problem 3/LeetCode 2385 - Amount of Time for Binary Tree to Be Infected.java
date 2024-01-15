
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if (root == null)
            return 0;
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        TreeNode startNode = null;
        while (!que.isEmpty())
        {
            TreeNode curr = que.remove();
            if (curr.val == start)
                startNode = curr;
            if (curr.left != null)
            {
                que.add(curr.left);
                parents.put(curr.left, curr);
            }
            if (curr.right != null)
            {
                que.add(curr.right);
                parents.put(curr.right, curr);
            }
        }
        int depth = 0;
        HashSet<TreeNode> visited = new HashSet<>();
        que.add(startNode);
        visited.add(startNode);
        while(!que.isEmpty())
        {
            System.out.println(que);
            int size = que.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode curr = que.remove();
                TreeNode parent = parents.get(curr);
                if (parents.containsKey(curr) && !visited.contains(parent)) 
                {
                    que.add(parent);
                    visited.add(parent);
                }
                if (curr.left != null && !visited.contains(curr.left))
                {
                    que.add(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right))
                {
                    que.add(curr.right);
                    visited.add(curr.right);
                }
            }
            depth++;
        }
        return depth-1;
    }
}
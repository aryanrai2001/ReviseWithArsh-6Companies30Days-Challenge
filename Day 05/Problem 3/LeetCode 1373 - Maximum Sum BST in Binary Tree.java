class Solution {
    class RetVal {
        boolean isValid;
        int sum;
        int min;
        int max;
        public RetVal(boolean isValid, int sum, int min, int max) {
            this.isValid = isValid;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    public int maxSumBST(TreeNode root) {
        int[] ans = new int[1];
        RetVal result = maxBST(root, ans);
        return ans[0];
    }
    public RetVal maxBST(TreeNode root, int[] ans) {
        if (root == null) {
            return new RetVal(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        RetVal left = maxBST(root.left, ans);
        RetVal right = maxBST(root.right, ans);
        RetVal curr = new RetVal(
            left.isValid && right.isValid &&
            (root.val > left.max && root.val < right.min),
            left.sum + right.sum + root.val,
            Math.min(left.min, root.val),
            Math.max(root.val, right.max)
        );
        if (curr.isValid){
            ans[0] = Math.max(curr.sum, ans[0]);
        }
        return curr;
    }
}
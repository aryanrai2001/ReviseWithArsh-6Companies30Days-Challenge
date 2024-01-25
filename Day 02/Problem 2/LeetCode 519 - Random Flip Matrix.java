class Solution {

    HashSet<Integer> ones;
    int m, n;
    int max;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        max = m*n;
        ones = new HashSet<Integer>();
    }
    
    public int[] flip() {
        int ind;
        do
        {
            ind = (int)(Math.random() * max);
        } while(ones.contains(ind));
        ones.add(ind);
        return new int[]{ind / n, ind % n};
    }
    
    public void reset() {
        ones.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
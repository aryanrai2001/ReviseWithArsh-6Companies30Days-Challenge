class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combRec(k, n, 1);
    }
    public List<List<Integer>> combRec(int k, int n, int j) {
        if (k < 1 || n < 1)
            return null;
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        if (k == 1)
        {
            if (n >= j && n <= 9)
            {
                List<Integer> ar = new ArrayList<Integer>();
                ar.add(n);
                arr.add(ar);
            }
            return arr;
        }
        for (int i = j; i <= 9; i++)
        {
            List<List<Integer>> sub = combRec(k-1, n-i, i+1);
            if (sub != null && sub.size() > 0)
            {
                for (List<Integer> ar : sub)
                {
                    if (ar.contains(i))
                        continue;
                    List<Integer> newAr = new ArrayList<Integer>(k);
                    newAr.add(i);
                    newAr.addAll(ar);
                    arr.add(newAr);
                }
            }
        }
        return arr;
    }
}
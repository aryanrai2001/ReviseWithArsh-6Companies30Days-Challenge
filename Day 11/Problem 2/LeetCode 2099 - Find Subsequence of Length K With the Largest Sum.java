class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        List<Pair<Integer, Integer>> map = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            map.add(new Pair<>(i, nums[i]));
        Collections.sort(map, (Pair<Integer, Integer> a, Pair<Integer, Integer> b) -> {
            int aVal = a.getValue();
            int bVal = b.getValue();
            if (aVal < bVal)
                return 1;
            else if (aVal > bVal)
                return -1;
            else
                return 0;
        });
        List<Pair<Integer, Integer>> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++)
            res.add(map.get(i));
        Collections.sort(res, (Pair<Integer, Integer> a, Pair<Integer, Integer> b) -> {
            int aVal = a.getKey();
            int bVal = b.getKey();
            if (aVal < bVal)
                return -1;
            else if (aVal > bVal)
                return 1;
            else
                return 0;
        });
        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = res.get(i).getValue();
        return arr;
    }
}
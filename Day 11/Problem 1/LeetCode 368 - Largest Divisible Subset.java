class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++)
        {
            List<Integer> set = new ArrayList<Integer>();
            int val1 = nums[i];
            int max = i;
            set.add(val1);
            sets.add(set);
            for (int j = 0; j < i; j++)
            {
                int val2 = nums[j];
                if (val1 % val2 == 0)
                {
                    if (sets.get(max).size() <= sets.get(j).size())
                        max = j;
                }
            }
            if (max != i)
                set.addAll(sets.get(max));
        }
        Collections.sort(sets, (List<Integer> a, List<Integer> b) -> {
            return b.size() - a.size();
        });
        return sets.getFirst();
    }
}
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] answers = new int[queries.length];
        ArrayList<Pair<String, Integer>> numVals = new ArrayList<Pair<String, Integer>>(nums.length);
        for (int i = 0; i < queries.length; i++)
        {
            int k = queries[i][0];
            int trim = queries[i][1];
            for (int j = 0; j < nums.length; j++)
                numVals.add(new Pair<String, Integer>(nums[j].substring(nums[j].length() - trim), j));
            Collections.sort(numVals, (Pair<String, Integer> p1, Pair<String, Integer> p2) -> {
                return p1.getKey().compareTo(p2.getKey());
            });
            answers[i] = numVals.get(k-1).getValue();
            numVals.clear();
        }
        return answers;
    }
}
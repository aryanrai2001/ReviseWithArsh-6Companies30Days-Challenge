class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int total = 0, last = 0;
        for (int y = 0; y < ages.length; y++)
        {
            if (ages[last] != ages[y])
                last = y;
            int yAgeRes = 2 * ages[y] - 14;
            for (int x = last+1; x < ages.length; x++)
            {
                if (yAgeRes <= ages[x])
                    break;
                total++;
            }
        }
        return total;
    }
}
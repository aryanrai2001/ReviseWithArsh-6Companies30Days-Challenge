class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        int start = n;
        int left = n;
        while (left > 1)
        {
            int count = k;
            int index = start;
            while (true)
            {
                index %= n;
                if (arr[index] != -1)
                    count--;
                if (count == 0)
                    break;
                else
                    index++;
            }
            arr[index] = -1;
            start = index;
            left--;
        }
        for (int i = 0; i < n; i++)
            if (arr[i] != -1)
                return arr[i] + 1;
        return -1;
    }
}
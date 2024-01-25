class Solution{
public:
    vector<int> findTwoElement(vector<int> arr, int n) {
        vector<int> ans(2);
        for (int i = 0; i < n; i++)
        {
            int val = arr[i];
            if (val != i+1)
            {
                if (arr[val - 1] == val)
                    continue;
                arr[i--] = arr[val - 1];
                arr[val - 1] = val;
            }
        }
        for (int i = 0; i < n; i++)
        {
            int val = arr[i];
            if (val != i+1)
            {
                ans[0] = val;
                ans[1] = i+1;
            }
        }
        return ans;
    }
};
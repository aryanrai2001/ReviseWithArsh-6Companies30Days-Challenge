class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n <= 10)
            return new ArrayList<String>(0);
        HashMap<String, Integer> freq = new HashMap<>();
        int[] acc = new int[n-9];
        for (int i = 0; i < 10; i++)
            acc[0] += s.charAt(i);
        for (int i = 1; i < acc.length; i++)
            acc[i] = acc[i-1] + s.charAt(i+9) - s.charAt(i-1);
        for (int i = 0; i < acc.length-1; i++)
        {
            int val = acc[i];
            String str = s.substring(i, i + 10);
            if (freq.containsKey(str))
                continue;
            freq.put(str, 1);
            for (int j = i+1; j < acc.length; j++)
            {
                if (acc[j] == val)
                {
                    str = s.substring(j, j + 10);
                    freq.put(str, freq.getOrDefault(str, 0) + 1);
                }
            }
        }
        Object[] entries = freq.entrySet().toArray();
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < entries.length; i++)
        {
            Map.Entry<String, Integer> entry = (Map.Entry) entries[i]; 
            if (entry.getValue() > 1)
                res.add(entry.getKey());
        }
        return res;
    }
}
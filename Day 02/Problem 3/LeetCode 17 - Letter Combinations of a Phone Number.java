class Solution {
    String[] map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        ArrayList<String> combs = new ArrayList<String>((int)Math.pow(3, len));
        if (len == 0)
            return combs;
        char[] comb = new char[len];
        for (int i = 0; i < len; i++)
        {
            int ind = digits.charAt(i) - '2';
            comb[i] = map[ind].charAt(0);
        }
        combs.add(new String(comb));
        int i = len-1;
        int ind = digits.charAt(i) - '2';
        while(nextComb(comb, digits))
            combs.add(new String(comb));
        return combs;
    }

    public boolean nextComb(char[] comb, String digits)
    {
        int i = comb.length - 1;
        while (true)
        {
            int ind = digits.charAt(i) - '2';
            char ch = comb[i];
            ch += 1;
            if (map[ind].lastIndexOf(ch) != -1)
            {
                comb[i] = ch;
                return true;
            }
            else
            {
                if (i == 0)
                    return false;
                comb[i] = map[ind].charAt(0);
                i--;
            }
        }
    }
}
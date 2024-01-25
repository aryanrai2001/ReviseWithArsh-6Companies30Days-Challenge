class Solution {
    public int maxProduct(String s) {
        int len = s.length();
        int end = (1 << len) - 1;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int max = 0;
        for (int mask1 = 0; mask1 < end; mask1++)
        {
            sb1.setLength(0);
            for (int i = 0; i < len; i++)
                if ((mask1 & (1 << (len-1-i))) != 0)
                    sb1.append(s.charAt(i));
            if(!isPalin(sb1.toString()))
                continue;
            for (int mask2 = 0; mask2 < end; mask2++)
            {
                if ((mask1 & mask2) != 0)
                    continue;
                sb2.setLength(0);
                for (int i = 0; i < len; i++)
                    if ((mask2 & (1 << (len-1-i))) != 0)
                        sb2.append(s.charAt(i));
                
                int prod = sb1.length() * sb2.length();
                if (max < prod)
                {
                    if(isPalin(sb2.toString()))
                        max = prod;
                }
            }
        }
        return max;
    }
    private boolean isPalin(String s)
    {
        int len = s.length();
        for (int i = 0; i < len/2; i++)
        {
            if (s.charAt(i) != s.charAt(len-1-i))
                return false;
        }
        return true;
    }
}
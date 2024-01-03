class Solution{
    static String printMinNumberForPattern(String S){
        StringBuilder sb = new StringBuilder();
        StringBuilder curr = new StringBuilder();
        curr.append(1);
        for (int i = 0; i < S.length(); i++)
        {
            char ch = S.charAt(i);
            boolean change = i+1 < S.length() && ch != S.charAt(i+1);
            if (change && ch == 'I')
            {
                sb.append(curr);
                curr.setLength(0);
            }
            if (ch == 'I')
            {
                curr.append(i+2);
            }
            else
            {
                curr.insert(0, i+2);
            }
            if (change && ch == 'D')
            {
                sb.append(curr);
                curr.setLength(0);
            }
        }
        if (curr.length() > 0)
            sb.append(curr);
        return sb.toString();
    }
}
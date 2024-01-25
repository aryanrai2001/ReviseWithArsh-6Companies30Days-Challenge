class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int bulls = 0;
        LinkedList<Character> pos = new LinkedList<Character>();
        LinkedList<Character> neg = new LinkedList<Character>();
        for (int i = 0; i < len; i++)
        {
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if (ch1 == ch2)
                bulls++;
            else
            {
                if (!pos.removeFirstOccurrence(ch2))
                    neg.add(ch2);
                if (!neg.removeFirstOccurrence(ch1))
                    pos.add(ch1);
            }
        }
        int left = Math.max(pos.size(), neg.size());
        int cows = Math.abs(len - bulls - left);
        return bulls + "A" + cows + "B";
    }
}
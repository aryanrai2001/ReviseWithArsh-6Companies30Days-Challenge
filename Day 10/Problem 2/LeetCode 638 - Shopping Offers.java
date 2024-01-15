class Solution {
    HashMap<Integer, Integer> mem = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs)
    {
        int needsInt = 0;
        for (int i = 0; i < needs.size(); i++)
            needsInt |= needs.get(i) << (i << 2);
        mem.put(0, 0);
        return recursiveShoppingOffers(price, special, needsInt);
    }
    public int recursiveShoppingOffers(List<Integer> price, List<List<Integer>> special, int needs) {
        if (mem.containsKey(needs))
            return mem.get(needs);
        int total = 1000;
        for (int i = 0; i < price.size(); i++)
        {
            int val = price.get(i);
            int shift = i << 2;
            int needVal = ((needs >> shift) & 0xf) - 1; 
            if (needVal < 0)
                continue;
            int needsCpy = (needs & ~(0xf << shift)) |  (needVal << shift);
            val += recursiveShoppingOffers(price, special, needsCpy);
            if (val < total)
                total = val;
        }
        outer:
        for (int i = 0; i < special.size(); i++)
        {
            List<Integer> curr = special.get(i);
            int val = curr.getLast();
            int needsCpy = needs;
            for (int j = 0; j < price.size(); j++)
            {
                int shift = j << 2;
                int needVal = ((needsCpy >> shift) & 0xf) - curr.get(j);
                if (needVal < 0)
                    continue outer;
                needsCpy = (needsCpy & ~(0xf << shift)) |  (needVal << shift);
            }
            val += recursiveShoppingOffers(price, special, needsCpy);
            if (val < total)
                total = val;
        }
        mem.put(needs, total);
        return total;
    }
}
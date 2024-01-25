class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stk = new Stack<String>();
        String[] nodes = preorder.split(",");
        for(int i = 0; i < nodes.length; i++)
        {
            stk.push(nodes[i]);
            while (hasTerminal(stk))
            {
                stk.pop();
                stk.pop();
                stk.pop();
                stk.push("#");
            }
        }
        return (stk.size() == 1 && stk.peek().equals("#"));
    }
    private boolean hasTerminal(Stack<String> stk)
    {
        int len = stk.size();
        if (len < 3)
            return false;
        return  (stk.get(len-1).equals("#")) && 
                (stk.get(len-2).equals("#")) && 
                (!stk.get(len-3).equals("#"));
    }
}
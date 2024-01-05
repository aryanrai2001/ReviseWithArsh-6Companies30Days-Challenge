class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<Pair<Integer, Integer>> coords = new LinkedList<Pair<Integer, Integer>>();
        int ylen = isWater.length;
        int xlen = isWater[0].length;
        int[][] heights = new int[ylen][xlen];
        for (int i = 0; i < ylen; i++)
        {
            for (int j = 0; j < xlen; j++)
            {
                heights[i][j] = -1;
                if (isWater[i][j] == 1){
                    coords.add(new Pair<>(i, j));
                    heights[i][j] = 0;
                }
            }
        }
        while (!coords.isEmpty())
        {
            Pair<Integer, Integer> curr = coords.remove();
            int y = curr.getKey();
            int x = curr.getValue();
            int val = heights[y][x] + 1;
            if (x > 0)
            {
                int oldVal = heights[y][x-1];
                if (oldVal == -1)
                {
                    coords.add(new Pair<>(y, x-1));
                    heights[y][x-1] = Math.max(val, oldVal);
                }
            }
            if (x < xlen-1)
            {
                int oldVal = heights[y][x+1];
                if (oldVal == -1)
                {
                    coords.add(new Pair<>(y, x+1));
                    heights[y][x+1] = Math.max(val, oldVal);
                }
            }
            if (y > 0)
            {
                int oldVal = heights[y-1][x];
                if (oldVal == -1)
                {
                    coords.add(new Pair<>(y-1, x));
                    heights[y-1][x] = Math.max(val, oldVal);
                }
            }
            if (y < ylen-1)
            {
                int oldVal = heights[y+1][x];
                if (oldVal == -1)
                {
                    coords.add(new Pair<>(y+1, x));
                    heights[y+1][x] = Math.max(val, oldVal);
                }
            }
        }
        return heights;
    }
}
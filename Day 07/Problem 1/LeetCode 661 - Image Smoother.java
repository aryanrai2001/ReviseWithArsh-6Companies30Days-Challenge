class Solution {
    public int[][] imageSmoother(int[][] img) {
        int h = img.length;
        int w = img[0].length;
        int[][] res = new int[h][w];
        for (int i = 0; i < h; i++)
        {
            int minH = Math.max(0, i-1);
            int maxH = Math.min(i+1, h-1);
            for (int j = 0; j < w; j++)
            {
                int minW = Math.max(0, j-1);
                int maxW = Math.min(j+1, w-1); 
                for (int y = minH; y <= maxH; y++)
                {
                    for (int x = minW; x <= maxW; x++)
                    {
                        res[i][j] += img[y][x];
                    }
                }
                res[i][j] /= (maxH - minH + 1) * (maxW - minW + 1); 
            }
        }
        return res;
    }
}
class Solution {

    int[][] rects;
    int[] numPoints;
    int totalPoints;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.numPoints = new int[rects.length];
        this.totalPoints = 0;
        for (int i = 0; i < rects.length; i++)
        {
            int[] coords = rects[i];
            numPoints[i] = (coords[2] - coords[0] + 1) * (coords[3] - coords[1] + 1);
            totalPoints += numPoints[i];
        }
    }
    
    public int[] pick() {
        int ind = (int)(Math.random() * totalPoints);
        int[] point = new int[2];
        for (int i = 0; i < numPoints.length; i++)
        {
            if (numPoints[i] > ind)
            {
                int[] coords = rects[i];
                int width = (coords[2] - coords[0] + 1);
                int y = ind / width;
                int x = ind % width;
                point[0] = coords[0] + x;
                point[1] = coords[1] + y;
                break;
            }
            else
                ind -= numPoints[i];
        }
        return point;
    }
}
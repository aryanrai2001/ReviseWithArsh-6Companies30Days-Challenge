class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int cX = Math.clamp(xCenter, x1, x2);
        int cY = Math.clamp(yCenter, y1, y2);
        int xDist = cX - xCenter;
        int yDist = cY - yCenter;
        double dist = Math.sqrt(xDist * xDist + yDist * yDist);
        return dist <= radius;
    }
}
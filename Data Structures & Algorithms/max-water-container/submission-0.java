class Solution {
    public int maxArea(int[] heights) {
            int idx_left = 0;
        int idx_right = heights.length - 1;
        int best = 0;
        
        while (idx_left < idx_right) {
            int area = Math.min(heights[idx_left], heights[idx_right]) * (idx_right - idx_left);
            best = Math.max(best, area);
            if (heights[idx_left] < heights[idx_right]) {
                idx_left++;
            } else {
                idx_right--;
            }
        }
        return best;
    }
}

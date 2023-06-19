// 42. Trapping Rain Water
class Solution {
    public int trap(int[] height) {
        // two pointer --time complexityO(n) --space complexityO(1)
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;

        while (left < right) {
            if (leftMax < rightMax) {// we want min(leftMax, rightMax), so no matter how big rightMax value is
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            } else {// we want min(leftMax, rightMax), so no matter how big leftMax value is
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }
        return res;
    }
}
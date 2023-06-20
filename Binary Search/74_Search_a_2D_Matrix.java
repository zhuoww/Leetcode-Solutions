class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // time: O(log(m * n))--m is the number of rows in the matrix and n is the
        // number of columns, it repeatedly
        // divides the search space in half until the target value is found or the
        // search space is exhausted
        // space: O(1)--it uses a constant amount of extra space, the space used does
        // not depend on the input size
        int row = matrix.length;
        int col = matrix[0].length;

        // initializes two pointers
        int left = 0;
        int right = row * col - 1; // last element index, because the first index is 0

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // col: represents the number of elements in each row
            // mid/col: obtain the quotient, calculate the number of complete rows that can
            // be accommodated before the mid index
            // mid%cal: obtain the remainder, the mid index mid might exceed the number of
            // elements in a single row
            int midValue = matrix[mid / col][mid % col];

            if (midValue < target) {
                left = mid + 1;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

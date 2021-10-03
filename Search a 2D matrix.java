class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = (matrix.length * matrix[0].length) - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) start = mid + 1;
            else if (matrix[row][col] > target) end = mid - 1;
        }
        return false;
    }
}

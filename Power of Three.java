public class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}

// This solution is not safe as we are using '==' with double as this can
// cause precision issues instead use and epsilon

public class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
}
